package br.ifba.edu.consultorio_api.validation;


import jakarta.validation.ValidationException;

import java.time.LocalDateTime;

public class AntecedenciaMinimaValidation {

    private static final long MINUTOS_ANTECEDENCIA_MINIMA = 30;

    public static void validarAntecedenciaMinima(LocalDateTime dataHoraConsulta) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime antecedenciaMinima = agora.plusMinutes(MINUTOS_ANTECEDENCIA_MINIMA);

        if (dataHoraConsulta.isBefore(antecedenciaMinima)) {
            throw new ValidationException("Não é possível agendar a consulta. Antecedência mínima não atendida.");
        }
    }
}
