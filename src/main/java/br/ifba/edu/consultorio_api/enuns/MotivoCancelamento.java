package br.ifba.edu.consultorio_api.enuns;


import jakarta.persistence.Enumerated;


public enum MotivoCancelamento {
    PACIENTE_DESISTIU,
    MEDICO_CANCELOU,
    OUTROS;
}