package br.ifba.edu.consultorio_api.repository;

import br.ifba.edu.consultorio_api.entities.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
     Optional<Medico> findByNome(String nome);
     // Consulta personalizada para ordenar os médicos pelo nome, ignorando o prefixo "Dr." ou "Dra." (POSTGRES)
     // @Query("SELECT m FROM medico m ORDER BY FUNCTION('regexp_replace', m.nome, '^Dr\\.\\s*|^Dra\\.\\s*', '', 'g')")
     //Page<Medico> findAllOrderByNomeIgnoringPrefix(Pageable pageable);

     // Consulta personalizada para ordenar os médicos pelo nome, ignorando o prefixo "Dr." ou "Dra." (H2)
     @Query("SELECT m FROM medico m ORDER BY REPLACE(REPLACE(m.nome, 'Dr. ', ''), 'Dra. ', '')")
     Page<Medico> findAllOrderByNomeIgnoringPrefix(Pageable pageable);




     //gera o aleatorio(medico)
     @Query(value = "SELECT m FROM medico m WHERE m.status = TRUE AND m.id NOT IN (SELECT c.medico.id FROM consulta c WHERE c.dataHora = :data and c.cancelamento is null) ORDER BY RANDOM() FETCH FIRST 1 ROW ONLY")
     Optional<Medico> medicoAleatorioLivreNaData(@Param("data") LocalDateTime localDateTime);
}
