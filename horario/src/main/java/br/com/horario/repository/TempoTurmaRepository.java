package br.com.horario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.TempoTurmaRepresentationModel;
import br.com.horario.entity.TurnoEntity;

@Repository
public interface TempoTurmaRepository extends JpaRepository<TempoTurmaRepresentationModel,Long>{
	
	 //Lista a quantidade de candidaturas por vaga em um edital de extensão
	 @Query(value = "SELECT t.id_turma as id,t.nome as turma, c.nome as curso, tur.nome as turno, SUM(d.tempo) as tempo\r\n"
	 		+ "FROM horario.turma t , horario.curso c, horario.matriz_curricular mc, horario.disciplina d, horario.etapa e,horario.turno tur\r\n"
	 		+ "where t.curso_id = c.id_curso \r\n"
	 		+ "and t.ativo = true \r\n"
	 		+ "and c.id_curso = mc.curso_id \r\n"
	 		+ "and mc.id_matriz_curricular = d.matriz_curricular_id and d.area_fim = true and t.turno_id = 3 \r\n"
	 		+ "and t.etapa_id = e.id_etapa\r\n"
	 		+ "and t.etapa_id = d.etapa_id\r\n"
	 		+ "and t.turno_id = tur.id_turno\r\n"
	 		+ "and t.ativo = true\r\n"
	 		+ "group by t.id_turma;", nativeQuery = true)
	 List<TempoTurmaRepresentationModel> listarTemposPorTurma(@Param("turno_id") TurnoEntity turno);

}
