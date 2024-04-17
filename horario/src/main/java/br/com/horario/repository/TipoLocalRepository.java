package br.com.horario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.horario.entity.TipoLocalEntity;

@Repository
public interface TipoLocalRepository  extends JpaRepository<TipoLocalEntity, Long> {

	TipoLocalEntity getOneByIdTipoLocal(Long idTipoLocal);

}
