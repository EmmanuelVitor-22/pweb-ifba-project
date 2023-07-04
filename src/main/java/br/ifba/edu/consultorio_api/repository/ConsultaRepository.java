package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Boolean existsByCancelamentoNullAndPacienteIdAndDataHoraBetween(Long pacienteId, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
    Boolean existsByMedicoIdAndDataHoraAndCancelamentoIsNull(Long medicoId, LocalDateTime localDateTime);

}
