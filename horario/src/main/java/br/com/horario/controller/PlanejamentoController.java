package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.horario.entity.CursoEntity;
import br.com.horario.entity.TurnoEntity;
import br.com.horario.service.CursoService;
import br.com.horario.service.DocenteService;
import br.com.horario.service.PlanejamentoService;
import br.com.horario.service.TurnoService;

@Controller
public class PlanejamentoController {
	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private TurnoService turnoService;
	
	@Autowired
	private PlanejamentoService planejamentoService;
	

	@GetMapping("/tempo_docente_tempo_turma") //nome que eu quiser colocar 
	public String home(ModelMap model)
	{
		model.addAttribute("cursos",cursoService.findAll());
		model.addAttribute("turnos",turnoService.findAll());
		return "tempo_docente_tempo_turma"; //caminho real do arquivo
	}
	@PostMapping("/listar_tempo_docente_tempo_turma") //nome que eu quiser colocar 
	public String listarTempoDocenteTurma(ModelMap model,
			@ModelAttribute("curso") CursoEntity curso,
			@ModelAttribute("turno") TurnoEntity turno)
	{
	
		model.addAttribute("docentes",docenteService.findAll());
		model.addAttribute("turmas",planejamentoService.listarTemposPorTurma(turno) );
		model.addAttribute("cursos",cursoService.findAll());
		model.addAttribute("turnos",turnoService.findAll());
		return "tempo_docente_tempo_turma"; //caminho real do arquivo
	}
}
