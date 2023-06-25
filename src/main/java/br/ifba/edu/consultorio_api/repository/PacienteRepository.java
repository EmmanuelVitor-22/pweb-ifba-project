package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.dto.PacienteResponseDTO;
import br.ifba.edu.consultorio_api.entities.Paciente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<PacienteResponseDTO> findByNome(String nome);
    @Query("SELECT p FROM paciente p WHERE LOWER(p.nome) LIKE CONCAT(:letra, '%')")
    List<Paciente> findByNomeStartingWithIgnoreCase(String letra);
}
