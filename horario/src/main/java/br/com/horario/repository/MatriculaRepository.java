package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.horario.entity.MatriculaEntity;


@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Long> {
	
	MatriculaEntity getOneByIdMatricula(Long idMatricula);

}
