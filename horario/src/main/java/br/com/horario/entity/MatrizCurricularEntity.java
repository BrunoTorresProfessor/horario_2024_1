package br.com.horario.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matriz_curricular" , schema = "horario")
public class MatrizCurricularEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matriz_curricular")
	private Long idMatrizCurricular;
	
	@Column(name = "nome")
	private String nome;
	
	@OneToOne()
    @JoinColumn(name = "curso_id", referencedColumnName = "id_curso")
    private CursoEntity curso;
	
	@Column(name = "ano_matriz")
	private String anoMatriz;

	public Long getIdMatrizCurricular() {
		return idMatrizCurricular;
	}

	public void setIdMatrizCurricular(Long idMatrizCurricular) {
		this.idMatrizCurricular = idMatrizCurricular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CursoEntity getCurso() {
		return curso;
	}

	public void setCurso(CursoEntity curso) {
		this.curso = curso;
	}

	public String getAnoMatriz() {
		return anoMatriz;
	}

	public void setAnoMatriz(String anoMatriz) {
		this.anoMatriz = anoMatriz;
	}

	@Override
	public String toString() {
		return "MatrizCurricularEntity [idMatrizCurricular=" + idMatrizCurricular + ", nome=" + nome + ", curso="
				+ curso + ", anoMatriz=" + anoMatriz + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoMatriz, curso, idMatrizCurricular, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrizCurricularEntity other = (MatrizCurricularEntity) obj;
		return Objects.equals(anoMatriz, other.anoMatriz) && Objects.equals(curso, other.curso)
				&& Objects.equals(idMatrizCurricular, other.idMatrizCurricular) && Objects.equals(nome, other.nome);
	}
	

	
	
	

}
