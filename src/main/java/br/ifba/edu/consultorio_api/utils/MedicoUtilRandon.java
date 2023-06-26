package br.ifba.edu.consultorio_api.utils;

import br.ifba.edu.consultorio_api.entities.Medico;

import java.util.List;

public class MedicoUtilRandon {
    public static Medico escolherMedicoAleatorio(List<Medico> medicos) {
        int tamanhoLista = medicos.size();
        if (tamanhoLista > 0) {
            int index = (int) (Math.random() * tamanhoLista);
            return medicos.get(index);
        } else {
            throw new RuntimeException("Não há médicos disponíveis para agendamento.");
        }
    }


}


