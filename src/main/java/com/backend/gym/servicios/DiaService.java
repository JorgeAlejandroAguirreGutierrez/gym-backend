package com.backend.gym.servicios;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.gym.modelos.Dia;
import com.backend.gym.repositorios.IDiaRepository;

@Service
public class DiaService {
	private static final Logger logger = LoggerFactory.getLogger(DiaService.class);

    @Autowired
    private IDiaRepository diaRepository;

    /**
     * Consulta el dia por id
     * @param id
     * @return Dia
     */
    public Optional<Dia> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Dia> dia= diaRepository.findById(id);
        return dia;
    }
    /**
     * Consulta todos los dias
     * @return List<Dia>
     */
    public List<Dia> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Dia> ejercicios = diaRepository.findAll();
        return ejercicios;
    }
    /**
     * Crea un nuevo dia
     * @param Dia
     * @return Dia
     */
    public Optional<Dia> crear(Dia ejercicio) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(diaRepository.save(ejercicio));
    }
    /**
     * Actualiza un Dia
     * @param Dia
     * @return Dia
     */
    public Optional<Dia> actualizar(Dia ejercicio) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(diaRepository.save(ejercicio));
    }
    
    /**
     * Elimina un dia
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	diaRepository.deleteById(id);
    }
}
