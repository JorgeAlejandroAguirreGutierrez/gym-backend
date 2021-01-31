package com.backend.gym.servicios;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.gym.modelos.Perfil;
import com.backend.gym.repositorios.IPerfilRepository;

@Service
public class PerfilService {
	
	private static final Logger logger = LoggerFactory.getLogger(PerfilService.class);

    @Autowired
    private IPerfilRepository perfilRepository;

    /**
     * Consulta el perfil por id
     * @param id
     * @return Perfil
     */
    public Optional<Perfil> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Perfil> perfil=perfilRepository.findById(id);
        return perfil;
    }
    /**
     * Consulta todos los perfiles
     * @return List<Perfil>
     */
    public List<Perfil> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Perfil> perfiles = perfilRepository.findAll();
        return perfiles;
    }
    /**
     * Crea un nuevo perfil
     * @param Perfil
     * @return Perfil 
     */
    public Optional<Perfil> crear(Perfil usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(perfilRepository.save(usuario));
    }
    /**
     * Actualiza un perfil
     * @param Perfil
     * @return Perfil
     */
    public Optional<Perfil> actualizar(Perfil usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(perfilRepository.save(usuario));
    }
    
    /**
     * Elimina un perfil
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	perfilRepository.deleteById(id);
    }
}
