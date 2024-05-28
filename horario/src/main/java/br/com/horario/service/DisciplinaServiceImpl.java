package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.DisciplinaEntity;
import br.com.horario.repository.DisciplinaRepository;

@Service
public class DisciplinaServiceImpl  implements DisciplinaService {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Override
	public List<DisciplinaEntity> findAll() {
		
		return disciplinaRepository.findAll();
	}

}
