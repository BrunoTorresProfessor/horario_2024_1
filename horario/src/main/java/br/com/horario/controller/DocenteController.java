package br.com.horario.controller;


import java.util.List;

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
import br.com.horario.entity.TempoEntity;
import br.com.horario.service.DocenteService;
import br.com.horario.service.PreferenciaService;
import br.com.horario.service.SetorService;
import br.com.horario.service.TempoService;
import jakarta.servlet.http.HttpSession;

@Controller
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private SetorService setorService;	
	
	@Autowired
	private PreferenciaService preferenciaService;	
	
	@Autowired
	private TempoService tempoService;	
	
	private String loginUsuarioLogado;
	
	

	
	

	
		
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
	@PostMapping("/alterar_docente")
	public ModelAndView update(
			ModelMap model,
			@ModelAttribute("docenteEntity") DocenteEntity docenteEntity,
			RedirectAttributes atributes) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/docente");
		atributes.addFlashAttribute("mensagem",docenteService.update(docenteEntity));
		
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
	

	
	@GetMapping("/preferencia") //nome que eu quiser colocar 
	public String preferencia(ModelMap model) 
	{	
		model.addAttribute("disciplinas",preferenciaService.listarDisciplinaDocentePreferencia());		
		
		return "preferencia"; //caminho real do arquivo
	}
	//começa disponibilidade
	/*@GetMapping("/disponibilidade") 
	public String disponibilidade(ModelMap model,HttpSession session) throws Exception
	{
	
		DocenteEntity docente = new DocenteEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");   
		docente = docenteService.getOneByCpf(loginUsuarioLogado);
		model.addAttribute("docente", docente);
	
		List<TempoEntity> ListaTempos = tempoService.findAll();
		model.addAttribute("tempos",ListaTempos);
		
		return "disponibilidade"; 
	}*/
	@GetMapping("/disponibilidade") 
	public ModelAndView disponibilidade(ModelMap model,HttpSession session) throws Exception
	{
	
		ModelAndView mv = new ModelAndView("disponibilidade");
		DocenteEntity docente = new DocenteEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");   
		docente = docenteService.getOneByCpf(loginUsuarioLogado);
		//model.addAttribute("docente", docente);
		mv.addObject("docente", docente);
	
		List<TempoEntity> ListaTempos = tempoService.findAll();
		//model.addAttribute("tempos",ListaTempos);
		mv.addObject("tempos", ListaTempos);
		
		return mv; 
	}
	//Termina disponibilidade
	@PostMapping("/salvar_disponibilidade")
    public ModelAndView salvarDispobinilidade(
    		ModelMap model,    		
    		@ModelAttribute("docente") DocenteEntity docente,
    		HttpSession session,
    		RedirectAttributes atributes) throws Exception 
	{ 			
		        //recupera o usuario logado na sessão
		        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");      
		     
		        //indica o redirecionamento
				ModelAndView mv = new ModelAndView("redirect:/disponibilidade");
				
				//instancia um novo objeto docente
				DocenteEntity d = new DocenteEntity();
				d = docenteService.getOneByCpf(loginUsuarioLogado);
				d.setTempos(docente.getTempos());			;
			
				atributes.addFlashAttribute("mensagem",docenteService.saveOrUpdate(d));
				return mv;
		
	}
	
	

}
