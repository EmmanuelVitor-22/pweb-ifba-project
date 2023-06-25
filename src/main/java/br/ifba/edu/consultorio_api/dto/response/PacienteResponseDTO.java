package br.ifba.edu.consultorio_api.dto;

import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.util.UUID;


public record PacienteResponseDTO(

        String nome,

        String email,

        String CPF,
        Endereco endereco

) {
    public PacienteResponseDTO(Paciente paciente) {
        this(
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCPF(),
                paciente.getEndereco()
        );

    }
}