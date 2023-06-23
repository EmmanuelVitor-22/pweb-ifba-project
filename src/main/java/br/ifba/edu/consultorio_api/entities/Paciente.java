package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.PacienteResponseDTO;
import br.ifba.edu.consultorio_api.dto.request.PacienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Table(name = "paciente")
@Entity(name = "paciente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    @CPF
    private String CPF;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private boolean status;
    @Column(nullable = false)
    @Embedded
    private Endereco endereco;


    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.nome();
        this.CPF = pacienteDTO.CPF();
        this.email = pacienteDTO.email();
        this.telefone = pacienteDTO.telefone();
    }

}
