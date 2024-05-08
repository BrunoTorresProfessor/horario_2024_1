package br.com.horario.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "dia", schema = "horario")
public class DiaEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dia")
	private Long idDia;
	
	@Column(name = "ordem") 
	private String ordem;
	
	@Column(name = "nome") 
	private String nome;	

	public Long getIdDia() {
		return idDia;
	}

	public void setIdDia(Long idDia) {
		this.idDia = idDia;
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



	/*@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="dia_tempo",
    joinColumns={@JoinColumn(name="dia_id_dia", referencedColumnName = "id_dia")},
    inverseJoinColumns={@JoinColumn(name="tempo_id_tempo", referencedColumnName = "id_tempo")})
	private List<TempoEntity> tempo;	
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<TempoEntity> tempo;*/

	
	

}
