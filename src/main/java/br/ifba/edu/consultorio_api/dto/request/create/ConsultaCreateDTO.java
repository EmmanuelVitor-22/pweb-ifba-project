package br.ifba.edu.consultorio_api.dto.request.create;

import java.time.LocalDateTime;

public record ConsultaCreateDTO(
        Long medicoId,
        Long pacienteId,
        LocalDateTime dataHora

) {


}
