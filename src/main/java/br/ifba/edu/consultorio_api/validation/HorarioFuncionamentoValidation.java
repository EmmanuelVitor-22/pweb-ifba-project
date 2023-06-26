package br.ifba.edu.consultorio_api.validation;

import jakarta.validation.ValidationException;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class HorarioFuncionamentoValidation {

    private static final LocalTime HORA_ABERTURA = LocalTime.of(7, 0);
    private static final LocalTime HORA_FECHAMENTO = LocalTime.of(19, 0);

    public static void validarHorarioFuncionamento(DayOfWeek diaSemana, LocalTime horaConsulta) {
        if (diaSemana == DayOfWeek.SUNDAY || (diaSemana == DayOfWeek.SATURDAY && horaConsulta.isAfter(HORA_FECHAMENTO))
                || horaConsulta.isBefore(HORA_ABERTURA) || horaConsulta.isAfter(HORA_FECHAMENTO)) {
            throw new ValidationException("Não é possível agendar a consulta. Horário fora do funcionamento da clínica.");
        }
    }
}
