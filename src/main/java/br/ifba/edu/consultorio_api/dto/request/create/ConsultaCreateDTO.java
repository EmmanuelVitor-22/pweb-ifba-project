package br.ifba.edu.consultorio_api.dto.request.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaCreateDTO(

        Long medicoId,
        @NotNull(message = "Paciente não pode ser nulo ")
        Long pacienteId,
        @NotNull(message = "Data Hora não pode ser nulo ")
        LocalDateTime dataHora

) {


}
