package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.DiaEntity;



@Repository
public interface DiaRepository extends JpaRepository<DiaEntity, Long> {

}
