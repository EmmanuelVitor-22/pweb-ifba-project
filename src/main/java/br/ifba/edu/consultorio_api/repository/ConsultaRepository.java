package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.entities.Consulta;
import br.ifba.edu.consultorio_api.entities.Medico;
import br.ifba.edu.consultorio_api.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
//    List<Consulta> findByData(LocalDateTime localDateTime);

    List<Consulta> findByMedico(Optional<Medico> medico);

    List<Consulta> findByPaciente(Optional<Paciente> paciente);
    List<Consulta> findByMedicoAndData_Hora(Medico medico, LocalDateTime dataHora);
    List<Consulta> findByPacienteAndData(Paciente paciente, LocalDateTime dataHora);

}
