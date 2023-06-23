package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.request.EnderecoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
        @Column(nullable = false)
        private String logradouro;
        @Column(nullable = false)
        private String numero;
        private String complemento;
        @Column(nullable = false)
        private String bairro;
        @Column(nullable = false)
        private String cidade;
        @Column(nullable = false)
        private String uf;
        @Column(nullable = false)
        private String cep;

    public Endereco(EnderecoDTO enderecoDTO) {
        this.logradouro = enderecoDTO.logradouro();
        this.numero = enderecoDTO.numero();
        this.complemento = enderecoDTO.complemento();
        this.bairro = enderecoDTO.bairro();
        this.cidade = enderecoDTO.cidade();
        this.uf = enderecoDTO.uf();
        this.cep = enderecoDTO.cep();
    }
}
