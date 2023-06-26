package br.ifba.edu.consultorio_api.validation;

import br.ifba.edu.consultorio_api.entities.Medico;

public class MedicoValidation {
    public static boolean isMedicoAtivo(Medico medico) {
        return medico != null && medico.isStatus();
    }
}
