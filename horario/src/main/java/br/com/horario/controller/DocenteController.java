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

import br.com.horario.entity.DisciplinaEntity;
import br.com.horario.entity.DocenteEntity;
import br.com.horario.entity.DocenteTempoEntity;
import br.com.horario.entity.DocenteTempoKey;
import br.com.horario.entity.TempoEntity;
import br.com.horario.service.DisciplinaService;
import br.com.horario.service.DocenteService;
import br.com.horario.service.DocenteTempoService;
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
	private TempoService tempoService;	
	
	@Autowired
	private DisciplinaService disciplinaService;	
	
	@Autowired
	private DocenteTempoService docenteTempoService;	
	
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
	public ModelAndView preferencia(ModelMap model,HttpSession session) throws Exception 
	{
		ModelAndView mv = new ModelAndView("preferencia");
		DocenteEntity docente = new DocenteEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");   
		docente = docenteService.getOneByCpf(loginUsuarioLogado);
		mv.addObject("docente", docente);
	
		List<DisciplinaEntity> ListaDisciplinas = disciplinaService.findAll();
		mv.addObject("listadisciplinas", ListaDisciplinas);
		
		
		return mv; //caminho real do arquivo
	}
	@PostMapping("/salvar_preferencia")
    public ModelAndView salvarPreferencia(
    		ModelMap model,    		
    		@ModelAttribute("docente") DocenteEntity docente,
    		HttpSession session,
    		RedirectAttributes atributes) throws Exception 
	{ 			
		        //recupera o usuario logado na sessão
		        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");      
		     
		        //indica o redirecionamento
				ModelAndView mv = new ModelAndView("redirect:/preferencia");
				
				//instancia um novo objeto docente
				DocenteEntity d = new DocenteEntity();
				d = docenteService.getOneByCpf(loginUsuarioLogado);
				d.setDisciplinas(docente.getDisciplinas());			;
			
				atributes.addFlashAttribute("mensagem",docenteService.saveOrUpdate(d));
				return mv;
		
	}
	@GetMapping("/disponibilidade") 
	public ModelAndView disponibilidade(ModelMap model,HttpSession session) throws Exception
	{
	
		ModelAndView mv = new ModelAndView("disponibilidade");

		mv.addObject("docente", docenteLogado(session));
		mv.addObject("docentetempos", docenteLogado(session).getPrioridades());
	
		List<TempoEntity> ListaTempos = tempoService.findAll();
		mv.addObject("listatempos", ListaTempos);
		
		
		return mv; 
	}
	//Termina disponibilidade
	@PostMapping("/salvar_disponibilidade")
    public ModelAndView salvarDispobinilidade(
    		ModelMap model,    		
    		@ModelAttribute("docente") DocenteEntity docente,
    		@ModelAttribute("docentetempo") DocenteTempoEntity docenteTempo,   
    		@ModelAttribute("tempo")  TempoEntity tempo,
    		
    		HttpSession session,
    		RedirectAttributes atributes) throws Exception 
	{ 			
		        //recupera o usuario logado na sessão
		        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");      
		     
		        //indica o redirecionamento
				ModelAndView mv = new ModelAndView("redirect:/disponibilidade");
				DocenteTempoKey dtk = new DocenteTempoKey();
				dtk.setDocenteId(docente.getIdDocente());
				dtk.setTempoId(tempo.getIdTempo());
				
				docenteTempo.setId(dtk);				
				
				atributes.addFlashAttribute("mensagem",docenteTempoService.save(docenteTempo));
				return mv;
		
	}
	//Começa Exclusão
	@GetMapping("/excluir_disponibilidade/{idTempo}")
	public ModelAndView excluirDisponibilidade(ModelMap model,@PathVariable("idTempo") Long idTempo,RedirectAttributes atributes,HttpSession session) throws Exception
	{
		ModelAndView mv = new ModelAndView("redirect:/disponibilidade");
		model.addAttribute("mensagem", docenteTempoService.deleteByDocenteAndTempo(docenteLogado(session), tempoService.getOneByIdTempo(idTempo)));
		
		return mv;
	
	}
	public DocenteEntity docenteLogado(HttpSession session) throws Exception
	{
		DocenteEntity docente = new DocenteEntity();
		//recupera o usuario logado na sessão
        loginUsuarioLogado = (String)session.getAttribute("loginUsuarioLogado");   
		docente = docenteService.getOneByCpf(loginUsuarioLogado);
		
		return docente;
	}
	
	

}
