package br.ifba.edu.consultorio_api.dto.request.update;

import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Medico;

public record MedicoUpdateDTO(
    String nome,


    String telefone,

    Endereco endereco) {


        public MedicoUpdateDTO(Medico medico ) {
            this(
                    medico.getNome(),
                    medico.getTelefone(),
                    medico.getEndereco()
            );
        }
}
