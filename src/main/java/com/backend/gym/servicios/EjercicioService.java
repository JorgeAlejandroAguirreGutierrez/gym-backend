package com.backend.gym.servicios;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.backend.gym.Util;
import com.backend.gym.exception.ModeloNoExistenteException;
import com.backend.gym.modelos.Ejercicio;
import com.backend.gym.repositorios.IEjercicioRepository;

@Service
public class EjercicioService {
	private static final Logger logger = LoggerFactory.getLogger(EjercicioService.class);

    @Autowired
    private IEjercicioRepository ejercicioRepository;

    /**
     * Consulta el ejercicio por id
     * @param id
     * @return Ejercicio
     */
    public Optional<Ejercicio> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Ejercicio> ejercicio= ejercicioRepository.findById(id);
        return ejercicio;
    }
    /**
     * Consulta todos los ejercicios
     * @return List<Ejercicio>
     */
    public List<Ejercicio> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Ejercicio> ejercicios = ejercicioRepository.findAll();
        return ejercicios;
    }
    /**
     * Crea un nuevo ejercicio
     * @param Ejercicio
     * @return Ejercicio
     */
    public Optional<Ejercicio> crear(Ejercicio ejercicio) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(ejercicioRepository.save(ejercicio));
    }
    /**
     * Actualiza un ejercicio
     * @param Ejercicio
     * @return Ejercicio
     */
    public Optional<Ejercicio> actualizar(Ejercicio ejercicio) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(ejercicioRepository.save(ejercicio));
    }
    
    /**
     * Elimina un ejercicio
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	ejercicioRepository.deleteById(id);
    }
    
    /**
     * Consulta los ejercicios por su nombre o nombre personalizado
     * @return List<Ejercicio>
     */
    public List<Ejercicio> consultarPorNombre(String nombre) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  ejercicioRepository.consultarPorNombre(nombre);
    }
    
    /**
     * Consulta los ejercicios por el tipo de musculo
     * @return List<Ejercicio>
     */
    public List<Ejercicio> consultarPorTipoMusculo(long tipoMusculoId) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  ejercicioRepository.consultarPorTipoMusculo(tipoMusculoId);
    }
    
    public boolean imagen(MultipartFile archivo, long id) throws Exception {
    	Optional<Ejercicio>ejercicio=ejercicioRepository.findById(id);
    	String ruta=Util.guardarArchivo(archivo, id);
    	if(ejercicio.isPresent()) {
    		Ejercicio getEjercicio=ejercicio.get();
    		getEjercicio.setImagen(ruta);
    		ejercicioRepository.save(getEjercicio);
    		return true;
    	}
    	throw new ModeloNoExistenteException();	
    }
}
