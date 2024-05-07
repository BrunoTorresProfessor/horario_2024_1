package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.horario.entity.DiaEntity;
import br.com.horario.repository.DiaRepository;

@Service
public class DiaServiceImpl implements DiaService {
	@Autowired
	private DiaRepository diaRepository;

	@Override
	public List<DiaEntity> findAll() {
		
		return diaRepository.findAll(Sort.by(Sort.Direction.ASC, "ordem"));
	}

}
