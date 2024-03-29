package br.com.horario.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.horario.entity.DocenteEntity;
import br.com.horario.service.DocenteService;
import br.com.horario.service.PreferenciaService;
import br.com.horario.service.SetorService;

@Controller
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private SetorService setorService;	
	
	@Autowired
	private PreferenciaService preferenciaService;	
	
		
	@GetMapping("/docente") //nome que eu quiser colocar 
	public String docente(ModelMap model)
	{
		model.addAttribute("setores",setorService.findAll());
		model.addAttribute("docentes",docenteService.findAll());
		return "docente"; //caminho real do arquivo
	}
	

	@PostMapping("/salvar_docente")
    public ModelAndView save(
    		ModelMap model,
    		@ModelAttribute("docenteEntity") DocenteEntity docenteEntity,
    		RedirectAttributes atributes) throws Exception 
	{ 			
				
				ModelAndView mv = new ModelAndView("redirect:/docente");			
				atributes.addFlashAttribute("mensagem",docenteService.save(docenteEntity));
				return mv;
		
	}
	@GetMapping("/alterar_docente/{idDocente}")
	public ModelAndView update(ModelMap model,@PathVariable("idDocente") Long idDocente) throws Exception
	{
		ModelAndView mv = new ModelAndView("alterar_docente");
		model.addAttribute("setores",setorService.findAll());
		model.addAttribute("idDocente",idDocente);		
		model.addAttribute("docente", docenteService.getOneByIdDocente(idDocente));
		
		return mv;
	
	}
	//Começa Exclusão
	@GetMapping("/excluir_docente/{idDocente}")
	public ModelAndView delete(ModelMap model,@PathVariable("idDocente") Long idDocente,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("docente");
		model.addAttribute("setores",setorService.findAll());		
		model.addAttribute("mensagem", docenteService.deleteById(idDocente));
		//após a exclusão de um docente eu preciso atualizar a listagem na página
		//por isso eu realizo uma nova consulta findall
		model.addAttribute("docentes",docenteService.findAll());
		
		return mv;
	
	}
	//Termina Exclusão
	
	@GetMapping("/disponibilidade") //nome que eu quiser colocar 
	public String disponibilidade(ModelMap model)
	{
		model.addAttribute("setores",setorService.findAll());
		model.addAttribute("docentes",docenteService.findAll());
		return "disponibilidade"; //caminho real do arquivo
	}
	
	@GetMapping("/preferencia") //nome que eu quiser colocar 
	public String preferencia(ModelMap model)
	{
		model.addAttribute("disciplinas",preferenciaService.listarDisciplinaDocentePreferencia());

		
		return "preferencia"; //caminho real do arquivo
	}
	
	

}
