package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.horario.entity.MatriculaEntity;

import br.com.horario.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	private String mensagem;

	@Override
	public String save(MatriculaEntity matriculaEntity) throws Exception {
		
		if (matriculaEntity.getCargo() == null) {
			this.mensagem = "Digite o cargo.";		
			throw new Exception("Prencha o cargo.");				
		}
		else if (matriculaEntity.getCargaHoraria() == null) {
			this.mensagem = "Preencha o cargo.";		
			throw new Exception("Prencha o cargo.");				
		}
		else
		{
			matriculaRepository.saveAndFlush(matriculaEntity);
			this.mensagem = "Matricula cadastrado com sucesso.";	
		}
		
		return mensagem;
	}

	@Override
	public List<MatriculaEntity> findAll() {
	
		return matriculaRepository.findAll();
	}

	@Override
	public MatriculaEntity getOneByIdMatricula(Long idMatricula) throws Exception {
		// TODO Auto-generated method stub
		return matriculaRepository.getOneByIdMatricula(idMatricula);
	}

	@Override
	public String deleteById(Long idMatricula) throws Exception {
		try 
		{
			matriculaRepository.deleteById(idMatricula);
			this.mensagem = "Matricula excluído com sucesso.";	
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

}
