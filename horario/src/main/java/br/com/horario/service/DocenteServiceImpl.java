package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.DocenteEntity;
import br.com.horario.repository.DocenteRepository;

@Service
public class DocenteServiceImpl implements DocenteService {
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	private String mensagem;

	@Override
	public String save(DocenteEntity docenteEntity) throws Exception {
		
		if (docenteEntity.getNome() == null) {
			this.mensagem = "Digite o nome do docente.";		
			throw new Exception("Digite o nome do docente.");				
		}
		else
		{
			docenteRepository.save(docenteEntity);
		}
		
		return mensagem;
	}

	@Override
	public List<DocenteEntity> findAll() {
		
		return docenteRepository.findAll();
	}


}
