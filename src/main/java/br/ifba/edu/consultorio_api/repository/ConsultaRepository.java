package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByMedicoAndDataHora(Medico medico, LocalDateTime dataHora);
    List<Consulta> findByPacienteAndData(Paciente paciente, LocalDateTime dataHora);

}
