package br.com.horario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.horario.entity.TipoLocalEntity;
import br.com.horario.service.TipoLocalService;

@Controller
public class TipoLocalController {
	
	@Autowired
	private TipoLocalService tipoLocalService;
	
	
	
		
	
		
	@GetMapping("/tipoLocal") //nome que eu quiser colocar 
	public String tipoLocal(ModelMap model)
	{
		
		model.addAttribute("TipoLocais",tipoLocalService.findAll());
		return "tipoLocal"; //caminho real do arquivo
	}
	

	@PostMapping("/salvar_tipoLocal")
    public ModelAndView save(
    		ModelMap model,
    		@ModelAttribute("TipoLocalEntity") TipoLocalEntity tipoLocalEntity,
    		RedirectAttributes atributes) throws Exception 
	{ 			
				
				ModelAndView mv = new ModelAndView("redirect:/tipoLocal");			
				atributes.addFlashAttribute("mensagem",tipoLocalService.save(tipoLocalEntity));
				return mv;
		
	}
	@GetMapping("/alterar_tipoLocal/{idTipoLocal}")
	public ModelAndView update(ModelMap model,@PathVariable("idTipoLocal") Long idTipoLocal) throws Exception
	{
		ModelAndView mv = new ModelAndView("alterar_TipoLocal");
		model.addAttribute("idTipoLocal",idTipoLocal);		
		model.addAttribute("tipoLocal", tipoLocalService.getOneByIdTipoLocal(idTipoLocal));
		
		return mv;
	
	}
	@PostMapping("/alterar_tipoLocal")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("TipoLocalEntity") TipoLocalEntity tipoLocalEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/tipoLocal");
		atributes.addFlashAttribute("mensagem",tipoLocalService.save(tipoLocalEntity));
		
		return mv;
	
	}
	//Começa Exclusão
	@GetMapping("/excluir_tipoLocal/{idTipoLocal}")
	public ModelAndView delete(ModelMap model,@PathVariable("idTipoLocal") Long idTipoLocal,RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/tipoLocal");
				
		model.addAttribute("mensagem", tipoLocalService.deleteById(idTipoLocal));
		//após a exclusão de um docente eu preciso atualizar a listagem na página
		//por isso eu realizo uma nova consulta findall
		model.addAttribute("tipoLocal",tipoLocalService.findAll());
		
		return mv;
	
	}
}
