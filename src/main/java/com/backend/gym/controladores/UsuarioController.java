package com.backend.gym.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.gym.modelos.Usuario;
import com.backend.gym.servicios.UsuarioService;

import static com.backend.gym.Constantes.USUARIOCONTROLLER;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(USUARIOCONTROLLER)
@Validated
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
    @Autowired
    private UsuarioService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Usuario> clientes=servicio.consultar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("id") long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> cliente=servicio.obtener(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody Usuario _cliente) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> cliente=servicio.crear(_cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody Usuario _cliente) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> cliente=servicio.actualizar(_cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") long id)  {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value="/buscar",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscar(@RequestBody Usuario _cliente) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Usuario> clientes=servicio.buscar(_cliente);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    
    @GetMapping(value="/consultarClientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultarClientes() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Usuario> clientes=servicio.consultarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    @GetMapping(value="/consultarAdminis", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultarAdministradores() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Usuario> usuarios=servicio.consultarAdmins();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
