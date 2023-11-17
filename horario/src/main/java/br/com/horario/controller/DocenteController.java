package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.horario.repository.EscolaRepository;

@Controller
public class DocenteController {
	
	@Autowired
	private EscolaRepository escolaRepository;

	@GetMapping("/docente")
	public String escola(ModelMap model)
	{
		model.addAttribute("escolas",escolaRepository.findAll());
		return "docentes/escolas";
	}
}
