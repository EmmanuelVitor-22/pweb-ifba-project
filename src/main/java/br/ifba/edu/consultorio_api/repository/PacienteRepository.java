package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
