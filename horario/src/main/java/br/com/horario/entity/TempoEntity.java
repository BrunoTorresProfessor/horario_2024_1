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
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "tempo", schema = "horario")
public class TempoEntity implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tempo")
	private Long idTempo;
	
	@OrderBy("name ASC")
	@Column(name = "ordem") 
	private Long ordem;
	
	@Column(name = "nome") 
	private String nome;	
	
	@OneToOne()
    @JoinColumn(name = "dia_id", referencedColumnName = "id_dia")
    private DiaEntity dia;		
	
	@ManyToMany(mappedBy = "tempos")
    private List<DocenteEntity> docentes;



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
	public List<DocenteEntity> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<DocenteEntity> docentes) {
		this.docentes = docentes;
	}		


	

}
