package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.TempoEntity;

@Repository
public interface TempoRepository extends JpaRepository<TempoEntity, Long> {

}
