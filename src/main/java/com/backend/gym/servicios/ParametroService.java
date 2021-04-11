package com.backend.gym.servicios;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.gym.modelos.Parametro;
import com.backend.gym.repositorios.IParametroRepository;

@Service
public class ParametroService {
	private static final Logger logger = LoggerFactory.getLogger(ParametroService.class);

    @Autowired
    private IParametroRepository parametroRepository;

    /**
     * Consulta el parametro por id
     * @param id
     * @return Parametro
     */
    public Optional<Parametro> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Parametro> parametro= parametroRepository.findById(id);
        return parametro;
    }
    /**
     * Consulta todos los parametros
     * @return List<Parametro>
     */
    public List<Parametro> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Parametro> parametros = parametroRepository.findAll();
        return parametros;
    }
    /**
     * Crea un nuevo parametro
     * @param Parametro
     * @return Optional<Parametro> 
     */
    public Optional<Parametro> crear(Parametro producto) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	producto.setActivo(true);
    	return Optional.of(parametroRepository.save(producto));
    }
    /**
     * Actualiza un Parametro
     * @param Parametro
     * @return Optional<Parametro>
     */
    public Optional<Parametro> actualizar(Parametro parametro) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(parametroRepository.save(parametro));
    }
    
    /**
     * Elimina un parametro
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	parametroRepository.deleteById(id);
    }
    
    /**
     * Consulta los parametros por tipo
     * @return List<Parametro>
     */
    public List<Parametro> consultarPorTipo(String tipo) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  parametroRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    if (tipo!=null && !tipo.equals("")) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tipo"), tipo)));
		        predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("activo"), true)));
		        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		    }
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("id"), 0)));
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Consulta los parametros por titulo y tipo
     * @return List<Parametro>
     */
    public List<Parametro> consultarPorTituloTipo(String titulo, String tipo) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  parametroRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    if (titulo != null && !titulo.equals("") && tipo!=null && !tipo.equals("")) {
		    	predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("titulo"), titulo)));
		        predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tipo"), tipo)));
		        predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("activo"), true)));
		        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		    }
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("id"), 0)));
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
}
