package br.ifba.edu.consultorio_api.dto.response;

import br.ifba.edu.consultorio_api.enuns.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;

public record  MedicoResponseDTO(

        String nome,
        String email,
        String CRM,
        Especialidade especialidade) {


   //Construtor que recebe um objeto Medico e cria um objeto MedicoResponseDTO com base nos dados do médico.
    public MedicoResponseDTO(Medico medico) {
        this(
                medico.getNome(),
                medico.getEmail(),
                medico.getCRM(),
                medico.getEspecialidade());
    }
}
