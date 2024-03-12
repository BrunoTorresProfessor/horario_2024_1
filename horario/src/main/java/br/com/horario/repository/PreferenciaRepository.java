package br.com.horario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.PreferenciaRepresentationModel;


@Repository
public interface PreferenciaRepository extends JpaRepository<PreferenciaRepresentationModel,Long>{
	
	 //Lista a quantidade de candidaturas por vaga em um edital de extensão
	 @Query(value = "SELECT d.id_disciplina as id, c.nome as curso, d.nome as disciplina, e.nome as etapa, 0 as ordem\r\n"
	 		+ "FROM horario.disciplina_habilitacao dh, horario.disciplina d, horario.docente doc, horario.habilitacao h,\r\n"
	 		+ "horario.matriz_curricular mc,horario.curso c, horario.etapa e\r\n"
	 		+ "where dh.habilitacao_id = h.id_habilitacao\r\n"
	 		+ "and dh.disciplina_id = d.id_disciplina\r\n"
	 		+ "and mc.id_matriz_curricular = d.matriz_curricular_id\r\n"
	 		+ "and mc.curso_id = c.id_curso\r\n"
	 		+ "and d.etapa_id = e.id_etapa\r\n"
	 		+ "and doc.habilitacao_id = 1\r\n"
	 		+ "and dh.habilitacao_id = 1\r\n"
	 		+ "group by d.id_disciplina\r\n"
	 		+ "order by c.nome, e.nome", nativeQuery = true)
	 List<PreferenciaRepresentationModel> listarDisciplinaDocentePreferencia();

}
