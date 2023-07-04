package br.ifba.edu.consultorio_api.dto.request;

import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.time.LocalDateTime;


public record ConsultaDTO(

        Medico medico,
        Paciente paciente,

        LocalDateTime dataHora

) {

        //Construtor que recebe um objeto Consulta e cria um objeto ConsultaDTO com base nos dados da consulta.
        public ConsultaDTO(Consulta consulta) {
                this(
                        consulta.getMedico(),
                        consulta.getPaciente(),
                        consulta.getDataHora()
                );
        }
}
