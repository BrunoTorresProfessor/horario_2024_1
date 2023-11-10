package br.com.horario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.model.SetorModel;
import br.com.horario.repository.SetorRepository;

@Service
public class SetorServiceImpl implements SetorService{
	
	@Autowired
	private SetorRepository setorRepository;
	
	private String mensagem;

	@Override
	public String Save(SetorModel setorModel) {
		
		
		setorRepository.save(setorModel);		
		mensagem = "Setor cadastrado com sucesso";
		
		return mensagem;
	}

}
