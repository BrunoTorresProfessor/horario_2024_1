package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.DocenteEntity;
import br.com.horario.entity.DocenteTempoEntity;
import br.com.horario.entity.DocenteTempoKey;
import br.com.horario.entity.TempoEntity;
import jakarta.transaction.Transactional;

@Repository
public interface DocenteTempoRepository extends JpaRepository<DocenteTempoEntity, DocenteTempoKey> {
	
	boolean existsByPrioridadeAndDocente(Long prioridade,DocenteEntity docente);
	
	@Modifying
	@Transactional
	void deleteByDocenteAndTempo(DocenteEntity docente, TempoEntity tempo);

}
