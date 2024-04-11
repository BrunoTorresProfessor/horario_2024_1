package br.com.horario.service;

import java.util.List;

import br.com.horario.entity.TipoLocalEntity;

public interface TipoLocalService {
	
	String save(TipoLocalEntity tipoLocalEntity) throws Exception;
	List<TipoLocalEntity> findAll();
	TipoLocalEntity getOneByIdTipoLocal(Long idTipoLocal) throws Exception;
	//Começa exclusão
	String deleteById(Long idTipoLocal) throws Exception;
	//Termina exclusão

}
