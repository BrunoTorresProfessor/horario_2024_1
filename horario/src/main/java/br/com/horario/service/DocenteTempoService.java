package br.com.horario.service;

import br.com.horario.entity.DocenteEntity;
import br.com.horario.entity.DocenteTempoEntity;
import br.com.horario.entity.TempoEntity;

public interface DocenteTempoService {

	String save(DocenteTempoEntity docenteTempoEntity) throws Exception;
	String deleteByDocenteAndTempo(DocenteEntity docente, TempoEntity tempo) throws Exception;
}
