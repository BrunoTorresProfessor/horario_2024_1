package br.com.horario.entity;

import java.io.Serializable;
import java.util.Objects;

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

	@Override
	public String toString() {
		return "EtapaSerieEntity [idEtapaSerie=" + idEtapaSerie + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEtapaSerie, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtapaSerieEntity other = (EtapaSerieEntity) obj;
		return Objects.equals(idEtapaSerie, other.idEtapaSerie) && Objects.equals(nome, other.nome);
	}
	
	
	
	
}
