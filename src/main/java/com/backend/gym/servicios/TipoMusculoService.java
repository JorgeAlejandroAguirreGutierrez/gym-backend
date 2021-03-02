package com.backend.gym.servicios;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.gym.modelos.TipoMusculo;
import com.backend.gym.repositorios.ITipoMusculoRepository;

@Service
public class TipoMusculoService {
	private static final Logger logger = LoggerFactory.getLogger(TipoMusculoService.class);

    @Autowired
    private ITipoMusculoRepository tipoMusculoRepository;

    /**
     * Consulta el tipo de musculo por id
     * @param id
     * @return TipoMusculo
     */
    public Optional<TipoMusculo> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<TipoMusculo> tipoMusculo= tipoMusculoRepository.findById(id);
        return tipoMusculo;
    }
    /**
     * Consulta todos los tipos de musculos
     * @return List<TipoMusculo>
     */
    public List<TipoMusculo> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<TipoMusculo> tiposMusculo = tipoMusculoRepository.findAll();
        return tiposMusculo;
    }
    /**
     * Crea un nuevo tipo de musculo
     * @param TipoMusculo
     * @return TipoMusculo
     */
    public Optional<TipoMusculo> crear(TipoMusculo tipoMusculo) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(tipoMusculoRepository.save(tipoMusculo));
    }
    /**
     * Actualiza un tipo de musculo
     * @param TipoMusculo
     * @return TipoMusculo
     */
    public Optional<TipoMusculo> actualizar(TipoMusculo tipoMusculo) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(tipoMusculoRepository.save(tipoMusculo));
    }
    
    /**
     * Elimina un tipo de musculo
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	tipoMusculoRepository.deleteById(id);
    }
}
