package br.ifba.edu.consultorio_api.dto;

import br.ifba.edu.consultorio_api.entities.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;
import jakarta.persistence.Enumerated;

public record MedicoDTO(
                Long id,
                String nome,
                String CRM,
                String email,

                String telefone,

                Especialidade especialidade) {

        public MedicoDTO(Medico medico) {
                this(medico.getId(),
                                medico.getNome(),
                                medico.getCRM(),
                                medico.getEmail(),
                                medico.getTelefone(),
                                medico.getEspecialidade());
        }
}