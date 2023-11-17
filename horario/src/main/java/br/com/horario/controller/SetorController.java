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

import br.com.horario.model.SetorModel;
import br.com.horario.repository.SetorRepository;
import br.com.horario.service.SetorService;


@Controller
public class SetorController {
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private SetorService setorService;
	
	private String mensagem;
	
	@GetMapping("/setores/{id}")
	public String listarSetores(ModelMap model,@PathVariable("id") Long idEscola)
	{
	
		
		model.addAttribute("setores",setorRepository.findAllByIdEscola(idEscola));
		model.addAttribute("idEscola",idEscola);
		
		return "setores/setores";
	}
	@PostMapping(value="/setores/cadastrar_setor")
    public ModelAndView cadastrarSetor(
    		@ModelAttribute("setorModel") SetorModel setorModel,
    		RedirectAttributes atributes) 
	{ 			
				//redirecina para o método getmapping
				ModelAndView mv = new ModelAndView("redirect:../escola");
				mensagem = setorService.Save(setorModel);
				atributes.addFlashAttribute("mensagem", mensagem);
				
				return mv;
		
	}
	@GetMapping("/setores/excluir/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes atributes,ModelMap model) {
		
		this.setorRepository.deleteById(id); //Exclui o setor
		atributes.addFlashAttribute("mensagem", "Setor excluído com sucesso.");
	
		return "redirect:../../escola";
	}
	@GetMapping("/setores/alterar/{id}")
	public ModelAndView consultarSetor(ModelMap model,@PathVariable("id") Long idSetor)
	{
		ModelAndView mv = new ModelAndView("setores/alterar_setor");
		model.addAttribute("id",idSetor);		
		model.addAttribute("setor",setorRepository.findById(idSetor).get());
		
		return mv;
	
	}
	@PostMapping("/setores/alterar_setor")
	public String alterarSetor(ModelMap model,SetorModel setorModel,RedirectAttributes atributes)
	{
		SetorModel s = new SetorModel();
		s = setorRepository.findById(setorModel.getId()).get();
		s.setNome(setorModel.getNome());

		setorRepository.saveAndFlush(s);
		atributes.addFlashAttribute("mensagem", "Setor alterado com sucesso.");
		
		return "redirect:../escola";
	}

}
