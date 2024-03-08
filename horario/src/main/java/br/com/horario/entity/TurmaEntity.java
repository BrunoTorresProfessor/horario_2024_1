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
@Table(name = "turma" , schema = "horario")
public class TurmaEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_turma")
	private Long idTurma;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "ano_inicio")
	private String anoInicio;
	
	@Column(name = "semestre_inicio")
	private String semestreInicio;
	
	@OneToOne()
    @JoinColumn(name = "curso_id", referencedColumnName = "id_curso")
    private CursoEntity curso;
	
	@OneToOne()
    @JoinColumn(name = "ensino_id", referencedColumnName = "id_ensino")
    private EnsinoEntity ensino;
	
	@OneToOne()
    @JoinColumn(name = "turno_id", referencedColumnName = "id_turno")
    private TurnoEntity turno;
	
}
