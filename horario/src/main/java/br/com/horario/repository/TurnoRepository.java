package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.TurnoEntity;

@Repository
public interface TurnoRepository extends JpaRepository<TurnoEntity, Long> {

}
