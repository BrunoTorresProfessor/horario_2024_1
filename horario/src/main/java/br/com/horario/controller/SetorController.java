package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.horario.repository.SetorRepository;

@Controller
public class SetorController {
	
	@Autowired
	private SetorRepository setorRepository;
	
	@GetMapping("/setores/{id}")
	public String listarSetores(ModelMap model,@PathVariable("id") Long idEscola)
	{
	System.out.println("escola" + idEscola);
		model.addAttribute("setores",setorRepository.findAllByIdEscola(idEscola));
		return "setores/setores";
	}

}
