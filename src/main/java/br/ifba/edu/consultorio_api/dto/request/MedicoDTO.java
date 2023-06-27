package br.ifba.edu.consultorio_api.dto.request;

import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.enuns.Especialidade;
import br.ifba.edu.consultorio_api.entities.Medico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicoDTO(

        @NotBlank(message = "Nome não pode ser nulo ou vazio")
        String nome,
        @NotBlank(message = "Nome não pode ser nulo ou vazio")
        String CRM,
        @NotBlank(message = "Email não pode ser nulo ou vazio")
        @Email
        String email,
        @NotBlank(message = "Telefone não pode ser nulo ou vazio")
        String telefone,
        @NotBlank(message = "Especialidade não pode ser nulo ou vazio")
        Especialidade especialidade,
        @NotNull(message = "Endereco não pode ser nulo ")
        @Valid
        EnderecoDTO endereco) {


        public MedicoDTO(Medico medico) {
                this(
                        medico.getNome(),
                        medico.getCRM(),
                        medico.getEmail(),
                        medico.getTelefone(),
                        medico.getEspecialidade(),
                        new EnderecoDTO(medico.getEndereco())
                );
        }
}