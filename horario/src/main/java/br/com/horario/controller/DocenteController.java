package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.horario.entity.DocenteEntity;
import br.com.horario.service.DocenteService;
import br.com.horario.service.SetorService;

@Controller
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private SetorService setorService;
	
	private String mensagem;
	
	@GetMapping("/docente") //nome que eu quiser colocar 
	public String docente(ModelMap model)
	{
		model.addAttribute("setores",setorService.findAll());
		return "docente"; //caminho real do arquivo
	}
	

	@PostMapping("/salvar_docente")
    public ModelAndView Save(
    		@ModelAttribute("docenteEntity") DocenteEntity docenteEntity,
    		RedirectAttributes atributes) throws Exception 
	{ 			
				
				ModelAndView mv = new ModelAndView("redirect:/docente");
				mensagem = docenteService.save(docenteEntity);
				atributes.addFlashAttribute("mensagem", mensagem);		
				
				System.out.println("Entrei");
				
				return mv;
		
	}

}
