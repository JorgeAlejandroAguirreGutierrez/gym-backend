package com.backend.gym.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.gym.modelos.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {
	@Query(value="select c from cliente c "  
			+" WHERE c.identificacion=:identificacion AND c.contrasena=:contrasena")
	public Optional<Cliente> buscarNombreContrasena(String identificacion, String contrasena);
}
