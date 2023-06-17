package br.ifba.edu.consultorio_api.dto;

import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConsultaDTO(
        UUID id,
        Medico medico,
        Paciente paciente,

        LocalDateTime dia_hora

) {
        public  ConsultaDTO(Consulta consulta){
            this(
                    consulta.getId(),
                    consulta.getMedico(),
                    consulta.getPaciente(),
                    consulta.getDia_hora()
            );
        }
}
