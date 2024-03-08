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
@Table(name = "disciplina" , schema = "horario")
public class DisciplinaEntity implements Serializable {
	

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_disciplina")
	private Long idDisciplina;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sigla")
	private String sigla;
	
	@Column(name = "tempo")
	private int tempo;
	
	@Column(name = "area_fim")
	private boolean areaFim;
	
	@OneToOne()
    @JoinColumn(name = "matriz_curricular_id", referencedColumnName = "id_matriz_curricular")
    private MatrizCurricularEntity matrizCurricular;
	
	@OneToOne()
    @JoinColumn(name = "etapa_id", referencedColumnName = "id_etapa")
    private EtapaEntity etapa;


}
