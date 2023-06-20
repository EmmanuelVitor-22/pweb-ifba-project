package br.ifba.edu.consultorio_api.dto.request;

import br.ifba.edu.consultorio_api.entities.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.util.UUID;


public record PacienteDTO(
                Long id,
                String nome,
                String email,
                String telefone

) {
        public PacienteDTO(Paciente paciente) {
                this(paciente.getId(),
                                paciente.getNome(),
                                paciente.getEmail(),
                                paciente.getTelefone());
        }
}