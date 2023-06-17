package br.ifba.edu.consultorio_api.dto;

import br.ifba.edu.consultorio_api.entities.Especialidade;

public record PacienteDTO(
        Long id,
        String nome,
        String CPF,
        String email,

        String telefone

) {
}
