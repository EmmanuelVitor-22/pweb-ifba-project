package br.ifba.edu.consultorio_api.dto.request;
import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Paciente;

import java.util.UUID;


public record PacienteDTO(
                String nome,
                String email,
                String telefone,
                String CPF,
                Endereco endereco

) {
        public PacienteDTO(Paciente paciente) {
                this(
                                paciente.getNome(),
                                paciente.getEmail(),
                                paciente.getTelefone(),
                                paciente.getCPF(),
                                paciente.getEndereco()
                                );
        }
}