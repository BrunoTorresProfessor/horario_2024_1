package br.com.horario.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class DocenteTempo {
	
	@EmbeddedId
	DocenteTempoKey id;

	public DocenteTempo(DocenteTempoKey id, DocenteEntity docente, TempoEntity tempo) {
		super();
		this.id = id;
		this.docente = docente;
		this.tempo = tempo;
	}

	//MapsId significa que vinculamos esses campos a uma parte da chave e eles são as 
	//chaves estrangeiras de um relacionamento muitos para um.
	@ManyToOne
	@MapsId("docenteId")
	@JoinColumn(name = "docente_id")
	DocenteEntity docente;

	@ManyToOne
	@MapsId("tempoId")
	@JoinColumn(name = "tempo_id")
	TempoEntity tempo;
	
	
	@Column(name = "prioridade")
	private Long prioridade;	
	
	
	
	

	public Long getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Long prioridade) {
		this.prioridade = prioridade;
	}

	public DocenteTempoKey getId() {
		return id;
	}

	public void setId(DocenteTempoKey id) {
		this.id = id;
	}

	public DocenteEntity getDocente() {
		return docente;
	}

	public void setDocente(DocenteEntity docente) {
		this.docente = docente;
	}

	public TempoEntity getTempo() {
		return tempo;
	}

	public void setTempo(TempoEntity tempo) {
		this.tempo = tempo;
	}

	@Override
	public String toString() {
		return "DocenteTempo [id=" + id + ", docente=" + docente + ", tempo=" + tempo + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocenteTempo other = (DocenteTempo) obj;
		return Objects.equals(id, other.id);
	}

	public DocenteTempo() {
		super();
	}
	


	 
	    

}
