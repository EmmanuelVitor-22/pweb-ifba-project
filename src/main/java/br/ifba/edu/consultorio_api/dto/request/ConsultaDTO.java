package br.ifba.edu.consultorio_api.dto.request;

import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConsultaDTO(

        Medico medico,
        Paciente paciente,

        LocalDateTime data_hora

) {
        public ConsultaDTO(Consulta consulta) {
                this(
                                consulta.getMedico(),
                                consulta.getPaciente(),
                                consulta.getData_hora());
        }
}
