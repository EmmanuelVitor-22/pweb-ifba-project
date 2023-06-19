package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.ConsultaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "consulta")
@Entity(name = "consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    public Medico medico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Paciente paciente;
    @Column
    private LocalDateTime dia_hora;


    public Consulta(ConsultaDTO consultaDTO) {
        this.id = consultaDTO.id();
        this.medico = consultaDTO.medico();
        this.paciente = consultaDTO.paciente();
        this.dia_hora = consultaDTO.dia_hora();
    }

}
