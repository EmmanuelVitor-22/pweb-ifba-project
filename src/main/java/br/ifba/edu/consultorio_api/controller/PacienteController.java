package br.ifba.edu.consultorio_api.controller;

import br.ifba.edu.consultorio_api.dto.PacienteResponseDTO;
import br.ifba.edu.consultorio_api.dto.request.PacienteDTO;
import br.ifba.edu.consultorio_api.entities.Paciente;
import br.ifba.edu.consultorio_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/teste")
    public ResponseEntity<Page<PacienteResponseDTO>> listarPacientes(
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, size = 10) Pageable pageable) {
        Page<PacienteResponseDTO> pacientesDTO = pacienteService.listarPacientesOrdenadosEPageados(pageable);
        return ResponseEntity.ok(pacientesDTO);
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

    @PutMapping("/{id}")

        public ResponseEntity<PacienteDTO> atualizarPaciente(@PathVariable  Long id, @RequestBody PacienteDTO pacienteDTO) {
        return pacienteService.atualizarPaciente(id, pacienteDTO);
    }
}
