package com.backend.gym.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.gym.modelos.Perfil;

@Repository
public interface IPerfilRepository  extends JpaRepository<Perfil, Long>, JpaSpecificationExecutor<Perfil>  {
	@Query(value="select p from Perfil p "  
			+" WHERE p.descripcion=:descripcion")
	public Optional<Perfil> obtenerPorDescripcion(String descripcion);
}
