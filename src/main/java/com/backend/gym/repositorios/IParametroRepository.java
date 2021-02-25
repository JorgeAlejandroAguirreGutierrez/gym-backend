package com.backend.gym.repositorios;

import com.backend.gym.modelos.Usuario;
import com.backend.gym.modelos.Parametro;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IParametroRepository extends JpaRepository<Parametro, Long>, JpaSpecificationExecutor<Parametro> {

	@Query(value="select p from Parametro p "  
			+" WHERE p.tipo=:tipo")
	public List<Usuario> consultarPorTipo(String tipo);
}
