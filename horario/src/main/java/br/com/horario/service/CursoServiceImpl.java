package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.CursoEntity;
import br.com.horario.repository.CursoRepository;


@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<CursoEntity> findAll() {
		
		return cursoRepository.findAll();
	}

}
