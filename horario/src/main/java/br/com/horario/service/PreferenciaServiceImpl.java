package br.com.horario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.horario.entity.PreferenciaRepresentationModel;
import br.com.horario.repository.PreferenciaRepository;

@Service
public class PreferenciaServiceImpl implements PreferenciaService {
	
	@Autowired
	private PreferenciaRepository preferenciaRepository;

	@Override
	public List<PreferenciaRepresentationModel> listarDisciplinaDocentePreferencia() {
		
		List<PreferenciaRepresentationModel> listaPreferencias = preferenciaRepository.listarDisciplinaDocentePreferencia();
		return listaPreferencias;
	}

}
