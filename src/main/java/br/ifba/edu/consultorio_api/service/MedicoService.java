package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.MedicoDTO;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    private ResponseEntity<MedicoDTO> listarMedicosPorNome(String nome) {
        Optional<Medico> medicoOptional = medicoRepository.findByNome(nome);
        if (medicoOptional.isPresent()) {
            Medico medico = medicoOptional.get();
            return ResponseEntity.ok(new MedicoDTO(medico));
        }

        return null;
    }

    public ResponseEntity<List<MedicoDTO>> listarTodosMedicos() {
        return ResponseEntity.ok(medicoRepository.findAll()
                .stream()
                .map(MedicoDTO::new)
                .collect(Collectors.toList()));
    }

    public ResponseEntity<MedicoDTO> criarMedicos(MedicoDTO medicoDTO, UriComponentsBuilder builder) {
        var medico = medicoRepository.save(new Medico(medicoDTO));
        var uri = builder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(medicoDTO);
    }

    public ResponseEntity<MedicoDTO> atualizarMedicos(Long id, MedicoDTO medicoDTO) {
        var data = new Medico(medicoDTO);
        data.setId(id);
        var medico = medicoRepository.save(data);
        return ResponseEntity.ok().body(medicoDTO);
    }

    public ResponseEntity<MedicoDTO> atualizarNomeMedicos(Long id, MedicoDTO medicoDTO) {
        return medicoRepository.findById(id).map(
                record -> {
                    record.setNome(medicoDTO.nome());
                    medicoRepository.save(record);
                    return ResponseEntity.ok().body(medicoDTO);
                }).orElse(ResponseEntity.notFound().build());
    }

}
