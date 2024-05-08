package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.TempoEntity;
import br.com.horario.repository.TempoRepository;

@Service
public class TempoServiceImpl implements TempoService {
	
	@Autowired
	private TempoRepository tempoRepository;

	@Override
	public List<TempoEntity> findAll() {			
		
		return tempoRepository.findAll();
	}

}
