package br.com.horario.service;

import java.util.List;

import br.com.horario.entity.TurnoEntity;


public interface TurnoService {
	
	List<TurnoEntity> findAll();

}
