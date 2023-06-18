package br.ifba.edu.consultorio_api.dto;

import br.ifba.edu.consultorio_api.entities.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;


public record PacienteDTO(
                Long id,
                String nome,
                String CPF,
                String email,
                String telefone

) {
        public PacienteDTO(Paciente paciente) {
                this(paciente.getId(),
                                paciente.getNome(),
                                paciente.getCPF(),
                                paciente.getEmail(),
                                paciente.getTelefone());
        }
}