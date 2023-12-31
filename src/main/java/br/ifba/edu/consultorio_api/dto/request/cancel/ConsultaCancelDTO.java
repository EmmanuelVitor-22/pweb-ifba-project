package br.ifba.edu.consultorio_api.dto.request.cancel;

import br.ifba.edu.consultorio_api.enuns.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaCancelDTO(
        @NotNull(message = "Consulta não pode ser nulo")
        Long consultaId,
        @NotNull
        MotivoCancelamento cancelamento

) {


}
