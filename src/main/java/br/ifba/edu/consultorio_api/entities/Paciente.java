package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.request.PacienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "paciente")
@Entity(name = "paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private String CPF;
    @Column
    private String email;
    @Column
    private String telefone;

    public Paciente(PacienteDTO pacienteDTO) {
        this.id = pacienteDTO.id();
        this.nome = pacienteDTO.nome();
        this.CPF = pacienteDTO.CPF();
        this.email = pacienteDTO.email();
        this.telefone = pacienteDTO.telefone();
    }
}
