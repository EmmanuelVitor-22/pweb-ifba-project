package br.ifba.edu.consultorio_api.dto;

import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Paciente;


public record PacienteResponseDTO(

        String nome,

        String email,

        String CPF

) {
    public PacienteResponseDTO(Paciente paciente) {
        this(

                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCPF()

        );

    }


}