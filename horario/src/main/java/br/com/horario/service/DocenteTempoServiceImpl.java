package br.com.horario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.DocenteEntity;
import br.com.horario.entity.DocenteTempoEntity;
import br.com.horario.entity.TempoEntity;
import br.com.horario.repository.DocenteTempoRepository;

@Service
public class DocenteTempoServiceImpl implements DocenteTempoService {
	
	@Autowired
	private DocenteTempoRepository docenteTempoRepository;
	
	private String mensagem;

	@Override
	public String save(DocenteTempoEntity docenteTempoEntity) throws Exception {
		try 
		{
		
		if (docenteTempoRepository.existsById(docenteTempoEntity.getId()))
		{
			this.mensagem = "Não é permitido escolher duas vezes o mesmo tempo.";		
							
		}
		else if (docenteTempoRepository.existsByPrioridadeAndDocente(docenteTempoEntity.getPrioridade(),docenteTempoEntity.getDocente()))
		{
			this.mensagem = "Não é permitido escolher duas vezes a mesma prioridade.";		
				
		}
		else
		{
		
		docenteTempoRepository.save(docenteTempoEntity);
		
		mensagem = "Disponibilidade cadastrada com sucesso.";
		}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return mensagem;
	}

	@Override
	public String deleteByDocenteAndTempo(DocenteEntity docente, TempoEntity tempo) throws Exception {
		
		try 
		{
			docenteTempoRepository.deleteByDocenteAndTempo(docente, tempo);
			this.mensagem = "Disponibilidade excluída com sucesso.";	
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
		
	}

}
