package br.ifba.edu.consultorio_api.validation;

import br.ifba.edu.consultorio_api.entities.Paciente;

public class PacienteValidation {

    public static boolean isPacienteAtivo(Paciente paciente) {
        return paciente != null && paciente.isStatus();
    }
}
