package br.com.horario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.horario.model.SetorModel;

public interface SetorRepository extends JpaRepository<SetorModel, Long>{
	
	List<SetorModel> findAllByIdEscola(Long idEscola);

}
