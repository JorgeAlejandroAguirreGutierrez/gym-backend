package com.backend.gym.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.gym.Constantes;
import com.backend.gym.exception.ModeloNoExistenteException;
import com.backend.gym.exception.SesionInvalidaException;
import com.backend.gym.exception.SuscripcionInvalidaException;
import com.backend.gym.modelos.Usuario;
import com.backend.gym.modelos.Sesion;
import com.backend.gym.modelos.Suscripcion;
import com.backend.gym.repositorios.IUsuarioRepository;
import com.backend.gym.repositorios.ISesionRepository;
import com.backend.gym.repositorios.ISuscripcionRepository;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SesionService {
	
	private static final Logger logger = LoggerFactory.getLogger(SesionService.class);
	
	@Autowired
    private ISesionRepository sesionRepository;
    
    @Autowired
    private IUsuarioRepository usuarioRepository;
    
    @Autowired
    private ISuscripcionRepository suscripcionRepository;

    /**
     * Consulta la sesion por id
     * @param id
     * @return Sesion
     */
    public Optional<Sesion> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Sesion> sesion= sesionRepository.findById(id);
        return sesion;
    }
    /**
     * Consulta todas las sesiones
     * @return List<Sesion>
     */
    public List<Sesion> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Sesion> sesiones= sesionRepository.findAll();
        return sesiones;
    }
    /**
     * Crea una nueva sesion
     * @param Sesion
     * @return Sesion 
     */
    public Optional<Sesion> crear(Sesion sesion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	Optional<Usuario> usuario=usuarioRepository.buscarIdentificacionContrasena(sesion.getUsuario().getIdentificacion(), sesion.getUsuario().getContrasena());
    	if (usuario.isPresent() && usuario.get().getPerfil().getDescripcion().equals(Constantes.PERFILADMIN)) {
    		sesion.setUsuario(usuario.get());
    		return Optional.of(sesionRepository.save(sesion));
    	}
    	Optional<Suscripcion> suscripcion=suscripcionRepository.obtenerUltimaSuscripcionPorUsuario(sesion.getUsuario().getIdentificacion());
    	if(usuario.isPresent()) {
			sesion.setUsuario(usuario.get());
    		if (suscripcion.isPresent()) {
    			long startTime = suscripcion.get().getFecha().getTime();
    			long endTime = new Date().getTime();
    			long diffTime = endTime - startTime;
    			long diffDays = diffTime / (1000 * 60 * 60 * 24);
    			if(diffDays<30) {
    				sesion.setUsuario(usuario.get());
    	    		return Optional.of(sesionRepository.save(sesion));
    			}
    			throw new SuscripcionInvalidaException();
    		}    		
    		throw new SuscripcionInvalidaException();
    	}
    	throw new ModeloNoExistenteException();
    }
    /**
     * Actualiza una sesion
     * @param Sesion
     * @return Sesion
     */
    public Optional<Sesion> actualizar(Sesion sesion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(sesionRepository.save(sesion));
    }
    
    /**
     * Elimina una sesion
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	sesionRepository.deleteById(id);
    }
    
    /**
     * Valida la sesion del usuario por id
     * @param id
     * @return Sesion
     */
    public Optional<Sesion> validar(Sesion _sesion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Sesion> sesion= sesionRepository.findById(_sesion.getId());		
		if (sesion.isPresent()) {
			if (usuario.get().getPerfil().getDescripcion().equals(Constantes.PERFILADMIN)){					
				sesion.get().setEndpoint(_sesion.getEndpoint());
				long startTime = sesion.get().getFechaApertura().getTime();
				long endTime = new Date().getTime();
				long diffTime = endTime - startTime;
				long diffDays = diffTime / (1000 * 60 * 60 * 24);
				if(diffDays<1 && diffDays<30) {
					return sesion;
				}
				throw new SesionInvalidaException();
			}
			if (usuario.get().getPerfil().getDescripcion().equals(Constantes.PERFILCLIENTE)){
				Optional<Suscripcion> suscripcion=suscripcionRepository.obtenerUltimaSuscripcionPorUsuario(sesion.get().getUsuario().getIdentificacion());
				if(suscripcion.isPresent()){
					long startTimeSuscripcion = suscripcion.get().getFecha().getTime();
					long endTimeSuscripcion = new Date().getTime();
					long diffTimeSuscripcion = endTimeSuscripcion - startTimeSuscripcion;
					long diffDaysSuscripcion = diffTimeSuscripcion / (1000 * 60 * 60 * 24);
					
					sesion.get().setEndpoint(_sesion.getEndpoint());
					long startTime = sesion.get().getFechaApertura().getTime();
					long endTime = new Date().getTime();
					long diffTime = endTime - startTime;
					long diffDays = diffTime / (1000 * 60 * 60 * 24);
					if(diffDays<1 && diffDays<30) {
						return sesion;
					}
					throw new SesionInvalidaException();
				}
				throw new SesionInvalidaException();
			}
			throw new SesionInvalidaException();
        }
        throw new ModeloNoExistenteException();
    }
}
