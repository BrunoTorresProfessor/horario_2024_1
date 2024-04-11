package br.com.horario.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula" , schema = "horario")
public class MatriculaEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_matricula")
	private Long idMatricula;
	
	@Column(name = "cargo")
	private String cargo;
	
	@Column(name = "carga_horaria")
	private String cargaHoraria;	
	
	@OneToOne()
    @JoinColumn(name = "id_docente", referencedColumnName = "id_docente")
    private DocenteEntity docente;

	public Long getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public DocenteEntity getDocente() {
		return docente;
	}

	public void setDocente(DocenteEntity docente) {
		this.docente = docente;
	}


	
}
