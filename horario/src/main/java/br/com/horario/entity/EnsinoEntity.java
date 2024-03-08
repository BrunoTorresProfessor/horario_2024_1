package br.com.horario.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ensino" , schema = "horario")
public class EnsinoEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ensino")
	private Long idEnsino;
	
	@Column(name = "nome")
	private String nome;

	public Long getIdEnsino() {
		return idEnsino;
	}

	public void setIdEnsino(Long idEnsino) {
		this.idEnsino = idEnsino;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
