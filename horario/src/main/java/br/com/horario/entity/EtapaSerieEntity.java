package br.com.horario.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etapa_serie" , schema = "horario")
public class EtapaSerieEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_etapa_serie")
	private Long idEtapaSerie;
	
	@Column(name = "nome")
	private String nome;


	public Long getIdEtapaSerie() {
		return idEtapaSerie;
	}

	public void setIdEtapaSerie(Long idEtapaSerie) {
		this.idEtapaSerie = idEtapaSerie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
