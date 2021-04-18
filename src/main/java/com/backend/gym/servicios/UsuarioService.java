package com.backend.gym.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.gym.Constantes;
import com.backend.gym.Util;
import com.backend.gym.exception.ModeloNoExistenteException;
import com.backend.gym.modelos.Perfil;
import com.backend.gym.modelos.Usuario;
import com.backend.gym.repositorios.IPerfilRepository;
import com.backend.gym.repositorios.IUsuarioRepository;

import static com.backend.gym.Constantes.PERFILCLIENTE;
import static com.backend.gym.Constantes.PERFILADMIN;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

@Service
public class UsuarioService {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private IUsuarioRepository usuarioRepository;
    
    @Autowired
    private IPerfilRepository perfilRepository;

    /**
     * Consulta el cliente por id
     * @param id
     * @return Cliente
     */
    public Optional<Usuario> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Usuario> usuario= usuarioRepository.findById(id);
        return usuario;
    }
    /**
     * Consulta todos los clientes
     * @return List<Usuario>
     */
    public List<Usuario> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }
    /**
     * Crea un nuevo cliente
     * @param Usuario
     * @return Cliente 
     */
    public Optional<Usuario> crear(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(usuarioRepository.save(usuario));
    }
    /**
     * Actualiza un usuario
     * @param Usuario
     * @return Optional<Usuario>
     */
    public Optional<Usuario> actualizar(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(usuarioRepository.save(usuario));
    }
    
    /**
     * Elimina un cliente
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	usuarioRepository.deleteById(id);
    }
    
    /**
     * Consulta los usuarios por nombre o deintificacion
     * @return List<Usuario>
     */
    public List<Usuario> consultarClientesPorNombreIdentificacion(String nombre, String identificacion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  usuarioRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    if (nombre!=null && !nombre.equals("")) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nombre"), "%"+nombre+"%")));
		    }
		    if (identificacion!=null && !identificacion.equals("")) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("identificacion"), "%"+identificacion+"%")));
		    }
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("perfil").get("descripcion"), Constantes.PERFILCLIENTE)));
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Consulta los usuarios que tienes perfil CLIENTE
     * @return List<Usuario>
     */
    public List<Usuario> consultarClientes() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  usuarioRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("perfil").get("descripcion"), Constantes.PERFILCLIENTE)));
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Consulta los usuarios que tienes perfil ADMIN
     * @return List<Usuario>
     */
    public List<Usuario> consultarAdmins() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  usuarioRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("perfil").get("descripcion"), Constantes.PERFILADMIN)));
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Obtiene el  usuario por la identificacion
     * @return Optional<Usuario>
     */
    public Optional<Usuario> obtenerPorIdentificacion(String identificacion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  usuarioRepository.findOne((root, criteriaQuery, criteriaBuilder) -> {
		    List<Predicate> predicates = new ArrayList<>();
		    if (identificacion!=null) {
		        predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("identificacion"), identificacion)));
		    }
		    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		});
    }
    
    /**
     * Crea un nuevo cliente
     * @param Usuario
     * @return Usuario 
     */
    public Optional<Usuario> crearCliente(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	Optional<Perfil> perfil= perfilRepository.obtenerPorDescripcion(PERFILCLIENTE);
    	if(perfil.isPresent()) {
    		usuario.setPerfil(perfil.get());
        	String contrasena=Util.generarContrasena(usuario.getIdentificacion());
        	usuario.setContrasena(contrasena);
        	usuario.setActivo(false);
    		return Optional.of(usuarioRepository.save(usuario));
    	}
    	throw new ModeloNoExistenteException();
    }
    
    /**
     * Crea un nuevo Admin
     * @param Usuario
     * @return Usuario 
     */
    public Optional<Usuario> crearAdmin(Usuario usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	Optional<Perfil> perfil= perfilRepository.obtenerPorDescripcion(PERFILADMIN);
    	if(perfil.isPresent()) {
    		usuario.setPerfil(perfil.get());
    		long conteo=usuarioRepository.count();
        	String contrasena=Util.generarContrasena(conteo);
        	usuario.setContrasena(contrasena);
        	usuario.setActivo(true);
    		return Optional.of(usuarioRepository.save(usuario));
    	}
    	throw new ModeloNoExistenteException();
    }
}
