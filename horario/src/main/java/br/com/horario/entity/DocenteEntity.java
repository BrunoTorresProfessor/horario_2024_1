package br.com.horario.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "docente" , schema = "horario")
public class DocenteEntity implements Serializable {

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_docente")
	private Long idDocente;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;	
	
	@Column(name = "tempo")
	private int tempo;	
	
	@Column(name = "cpf")
	private String cpf;	

	@Column(name = "email")
	private String email;

	@OneToOne()
    @JoinColumn(name = "setor_id", referencedColumnName = "id_setor")
    private SetorEntity setor;
	
	@ManyToMany
	@JoinTable(name="preferencia_disciplina_docente",
    joinColumns={@JoinColumn(name="docente_id", referencedColumnName = "id_docente")},
    inverseJoinColumns={@JoinColumn(name="disciplina_id", referencedColumnName = "id_disciplina")})
	private List<DisciplinaEntity> preferenciaDisciplinas;	
	
	/*@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name="docente_tempo",
    joinColumns={@JoinColumn(name="docente_id", referencedColumnName = "id_docente")},
    inverseJoinColumns={@JoinColumn(name="tempo_id", referencedColumnName = "id_tempo")})
	private List<TempoEntity> tempos;*/
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name="docente_tempo",
    joinColumns={@JoinColumn(name="docente_id", referencedColumnName = "id_docente")},
    inverseJoinColumns={@JoinColumn(name="tempo_id", referencedColumnName = "id_tempo")})
	 private Set<TempoEntity> tempos = new HashSet<>();
    
	
    

	public Set<TempoEntity> getTempos() {
		return tempos;
	}



	public void setTempos(Set<TempoEntity> tempos) {
		this.tempos = tempos;
	}



	public List<DisciplinaEntity> getPreferenciaDisciplinas() {
		return preferenciaDisciplinas;
	}



	public void setPreferenciaDisciplinas(List<DisciplinaEntity> preferenciaDisciplinas) {
		this.preferenciaDisciplinas = preferenciaDisciplinas;
	}	
	public SetorEntity getSetor() {
		return setor;
	}

	public void setSetor(SetorEntity setor) {
		this.setor = setor;
	}

	public Long getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(Long idDocente) {
		this.idDocente = idDocente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	





	

}
