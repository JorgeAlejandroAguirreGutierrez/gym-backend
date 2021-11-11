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

import com.backend.gym.modelos.Dia;
import com.backend.gym.servicios.DiaService;

import static com.backend.gym.Constantes.DIACONTROLLER;
import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping(DIACONTROLLER)
@Validated
public class DiaController {
	private static final Logger logger = LoggerFactory.getLogger(DiaController.class);
	
    @Autowired
    private DiaService servicio;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        List<Dia> ejercicios=servicio.consultar();
        return new ResponseEntity<>(ejercicios, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtener(@PathVariable("id") long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Dia> ejercicio=servicio.obtener(id);
        return new ResponseEntity<>(ejercicio, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody @Valid Dia _dia) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Dia> dia=servicio.crear(_dia);
        return new ResponseEntity<>(dia, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody @Valid Dia _dia) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        Optional<Dia> dia=servicio.actualizar(_dia);
        return new ResponseEntity<>(dia, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") long id)  {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        servicio.eliminar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
