package com.backend.gym.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.gym.modelos.Usuario;
import com.backend.gym.servicios.UsuarioService;

import static com.backend.gym.Constantes.USUARIOCONTROLLER;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(USUARIOCONTROLLER)
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
    @Autowired
    private UsuarioService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Usuario> usuarios=servicio.consultar();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("id") long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> usuario=servicio.obtener(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody @Valid Usuario _usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> usuario=servicio.crear(_usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody @Valid Usuario _usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> usuario=servicio.actualizar(_usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") long id)  {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping(value = "/consultarClientesPorNombreIdentificacion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultarPorTipo(@RequestParam("nombre") String nombre, @RequestParam("identificacion") String identificacion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Usuario> usuarios=servicio.consultarClientesPorNombreIdentificacion(nombre, identificacion);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
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
    
    @GetMapping(value="/obtenerPorIdentificacion/{identificacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPorIdentificacion(@PathVariable("identificacion") String identificacion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> usuario=servicio.obtenerPorIdentificacion(identificacion);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @PostMapping(value="/crearCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearCliente(@RequestBody @Valid Usuario _usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> usuario=servicio.crearCliente(_usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @PostMapping(value="/crearAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crearAdmin(@RequestBody @Valid Usuario _usuario) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Usuario> usuario=servicio.crearAdmin(_usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    
    @GetMapping(value="/reporte", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> reporte() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        ByteArrayInputStream pdf = servicio.generarPDF();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=factura.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }
}
