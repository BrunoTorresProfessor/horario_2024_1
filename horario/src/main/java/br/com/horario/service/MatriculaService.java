package br.com.horario.service;

import java.util.List;


import br.com.horario.entity.MatriculaEntity;

public interface MatriculaService {
	
	String save(MatriculaEntity MatriculaEntity) throws Exception;
	List<MatriculaEntity> findAll();
	MatriculaEntity getOneByIdMatricula(Long idMatricula) throws Exception;
	//Começa exclusão
	String deleteById(Long idMatricula) throws Exception;
	//Termina exclusão
}
