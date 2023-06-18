package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.MedicoDTO;
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
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private String CRM;
    @Column
    private String email;
    @Column
    private String telefone;

    @Enumerated
    @Column
    private Especialidade especialidade = Especialidade.Dermatologia;

    public Medico(MedicoDTO medicoDTO) {
        this.nome = medicoDTO.nome();
        this.CRM = medicoDTO.CRM();
        this.email = medicoDTO.email();
        this.telefone = medicoDTO.telefone();
        this.especialidade = medicoDTO.especialidade();
    }
}
