package br.com.horario.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_local" , schema = "horario")
public class TipoLocalEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_local")
	private Long idTipoLocal;
	
	@Column(name = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdTipoLocal(Long idTipoLocal) {
		this.idTipoLocal = idTipoLocal;
	}

	public Long getIdTipoLocal() {
		return idTipoLocal;
	}

	
	
}


