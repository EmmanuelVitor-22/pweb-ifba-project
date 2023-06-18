package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.PacienteDTO;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public ResponseEntity <List<PacienteDTO>> listarTodosPacientes(){
        return ResponseEntity.ok(pacienteRepository.findAll()
                .stream()
                .map(PacienteDTO::new)
                .collect(Collectors.toList())
        );
    }

}
