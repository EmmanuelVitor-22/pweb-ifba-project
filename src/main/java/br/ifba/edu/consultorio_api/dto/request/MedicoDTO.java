package br.ifba.edu.consultorio_api.dto.request;

import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.enuns.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;

public record MedicoDTO(

        String nome,
        String CRM,
        String email,

        String telefone,

        Especialidade especialidade,
        Endereco endereco) {


        public MedicoDTO(Medico medico) {
                this(
                        medico.getNome(),
                        medico.getCRM(),
                        medico.getEmail(),
                        medico.getTelefone(),
                        medico.getEspecialidade(),
                        medico.getEndereco()
                );
        }
}