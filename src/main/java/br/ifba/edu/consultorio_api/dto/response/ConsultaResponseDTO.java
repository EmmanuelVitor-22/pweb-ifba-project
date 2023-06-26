package br.ifba.edu.consultorio_api.dto.response;

import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.time.LocalDateTime;

public record ConsultaResponseDTO(
        Long id,
        Medico medico,
        Paciente paciente,

        LocalDateTime data_hora
) {
    public ConsultaResponseDTO(Consulta consulta) {
        this(
                consulta.getId(),
                consulta.getMedico(),
                consulta.getPaciente(),
                consulta.getData_hora());
    }
}
