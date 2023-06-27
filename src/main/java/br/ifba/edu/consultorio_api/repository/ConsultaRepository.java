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

    Boolean existsByCancelamentoNullAndPacienteIdAndDataHoraBetween(Long pacienteId, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);


    Boolean existsByMedicoIdAndDataHoraAndCancelamentoIsNull(Long medicoId, LocalDateTime localDateTime);



}
