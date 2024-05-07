package br.com.horario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.TempoEntity;

@Repository
public interface TempoRepository extends JpaRepository<TempoEntity, Long> {
	
	List<TempoEntity> findAllByOrderByOrdemAsc();

}
