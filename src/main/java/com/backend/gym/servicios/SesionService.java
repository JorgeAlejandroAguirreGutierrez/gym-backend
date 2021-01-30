package com.backend.gym.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.gym.exception.ModeloNoExistenteException;
import com.backend.gym.modelos.Cliente;
import com.backend.gym.modelos.Sesion;
import com.backend.gym.repositorios.IClienteRepository;
import com.backend.gym.repositorios.ISesionRepository;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;

@Service
public class SesionService {
	
	private static final Logger logger = LoggerFactory.getLogger(SesionService.class);
	
	@Autowired
    private ISesionRepository sesionRepository;
    
    @Autowired
    private IClienteRepository clienteRepository;

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
    	Optional<Cliente> cliente=clienteRepository.buscarNombreContrasena(sesion.getCliente().getIdentificacion(), sesion.getCliente().getContrasena());
    	if(cliente.isPresent()) {
    		sesion.setCliente(cliente.get());
    		return Optional.of(sesionRepository.save(sesion));
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
	
}
