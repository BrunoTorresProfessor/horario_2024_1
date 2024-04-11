package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.TipoLocalEntity;
import br.com.horario.repository.TipoLocalRepository;

@Service
public class TipoLocalServiceImpl implements TipoLocalService {
	
	@Autowired
	private TipoLocalRepository tipoLocalRepository;
	private String mensagem;

	@Override
	public List<TipoLocalEntity> findAll() {
		
		return tipoLocalRepository.findAll();
	}

	public TipoLocalEntity getOneByIdTipoLocal(Long idTipoLocal) throws Exception {
		// TODO Auto-generated method stub
		return tipoLocalRepository.getOneByIdTipoLocal(idTipoLocal);
	}

	@Override
	public String deleteById(Long idTipoLocal) throws Exception {
		try 
		{
			tipoLocalRepository.deleteById(idTipoLocal);
			this.mensagem = "Local excluído com sucesso.";	
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return mensagem;
	}

	public String save(TipoLocalEntity tipoLocalEntity) throws Exception {
		
		if (tipoLocalEntity.getNome() == null) {
			this.mensagem = "Digite o nome do local.";		
			throw new Exception("Prencha o nome do local.");				
		}
		
		else
		{
			tipoLocalRepository.saveAndFlush(tipoLocalEntity);
			this.mensagem = "local cadastrado com sucesso.";	
		}
		
		return mensagem;
	}
}