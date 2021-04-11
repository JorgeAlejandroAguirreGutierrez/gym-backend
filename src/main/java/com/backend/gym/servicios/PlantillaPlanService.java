package com.backend.gym.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.gym.modelos.PlantillaPlan;
import com.backend.gym.repositorios.IPlantillaPlanRepository;
import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.Predicate;

@Service
public class PlantillaPlanService {
	private static final Logger logger = LoggerFactory.getLogger(PlantillaPlanService.class);

    @Autowired
    private IPlantillaPlanRepository plantillaPlanRepository;

    /**
     * Consulta el cliente por id
     * @param id
     * @return Cliente
     */
    public Optional<PlantillaPlan> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<PlantillaPlan> plantillaPlanEntrenamiento= plantillaPlanRepository.findById(id);
        return plantillaPlanEntrenamiento;
    }
    /**
     * Consulta todos los clientes
     * @return List<Usuario>
     */
    public List<PlantillaPlan> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<PlantillaPlan> plantillasPlanEntrenamiento = plantillaPlanRepository.findAll();
        return plantillasPlanEntrenamiento;
    }
    
    /**
     * Consulta las plantillas por nombre y somatotipo
     * @return List<PlantillaPlan>
     */
    public List<PlantillaPlan> buscar(String nombre, String somatotipo) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  plantillaPlanRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    if (nombre!=null && !nombre.equals("")) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nombre"), "%"+nombre+"%")));
		        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		    }
		    if (somatotipo!=null && !somatotipo.equals("")) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("somatotipo"), "%"+somatotipo+"%")));
		        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		    }
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    /**
     * Crea un nuevo cliente
     * @param Usuario
     * @return Cliente 
     */
    public Optional<PlantillaPlan> crear(PlantillaPlan plantillaPlanEntrenamiento) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(plantillaPlanRepository.save(plantillaPlanEntrenamiento));
    }
    /**
     * Actualiza un usuario
     * @param Usuario
     * @return Optional<Usuario>
     */
    public Optional<PlantillaPlan> actualizar(PlantillaPlan usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(plantillaPlanRepository.save(usuario));
    }
    
    /**
     * Elimina un cliente
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	plantillaPlanRepository.deleteById(id);
    }    
}
