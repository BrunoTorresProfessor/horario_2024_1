package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.horario.repository.EscolaRepository;

@Controller
public class AdminController {
	
	@Autowired
	private EscolaRepository escolaRepository;

	@GetMapping("/admin")
	public String principal()
	{
		return "admin/admin";
	}
	
	@GetMapping("/escola")
	public String escola(ModelMap model)
	{
		model.addAttribute("escolas",escolaRepository.findAll());
		return "escola/escolas";
	}
}
