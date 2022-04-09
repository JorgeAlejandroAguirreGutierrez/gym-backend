package com.backend.gym.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.gym.modelos.Ejercicio;

@Repository
public interface IEjercicioRepository extends JpaRepository<Ejercicio, Long>, JpaSpecificationExecutor<Ejercicio> {
	@Query(value="select e from Ejercicio e "  
			+" where e.nombre like %:nombre% or e.nombrePersonalizado like %:nombre%")
	public List<Ejercicio> consultarPorNombre(String nombre);
	
	@Query(value="select e from Ejercicio e "  
			+" where e.tipoMusculo.id=:tipoMusculoId")
	public List<Ejercicio> consultarPorTipoMusculo(long tipoMusculoId);
}
