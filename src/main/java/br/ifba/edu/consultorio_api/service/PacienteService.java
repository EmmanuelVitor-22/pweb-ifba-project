package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.PacienteResponseDTO;
import br.ifba.edu.consultorio_api.dto.request.PacienteDTO;
import br.ifba.edu.consultorio_api.entities.Paciente;
import br.ifba.edu.consultorio_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;
    Sort sort = Sort.by("nome").ascending();
    Pageable pageable = PageRequest.of(0,10,sort);
    public ResponseEntity <List<PacienteResponseDTO>> listarTodosPacientes(){
        return ResponseEntity.ok(pacienteRepository.findAll()
                .stream()
                .map(PacienteResponseDTO::new)
                .collect(Collectors.toList())
        );
    }

    public ResponseEntity<List<PacienteResponseDTO>> listarPorNomePaciente(String nome) {
        return ResponseEntity.ok(pacienteRepository.findByNome(nome)
                .stream()
                .map(paciente -> new PacienteResponseDTO(paciente.nome(), paciente.CPF(), paciente.email()))
                .collect(Collectors.toList()));
    }



    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PacienteDTO> inserirPaciente(PacienteDTO pacienteDTO, UriComponentsBuilder builder) {
        var paciente = pacienteRepository.save(new Paciente(pacienteDTO));
        var uri = builder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(pacienteDTO);
    }

    public ResponseEntity<PacienteDTO> atualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        var data = new Paciente(pacienteDTO);
        data.setId(id);
        var paciente = pacienteRepository.save(data);
        var pacienteDtoAtualizado = new PacienteDTO(paciente);
        return ResponseEntity.ok().body(pacienteDtoAtualizado);
    }

}



