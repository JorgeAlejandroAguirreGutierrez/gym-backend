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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.gym.modelos.Ejercicio;
import com.backend.gym.modelos.Parametro;
import com.backend.gym.servicios.EjercicioService;

import static com.backend.gym.Constantes.EJERCICIOCONTROLLER;
import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(EJERCICIOCONTROLLER)
@Validated
public class EjercicioController {
	private static final Logger logger = LoggerFactory.getLogger(EjercicioController.class);
	
    @Autowired
    private EjercicioService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Ejercicio> ejercicios=servicio.consultar();
        return new ResponseEntity<>(ejercicios, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("id") long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Ejercicio> ejercicio=servicio.obtener(id);
        return new ResponseEntity<>(ejercicio, HttpStatus.OK);
    }
    
    @GetMapping(value = "/consultarPorDescripcion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultarPorTipo(@RequestParam("descripcion") String descripcion) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Ejercicio> ejercicios=servicio.consultarPorDescripcion(descripcion);
        return new ResponseEntity<>(ejercicios, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody @Valid Ejercicio _ejercicio) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Ejercicio> ejercicio=servicio.crear(_ejercicio);
        return new ResponseEntity<>(ejercicio, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody Ejercicio _ejercicio) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Ejercicio> ejercicio=servicio.actualizar(_ejercicio);
        return new ResponseEntity<>(ejercicio, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") long id)  {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value = "/imagen/{id}", headers = "content-type=multipart/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> imagen(@RequestPart("imagen") MultipartFile imagen, @PathVariable("productoId") long id ) throws Exception {
        boolean bandera=servicio.imagen(imagen, id);
        return new ResponseEntity<>(bandera, HttpStatus.OK);
    }
}
