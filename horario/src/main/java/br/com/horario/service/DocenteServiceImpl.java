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
			throw new Exception("Prencha o nome do docente.");				
		}
		else if (docenteEntity.getSobrenome() == null) {
			this.mensagem = "Preencha o sobrenome do docente.";		
			throw new Exception("Prencha o nome do docente.");				
		}
		else if (docenteEntity.getEmail() == null) {
			this.mensagem = "Preencha o email";		
			throw new Exception("Prencha o nome do docente.");				
		}
		else
		{
			docenteRepository.incluirDocente(docenteEntity.getNome(), 
											 docenteEntity.getSobrenome(), 
											 docenteEntity.getCpf(), 
											 docenteEntity.getEmail(), 
											 docenteEntity.getSetor().getIdSetor());
			this.mensagem = "Docente cadastrado com sucesso.";	
		}
		
		return mensagem;
	}

	@Override
	public List<DocenteEntity> findAll() {
		
		return docenteRepository.listarDocentes();
	}

	@Override
	public DocenteEntity getOneByIdDocente(Long idDocente) throws Exception {
		
		
		return docenteRepository.getOneByIdDocente(idDocente);
	}

	//Começa Exclusão
	@Override
	public String deleteById(Long idDocente) throws Exception {
		try 
		{
			docenteRepository.excluirDocente(idDocente);
			this.mensagem = "Docente excluído com sucesso.";	
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}
	//Termina Exclusão

	@Override
	public String update(DocenteEntity docenteEntity) throws Exception {
		if (docenteEntity.getNome() == null) {
			this.mensagem = "Digite o nome do docente.";		
			throw new Exception("Prencha o nome do docente.");				
		}
		else if (docenteEntity.getSobrenome() == null) {
			this.mensagem = "Preencha o sobrenome do docente.";		
			throw new Exception("Prencha o nome do docente.");				
		}
		else if (docenteEntity.getEmail() == null) {
			this.mensagem = "Preencha o email";		
			throw new Exception("Prencha o nome do docente.");				
		}
		else
		{
			docenteRepository.alterarDocente(docenteEntity.getNome(), 
											 docenteEntity.getSobrenome(), 
											 docenteEntity.getCpf(), 
											 docenteEntity.getEmail(), 
											 docenteEntity.getSetor().getIdSetor(),
											 docenteEntity.getIdDocente());
			this.mensagem = "Docente alterado com sucesso.";	
		}
		
		return mensagem;
	}

	@Override
	public DocenteEntity getOneByCpf(String Cpf) throws Exception {
		
		return docenteRepository.getOneByCpf(Cpf);
	}

	@Override
	public String saveOrUpdate(DocenteEntity docenteEntity) throws Exception {
		docenteRepository.save(docenteEntity);
		this.mensagem = "Disponibilidade cadastrada co sucesso";	
		return mensagem;
	}


}
