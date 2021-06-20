package com.backend.gym.servicios;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.gym.modelos.Rutina;
import com.backend.gym.repositorios.IRutinaRepository;

@Service
public class RutinaService {
	private static final Logger logger = LoggerFactory.getLogger(RutinaService.class);

    @Autowired
    private IRutinaRepository rutinaRepository;

    /**
     * Consulta el rutina por id
     * @param id
     * @return Rutina
     */
    public Optional<Rutina> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Rutina> rutina= rutinaRepository.findById(id);
        return rutina;
    }
    /**
     * Consulta todos los rutinas
     * @return List<Rutina>
     */
    public List<Rutina> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Rutina> rutinas = rutinaRepository.findAll();
        return rutinas;
    }
    /**
     * Crea un nuevo rutina
     * @param Rutina
     * @return Rutina
     */
    public Optional<Rutina> crear(Rutina rutina) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(rutinaRepository.save(rutina));
    }
    /**
     * Actualiza una rutina
     * @param Rutina
     * @return Rutina
     */
    public Optional<Rutina> actualizar(Rutina rutina) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(rutinaRepository.save(rutina));
    }
    
    /**
     * Elimina un rutina
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	rutinaRepository.deleteById(id);
    }
}
