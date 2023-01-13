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
			+" where u.identificacion=:identificacion and u.contrasena=:contrasena")
	public Optional<Usuario> buscarIdentificacionContrasena(String identificacion, String contrasena);
	
	@Query(value="select u from Usuario u "  
			+" where u.identificacion=:identificacion")
	public Optional<Usuario> buscarIdentificacion(String identificacion);
	
	@Query(value="select u from Usuario u "  
			+" where u.perfil.descripcion='CLIENTE' and (u.nombre like %:usuario% or u.identificacion like %:usuario%)")
	public List<Usuario> consultarClientesPorNombreIdentificacion(String usuario);
	
	@Query(value="select u from Usuario u join u.suscripciones s "  
			+" where EXTRACT(MONTH FROM s.fecha) = :mes and EXTRACT(YEAR FROM s.fecha) = :ano")
	public List<Usuario> generarPDF(int mes, int ano);
}
