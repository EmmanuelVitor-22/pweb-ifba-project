package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
     Optional<Medico> findByNome(String nome);

     List<Medico> findAllByStatusTrue();
//     List<Medico> findByConsultasDataHoraNot(LocalDateTime dataHora);


}
