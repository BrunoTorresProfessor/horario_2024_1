package br.com.horario.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
    @JoinColumn(name = "etapa_serie_id", referencedColumnName = "id_etapa_serie")
    private EtapaSerieEntity etapaSerie;
	
	@ManyToMany(mappedBy = "preferenciaDisciplinas")
    private List<DocenteEntity> docentes;

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public boolean isAreaFim() {
		return areaFim;
	}

	public void setAreaFim(boolean areaFim) {
		this.areaFim = areaFim;
	}

	public MatrizCurricularEntity getMatrizCurricular() {
		return matrizCurricular;
	}

	public void setMatrizCurricular(MatrizCurricularEntity matrizCurricular) {
		this.matrizCurricular = matrizCurricular;
	}

	public EtapaSerieEntity getEtapa() {
		return etapaSerie;
	}

	public void setEtapa(EtapaSerieEntity etapaSerie) {
		this.etapaSerie = etapaSerie;
	}

	public List<DocenteEntity> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<DocenteEntity> docentes) {
		this.docentes = docentes;
	}		
	
	


}
