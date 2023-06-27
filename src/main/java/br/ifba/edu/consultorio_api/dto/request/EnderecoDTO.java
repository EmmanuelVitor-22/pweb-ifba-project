package br.ifba.edu.consultorio_api.dto.request;

import br.ifba.edu.consultorio_api.entities.Endereco;
import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(
         @NotBlank(message = "Logradouro não pode ser nulo ou vazio")
         String logradouro,

         String numero,
         String complemento,
         @NotBlank(message = "Bairro não pode ser nulo ou vazio")
         String bairro,
         @NotBlank(message = "Cidade não pode ser nulo ou vazio")
         String cidade,
         @NotBlank(message = "UF não pode ser nulo ou vazio")
         String uf,
         @NotBlank(message = "CEP não pode ser nulo ou vazio")
         String cep
) {
    public EnderecoDTO(Endereco endereco) {
       this ( endereco.getLogradouro(),
         endereco.getNumero(),
         endereco.getComplemento(),
         endereco.getBairro(),
         endereco.getCidade(),
         endereco.getUf(),
         endereco.getCep()
       );
    }
}
