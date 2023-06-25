package br.ifba.edu.consultorio_api.dto;

import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.util.UUID;


public record PacienteResponseDTO(
        Long id,

        String nome,

        String email,
        Boolean status,
        String CPF,
        Endereco endereco

) {
    public PacienteResponseDTO(Paciente paciente) {
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.isStatus(),
                paciente.getCPF(),
                paciente.getEndereco()
        );

    }
}