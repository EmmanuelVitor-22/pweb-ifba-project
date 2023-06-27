package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.request.ConsultaDTO;
import br.ifba.edu.consultorio_api.dto.request.create.ConsultaCreateDTO;
import br.ifba.edu.consultorio_api.dto.response.ConsultaResponseDTO;
import br.ifba.edu.consultorio_api.enuns.MotivoCancelamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "consulta")
@Entity(name = "consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    public Medico medico;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Paciente paciente;
    @Column(nullable = false)
    private LocalDateTime dataHora;
    private boolean status = true;
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento cancelamento;

    public Consulta(ConsultaDTO consultaDTO) {
        this.medico = consultaDTO.medico();
        this.paciente = consultaDTO.paciente();
        this.dataHora = consultaDTO.dataHora();
    }
    public Consulta(ConsultaResponseDTO consultaDTO) {
        this.id =  consultaDTO.id();
        this.medico = consultaDTO.medico();
        this.paciente = consultaDTO.paciente();
        this.dataHora = consultaDTO.dataHora();
    }
   
}
