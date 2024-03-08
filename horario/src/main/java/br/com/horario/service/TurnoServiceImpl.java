package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.horario.entity.TurnoEntity;
import br.com.horario.repository.TurnoRepository;


@Service
public class TurnoServiceImpl implements TurnoService {
	
	@Autowired
	private TurnoRepository turnoRepository;

	@Override
	public List<TurnoEntity> findAll() {
		// TODO Auto-generated method stub
		return turnoRepository.findAll();
	}



}
