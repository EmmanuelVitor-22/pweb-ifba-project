package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.request.MedicoDTO;
import jakarta.persistence.*;
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
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String CRM;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especialidade especialidade = Especialidade.Dermatologia;

    public Medico(MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.CRM = medicoDTO.CRM();
        this.email = medicoDTO.email();
        this.telefone = medicoDTO.telefone();
        this.especialidade = medicoDTO.especialidade();
    }
}
