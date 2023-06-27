package br.ifba.edu.consultorio_api.dto.request;
import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Paciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record PacienteDTO(
                @NotBlank(message = "Nome não pode ser nulo ou vazio")
                String nome,
                @NotBlank(message = "Email não pode ser nulo ou vazio")
                String email,
                @NotBlank(message = "Telefone não pode ser nulo ou vazio")
                String telefone,
                @NotBlank(message = "CPF não pode ser nulo ou vazio")
                String CPF,
                @NotNull(message = "Endereço não pode ser vazio")
                @Valid
                EnderecoDTO endereco


) {
        public PacienteDTO(Paciente paciente) {
                this(
                                paciente.getNome(),
                                paciente.getEmail(),
                                paciente.getTelefone(),
                                paciente.getCPF(),
                                new EnderecoDTO(paciente.getEndereco())
                                );
        }

}