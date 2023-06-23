package br.ifba.edu.consultorio_api.dto.request;

import br.ifba.edu.consultorio_api.entities.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;
import jakarta.persistence.Enumerated;

import java.util.UUID;

public record MedicoDTO(

        String nome,
        String CRM,
        String email,

        String telefone,

        Especialidade especialidade) {


        public MedicoDTO(Medico medico) {
                this(
                                medico.getNome(),
                                medico.getCRM(),
                                medico.getEmail(),
                        medico.getTelefone(),
                                medico.getEspecialidade()
                );
        }
}