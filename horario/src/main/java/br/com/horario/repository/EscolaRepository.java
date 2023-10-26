package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.model.EscolaModel;

@Repository
public interface EscolaRepository extends JpaRepository<EscolaModel, Long> {

}
