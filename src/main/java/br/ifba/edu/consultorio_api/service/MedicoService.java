package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.PacienteResponseDTO;
import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.request.update.MedicoUpdateDTO;
import br.ifba.edu.consultorio_api.dto.response.MedicoResponseDTO;
import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
import br.ifba.edu.consultorio_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    private ResponseEntity<MedicoResponseDTO> listarMedicosPorNome(String nome) {
        Optional<Medico> medicoOptional = medicoRepository.findByNome(nome);
        if (medicoOptional.isPresent()) {
            Medico medico = medicoOptional.get();
            return ResponseEntity.ok(new MedicoResponseDTO(medico));
        }

        return null;
    }

    public ResponseEntity<List<MedicoResponseDTO>> listarTodosMedicos() {
        return ResponseEntity.ok(medicoRepository.findAll()
                .stream()
                .map(MedicoResponseDTO::new)
                .collect(Collectors.toList()));
    }
//    public Page<MedicoResponseDTO> listarMedicosOrdenadosEPageados(Pageable pageable) {
//        Page<Medico> medicos = medicoRepository.findAll(pageable);
//        return medicos.map(MedicoResponseDTO::new);
//    }

    public Page<MedicoResponseDTO> listarMedicosOrdenados(Pageable pageable) {
        Page<Medico> medicos = medicoRepository.findAllOrderByNomeIgnoringPrefix(pageable);
        return medicos.map(MedicoResponseDTO::new);
    }

    public ResponseEntity<MedicoDTO> criarMedicos(MedicoDTO medicoDTO, UriComponentsBuilder builder) {
        var medico = medicoRepository.save(new Medico(medicoDTO));
        var uri = builder.path("/medicos/cadastrar").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(medicoDTO);
    }



    public ResponseEntity<MedicoUpdateDTO> atualizarMedico(Long id, MedicoUpdateDTO medicoUpdateDTO) {
        Optional<Medico> medicoOptional = medicoRepository.findById(id);
        if (medicoOptional.isPresent()){
            Medico medico = medicoOptional.get();
            medico.setNome(medicoUpdateDTO.nome());
            medico.setTelefone(medicoUpdateDTO.telefone());
            medico.setEndereco(new Endereco(medicoUpdateDTO.endereco()));

            medicoRepository.save(medico);

            return ResponseEntity.ok().body(medicoUpdateDTO);
        }
        return ResponseEntity.notFound().build();
    }

    public boolean deletarMedico(Long id) {
        Optional<Medico> medicoOptional = medicoRepository.findById(id);
        if (medicoOptional.isPresent()) {
            Medico medico = medicoOptional.get();
            medico.setStatus(false);
            medicoRepository.save(medico);
            return true;
        } else {
            return false;
        }
    }

    public Medico buscarMedicoPorId(Long medicoId) {
        return medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado."));
    }

}
