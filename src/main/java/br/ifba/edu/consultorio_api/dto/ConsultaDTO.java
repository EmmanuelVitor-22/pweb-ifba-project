package br.ifba.edu.consultorio_api.dto;

import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.time.LocalDateTime;

public record ConsultaDTO(
        Medico medico,
        Paciente paciente,

        LocalDateTime dia_hora

) {
}
