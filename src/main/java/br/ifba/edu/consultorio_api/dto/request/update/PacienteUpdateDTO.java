package br.ifba.edu.consultorio_api.dto.request.update;
import br.ifba.edu.consultorio_api.dto.request.EnderecoDTO;
import br.ifba.edu.consultorio_api.entities.Endereco;
import br.ifba.edu.consultorio_api.entities.Paciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record PacienteUpdateDTO(
        @NotBlank(message = "Nome não pode ser nulo ou vazio")
        String nome,

        @NotBlank(message = "Telefone não pode ser nulo ou vazio")
        String telefone,
        @NotNull(message = "Endereço não pode ser nulo")
        @Valid
        EnderecoDTO endereco

) {
        public PacienteUpdateDTO(Paciente paciente) {
                this(
                                paciente.getNome(),
                                paciente.getTelefone(),
                                new EnderecoDTO(paciente.getEndereco())
                                );
        }
}