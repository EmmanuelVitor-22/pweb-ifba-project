package br.ifba.edu.consultorio_api.dto.request;

import br.ifba.edu.consultorio_api.entities.Endereco;

public record EnderecoDTO(
         String logradouro,
         String numero,
         String complemento,
         String bairro,
         String cidade,
         String uf,
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
