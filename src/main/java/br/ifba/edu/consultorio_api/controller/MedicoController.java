package br.ifba.edu.consultorio_api.controller;

import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.request.update.MedicoUpdateDTO;
import br.ifba.edu.consultorio_api.dto.response.MedicoResponseDTO;
import br.ifba.edu.consultorio_api.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public ResponseEntity<List<MedicoResponseDTO>> listarMedicos() {
        return medicoService.listarTodosMedicos();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/ordenados")
    public ResponseEntity<Page<MedicoResponseDTO>> listarMedicosOrdenadosPaginados(
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, size = 10) Pageable pageable) {
        Page<MedicoResponseDTO> medicoResponseDTO = medicoService.listarMedicosOrdenados(pageable);
        return ResponseEntity.ok(medicoResponseDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("cadastrar")
    public ResponseEntity<MedicoDTO> criarMedico(@RequestBody @Valid MedicoDTO medicoDTO, UriComponentsBuilder builder) {
        return medicoService.criarMedicos(medicoDTO, builder);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<MedicoUpdateDTO> atualizarMedico(@PathVariable Long id, @RequestBody @Valid MedicoUpdateDTO medicoUpdateDTO) {
        return medicoService.atualizarMedico(id, medicoUpdateDTO);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<MedicoUpdateDTO> deletarPaciente(@PathVariable Long id) {
        boolean medicoDeletado = medicoService.deletarMedico(id);
        if (medicoDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
