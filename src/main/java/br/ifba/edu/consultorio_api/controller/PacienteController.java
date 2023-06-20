package br.ifba.edu.consultorio_api.controller;

import br.ifba.edu.consultorio_api.dto.PacienteResponseDTO;
import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.request.PacienteDTO;
import br.ifba.edu.consultorio_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listaDePacientes() {
        return pacienteService.listarTodosPacientes();
    }
    @GetMapping("/buscar-por-nome")
    public ResponseEntity<List<PacienteResponseDTO>> buscarPorNome(@RequestParam("nome") String nome) {
        return pacienteService.listarPorNomePaciente(nome);
    }
    @GetMapping("/busca-por-letra")
    public ResponseEntity<List<PacienteResponseDTO>> buscrPoLetra(@RequestParam("letra") String letra){
        return  pacienteService.listarPorLetraPaciente(letra);
    }
    @PostMapping
    public ResponseEntity<PacienteDTO> inserirPaciente(@RequestBody PacienteDTO pacienteDTO, UriComponentsBuilder builder) {
        return pacienteService.inserirPaciente(pacienteDTO, builder);

    }

}
