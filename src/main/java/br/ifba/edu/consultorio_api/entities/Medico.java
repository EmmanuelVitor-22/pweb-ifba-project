package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.MedicoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CRM;
    private String email;

    private String telefone;

    @Enumerated
    private  Especialidade especialidade= Especialidade.Dermatologia;

    public Medico(MedicoDTO medicoDTO) {
        this.nome =medicoDTO.nome();
        this.CRM = medicoDTO.CRM();
        this.email = medicoDTO.email();
        this.telefone = medicoDTO.telefone();
        this.especialidade = medicoDTO.especialidade();
    }
}
