package br.ifba.edu.consultorio_api.entities;

import br.ifba.edu.consultorio_api.dto.request.ConsultaDTO;
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
    @Column
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "O ID do medico é obrigatório")
    public Medico medico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "O ID do paciente é obrigatório")
    private Paciente paciente;
    @Column
    private LocalDateTime data_hora;
    private boolean status = true;
    private String cancelamento;


    public Consulta(ConsultaDTO consultaDTO) {
        this.id = consultaDTO.id();
        this.medico = consultaDTO.medico();
        this.paciente = consultaDTO.paciente();
        this.data_hora = consultaDTO.data_hora();
    }

}
