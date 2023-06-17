package br.ifba.edu.consultorio_api.controller;

import br.ifba.edu.consultorio_api.dto.MedicoDTO;
import br.ifba.edu.consultorio_api.repository.MedicoRepository;
import br.ifba.edu.consultorio_api.service.MedicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(path = "/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;


    @GetMapping
    public ResponseEntity<List<MedicoDTO>> listarMedicos(){
        return medicoService.listarTodosMedicos();
    }
    @PostMapping
    public  ResponseEntity<MedicoDTO> criarMedico(@RequestBody MedicoDTO medicoDTO, UriComponentsBuilder builder){
        return medicoService.criarMedicos(medicoDTO, builder);

    }
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<MedicoDTO> atualizarGeral(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO){
        return medicoService.atualizarMedicos(id,medicoDTO);
    }
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<MedicoDTO> atualizarNome(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO){
        return medicoService.atualizarNomeMedicos(id,medicoDTO);
    }
}