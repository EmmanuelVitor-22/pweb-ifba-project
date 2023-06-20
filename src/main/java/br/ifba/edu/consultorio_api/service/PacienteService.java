package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.PacienteResponseDTO;
import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.request.PacienteDTO;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
import br.ifba.edu.consultorio_api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

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

    public ResponseEntity<List<PacienteResponseDTO>> listarPorLetraPaciente( String letra) {
        return ResponseEntity.ok(
                pacienteRepository.findByNomeStartingWithIgnoreCase(letra).
                        stream().
                        map(PacienteResponseDTO::new)
                        .collect(Collectors.toList())
        );

    }

    public ResponseEntity<PacienteDTO> inserirPaciente(PacienteDTO pacienteDTO, UriComponentsBuilder builder) {
        var paciente = pacienteRepository.save(new Paciente(pacienteDTO));
        var uri = builder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(pacienteDTO);
    }

    public ResponseEntity<PacienteDTO> atualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        var data = new Paciente(pacienteDTO);
        data.setId(id);
        var paciente = pacienteRepository.save(data);
        return ResponseEntity.ok().body(pacienteDTO);
    }

}



