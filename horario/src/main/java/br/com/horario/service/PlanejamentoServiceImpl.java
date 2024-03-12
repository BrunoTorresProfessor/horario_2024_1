package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.horario.entity.TempoTurmaRepresentationModel;
import br.com.horario.entity.TurnoEntity;
import br.com.horario.repository.TempoTurmaRepository;

@Service
public class PlanejamentoServiceImpl implements PlanejamentoService {

	@Autowired
	private TempoTurmaRepository tempoTurmaRepository;
	
	@Override
	public List<TempoTurmaRepresentationModel> listarTemposPorTurma(TurnoEntity turno) {
		
		
		return tempoTurmaRepository.listarTemposPorTurma(turno);
	}

}
