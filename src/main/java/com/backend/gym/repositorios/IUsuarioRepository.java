package com.backend.gym.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.gym.modelos.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
	@Query(value="select u from Usuario u "  
			+" WHERE u.identificacion=:identificacion AND u.contrasena=:contrasena")
	public Optional<Usuario> buscarIdentificacionContrasena(String identificacion, String contrasena);
	
	@Query(value="select u from Usuario u "  
			+" WHERE u.identificacion=:identificacion")
	public Optional<Usuario> buscarIdentificacion(String identificacion);
	
	@Query(value="select u from Usuario u JOIN u.suscripciones s "  
			+" WHERE EXTRACT(MONTH FROM s.fecha) = EXTRACT(MONTH FROM CURRENT_DATE)")
	public List<Usuario> generarPDF();
}
