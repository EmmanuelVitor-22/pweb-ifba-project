package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
