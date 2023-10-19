package br.com.horario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {

	@GetMapping("/principal")
	public String principal()
	{
		return "principal";
	}
	@GetMapping("/")
	public String home()
	{
		return "principal";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
}
