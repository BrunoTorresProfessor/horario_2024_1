package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.horario.service.CursoService;
import br.com.horario.service.DocenteService;
import br.com.horario.service.TurnoService;

@Controller
public class PlanejamentoController {
	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private TurnoService turnoService;
	

	@GetMapping("/tempo_docente_tempo_turma") //nome que eu quiser colocar 
	public String home(ModelMap model)
	{
		model.addAttribute("docentes",docenteService.findAll());
		model.addAttribute("cursos",cursoService.findAll());
		model.addAttribute("turnos",turnoService.findAll());
		return "tempo_docente_tempo_turma"; //caminho real do arquivo
	}
}
