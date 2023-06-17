package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {

}
