package br.com.horario.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	private String ordem;
	
	@Column(name = "nome") 
	private String nome;
	
	@ManyToMany(mappedBy = "tempo", fetch = FetchType.EAGER)
    private List<DiaEntity> dia;		
	
	public List<DiaEntity> getDia() {
		return dia;
	}

	public void setDia(List<DiaEntity> dia) {
		this.dia = dia;
	}

	public Long getIdTempo() {
		return idTempo;
	}

	public void setIdTempo(Long idTempo) {
		this.idTempo = idTempo;
	}

	public String getOrdem() {
		return ordem;
	}

	public void setOrdem(String ordem) {
		this.ordem = ordem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}





	



	

}
