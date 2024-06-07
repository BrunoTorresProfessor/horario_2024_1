package br.com.horario.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tempo", schema = "horario")
public class TempoEntity implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tempo")
	private Long idTempo;
	

	@Column(name = "ordem") 
	private Long ordem;
	
	@Column(name = "nome") 
	private String nome;	
	
	@OneToOne()
    @JoinColumn(name = "dia_id", referencedColumnName = "id_dia")
    private DiaEntity dia;		
	
	@ManyToMany(mappedBy = "tempos")
    private List<DocenteEntity> docentes;
	
	public TempoEntity(List<DocenteTempoEntity> prioridades) {
		super();
		this.prioridades = prioridades;
	}
	public TempoEntity() {
		super();
	}



	public List<DocenteEntity> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<DocenteEntity> docentes) {
		this.docentes = docentes;
	}
	
	@OneToMany(mappedBy = "tempo",fetch = FetchType.EAGER)
	List<DocenteTempoEntity> prioridades;




	public List<DocenteTempoEntity> getPrioridades() {
		return prioridades;
	}

	public void setPrioridades(List<DocenteTempoEntity> prioridades) {
		this.prioridades = prioridades;
	}

	public DiaEntity getDia() {
		return dia;
	}

	public void setDia(DiaEntity dia) {
		this.dia = dia;
	}

	public Long getIdTempo() {
		return idTempo;
	}

	public void setIdTempo(Long idTempo) {
		this.idTempo = idTempo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getOrdem() {
		return ordem;
	}

	public void setOrdem(Long ordem) {
		this.ordem = ordem;
	}

	//O toString(), hashCode() e o equals() são necessários para o checkbox @manyTomany aparecer marcado automaticamente
	@Override
	public String toString() {
		return "TempoEntity [nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTempo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempoEntity other = (TempoEntity) obj;
		return Objects.equals(idTempo, other.idTempo);
	}

	







	

	
	


	

}
