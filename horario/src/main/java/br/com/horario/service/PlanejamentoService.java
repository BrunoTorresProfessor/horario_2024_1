package br.com.horario.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import br.com.horario.entity.TempoTurmaRepresentationModel;
import br.com.horario.entity.TurnoEntity;

public interface PlanejamentoService {
	
	List<TempoTurmaRepresentationModel> listarTemposPorTurma(@Param("turno_id") TurnoEntity turno);

}
