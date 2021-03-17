package com.backend.gym.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.gym.modelos.Suscripcion;

@Repository
public interface ISuscripcionRepository extends JpaRepository<Suscripcion, Long>, JpaSpecificationExecutor<Suscripcion> {
	@Query(value="select * from suscripcion s INNER JOIN usuario u ON u.id=s.usuario_id where u.identificacion= :identificacion  order by fecha desc LIMIT 1", nativeQuery = true)
	public Optional<Suscripcion> obtenerUltimaSuscripcionPorUsuario(String identificacion);
}
