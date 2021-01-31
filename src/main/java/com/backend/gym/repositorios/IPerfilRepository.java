package com.backend.gym.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.backend.gym.modelos.Perfil;

@Repository
public interface IPerfilRepository  extends JpaRepository<Perfil, Long>, JpaSpecificationExecutor<Perfil>  {
	
}
