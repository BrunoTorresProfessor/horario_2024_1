package br.com.horario.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
import jakarta.persistence.OneToMany;
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
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name="docente_disciplina",
    joinColumns={@JoinColumn(name="docente_id", referencedColumnName = "id_docente")},
    inverseJoinColumns={@JoinColumn(name="disciplina_id", referencedColumnName = "id_disciplina")})
	private List<DisciplinaEntity> disciplinas;	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name="docente_tempo",
    joinColumns={@JoinColumn(name="docente_id", referencedColumnName = "id_docente")},
    inverseJoinColumns={@JoinColumn(name="tempo_id", referencedColumnName = "id_tempo")})
	private List<TempoEntity> tempos;	
	
	@OneToMany(mappedBy = "docente", fetch = FetchType.EAGER)
	List<DocenteTempoEntity> prioridades;	

	public List<DocenteTempoEntity> getPrioridades() {
		return prioridades;
	}
	public void setPrioridades(List<DocenteTempoEntity> prioridades) {
		this.prioridades = prioridades;
	}
	public List<TempoEntity> getTempos() {
		return tempos;
	}
	public void setTempos(List<TempoEntity> tempos) {
		this.tempos = tempos;
	}
	
	
	public List<DisciplinaEntity> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<DisciplinaEntity> disciplinas) {
		this.disciplinas = disciplinas;
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
	



	@Override
	public String toString() {
		return "DocenteEntity [idDocente=" + idDocente + ", nome=" + nome + ", sobrenome=" + sobrenome + ", tempo="
				+ tempo + ", cpf=" + cpf + ", email=" + email + ", setor=" + setor + ", disciplinas=" + disciplinas
				+ ", tempos=" + tempos + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, disciplinas, email, idDocente, nome, setor, sobrenome, tempo, tempos);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocenteEntity other = (DocenteEntity) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(disciplinas, other.disciplinas)
				&& Objects.equals(email, other.email) && Objects.equals(idDocente, other.idDocente)
				&& Objects.equals(nome, other.nome) && Objects.equals(setor, other.setor)
				&& Objects.equals(sobrenome, other.sobrenome) && tempo == other.tempo
				&& Objects.equals(tempos, other.tempos);
	}
	public DocenteEntity() {
		super();
	}
	
	





	

}
