package br.ifba.edu.consultorio_api.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne (cascade = CascadeType.ALL)
    public Medico medico;

    @ManyToOne (cascade = CascadeType.ALL)
    private Paciente paciente;

    private LocalDateTime dia_hora;

}
