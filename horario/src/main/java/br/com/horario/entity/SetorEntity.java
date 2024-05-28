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
@Table(name = "setor" , schema = "horario")
public class SetorEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_setor")
	private Long idSetor;
	
	@Column(name = "nome")
	private String nome;

	public Long getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SetorEntity(Long idSetor, String nome) {
		super();
		this.idSetor = idSetor;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "SetorEntity [idSetor=" + idSetor + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSetor, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SetorEntity other = (SetorEntity) obj;
		return Objects.equals(idSetor, other.idSetor) && Objects.equals(nome, other.nome);
	}

	public SetorEntity() {
		super();
	}
	

	
	
	

}
