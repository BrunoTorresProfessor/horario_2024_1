package br.com.horario.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DocenteTempoKey implements Serializable  {

	private static final long serialVersionUID = 1L;

	
	@Column(name = "docente_id")
	Long docenteId;

	@Column(name = "tempo_id")
    Long tempoId;
	

	public Long getDocenteId() {
		return docenteId;
	}

	public void setDocenteId(Long docenteId) {
		this.docenteId = docenteId;
	}

	public Long getTempoId() {
		return tempoId;
	}

	public void setTempoId(Long tempoId) {
		this.tempoId = tempoId;
	}

	@Override
	public String toString() {
		return "DocenteTempoKey [docenteId=" + docenteId + ", tempoId=" + tempoId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(docenteId, tempoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocenteTempoKey other = (DocenteTempoKey) obj;
		return Objects.equals(docenteId, other.docenteId) && Objects.equals(tempoId, other.tempoId);
	}
	
	
	 
	 

}
