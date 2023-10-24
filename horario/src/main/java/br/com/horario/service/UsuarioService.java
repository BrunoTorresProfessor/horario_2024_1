package br.com.horario.service;

import br.com.horario.model.UsuarioModel;

public interface UsuarioService {
	
	String CadastrarUsuario(UsuarioModel usuario,String confirmarEmail,Long idUsuario);

}
