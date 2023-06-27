package br.ifba.edu.consultorio_api.controller;

import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.request.update.MedicoUpdateDTO;
import br.ifba.edu.consultorio_api.dto.request.update.PacienteUpdateDTO;
import br.ifba.edu.consultorio_api.dto.response.MedicoResponseDTO;
import br.ifba.edu.consultorio_api.service.MedicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(  "/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/medicos")
    public ResponseEntity<List<MedicoResponseDTO>> listarMedicos() {
        return medicoService.listarTodosMedicos();
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> criarMedico(@RequestBody MedicoDTO medicoDTO, UriComponentsBuilder builder) {
        return medicoService.criarMedicos(medicoDTO, builder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoUpdateDTO> atualizarMedicos(@PathVariable Long id, @RequestBody MedicoUpdateDTO medicoUpdateDTO) {
        return medicoService.atualizarMedicos(id, medicoUpdateDTO);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicoUpdateDTO> deletarPaciente(@PathVariable Long id) {
        boolean medicoDeletado = medicoService.deletarMedico(id);
        if (medicoDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @PutMapping("medicos/geral/{id}")
//    @Transactional
//    public ResponseEntity<MedicoDTO> atualizarGeral(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
//        return medicoService.atualizarMedicos(id, medicoDTO);
//    }
//
//    @PutMapping("{id}")
//    @Transactional
//    public ResponseEntity<MedicoDTO> atualizarNome(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
//        return medicoService.atualizarMedicos(id, medicoDTO);
//    }
}
