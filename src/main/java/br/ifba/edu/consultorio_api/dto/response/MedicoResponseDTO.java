package br.ifba.edu.consultorio_api.dto.response;

import br.ifba.edu.consultorio_api.entities.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;

public record  MedicoResponseDTO(

        String nome,
        String CRM,
        String email,


        Especialidade especialidade) {


    public MedicoResponseDTO(Medico medico) {
        this(
                medico.getNome(),
                medico.getCRM(),
                medico.getEmail(),
                medico.getEspecialidade());
    }
}
