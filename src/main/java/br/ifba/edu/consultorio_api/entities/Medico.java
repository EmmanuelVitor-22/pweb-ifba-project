package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import br.ifba.edu.consultorio_api.enuns.Especialidade;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "medico")
@Entity(name = "medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String CRM;
    @Column(nullable = false)
    @NotBlank
    @Email
    private String email;
    @Column(nullable = false)
    private String telefone;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especialidade especialidade = Especialidade.Dermatologia;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    @Embedded
    private Endereco endereco;


    public Medico(MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.CRM = medicoDTO.CRM();
        this.email = medicoDTO.email();
        this.telefone = medicoDTO.telefone();
        this.especialidade = medicoDTO.especialidade();
        this.endereco = medicoDTO.endereco();
    }
}
