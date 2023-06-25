package br.ifba.edu.consultorio_api.service;

import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import br.ifba.edu.consultorio_api.dto.request.update.MedicoUpdateDTO;
import br.ifba.edu.consultorio_api.dto.response.MedicoResponseDTO;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
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

    public ResponseEntity<MedicoDTO> criarMedicos(MedicoDTO medicoDTO, UriComponentsBuilder builder) {
        var medico = medicoRepository.save(new Medico(medicoDTO));
        var uri = builder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(medicoDTO);
    }

//    public ResponseEntity<MedicoDTO> atualizarMedicos(Long id, MedicoDTO medicoDTO) {
//        var data = new Medico(medicoDTO);
//        data.setId(id);
//        var medico = medicoRepository.save(data);
//        return ResponseEntity.ok().body(medicoDTO);
//    }

//    public ResponseEntity<?> atualizarMedicos(Long id, MedicoDTO medicoDTO) {
//        return medicoRepository.findById(id).map(
//                medico -> {
//                    if (!medicoDTO.email().equals(medico.getEmail())){
//                        return  ResponseEntity.badRequest().body("Não é permitido alterar o e-mail do medico.");
//                    }
//                    if(!medicoDTO.CRM().equals(medico.getCRM())){
//                        return  ResponseEntity.badRequest().body("Não é permitido alterar o CRM do medico");
//                    }
//                    if (medicoDTO.especialidade().equals(medico.getEspecialidade())){
//                        return  ResponseEntity.badRequest().body("Não é permitido alterar a especialidade do medico.");
//                    }
//                    medico.setNome(medicoDTO.nome());
//                    medico.setTelefone(medicoDTO.telefone());
//                    medico.setEndereco(medicoDTO.endereco());
//                    medicoRepository.save(medico);
//                    return ResponseEntity.ok().body(medicoDTO);
//                }).orElse(ResponseEntity.notFound().build());
//    }

    public ResponseEntity<MedicoUpdateDTO> atualizarMedicos(Long id, MedicoUpdateDTO medicoUpdateDTO) {
        Optional<Medico> medicoOptional = medicoRepository.findById(id);
        if (medicoOptional.isPresent()){
            Medico medico = medicoOptional.get();
            medico.setNome(medicoUpdateDTO.nome());
            medico.setTelefone(medicoUpdateDTO.telefone());
            medico.setEndereco(medicoUpdateDTO.endereco());

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

}
