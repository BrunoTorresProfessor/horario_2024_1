package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.DisciplinaEntity;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {

}
