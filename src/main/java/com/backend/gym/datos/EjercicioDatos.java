package com.backend.gym.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.backend.gym.modelos.Ejercicio;
import com.backend.gym.modelos.TipoMusculo;
import com.backend.gym.repositorios.IEjercicioRepository;

@Component
@Order(4)
@Profile({"dev","prod"})
public class EjercicioDatos implements ApplicationRunner {
	@Autowired
    private IEjercicioRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Ejercicio> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Ejercicio> ejercicios= new ArrayList<>();
            //MUSCULO 
            
            //BICEPS 7 
            ejercicios.add(new Ejercicio("CURL MARTILLO", "CURL_MARTILLO.png", new TipoMusculo(1))); //BICEPS
            ejercicios.add(new Ejercicio("CURL BARRA", "CURL_BARRA.png", new TipoMusculo(1))); //BICEPS
            ejercicios.add(new Ejercicio("CURL MANCUERNA", "CURL_MANCUERNA.jpg", new TipoMusculo(1))); //BICEPS
            ejercicios.add(new Ejercicio("CURL SCOTT", "CURL_SCOTT.jpg", new TipoMusculo(1))); //BICEPS
            ejercicios.add(new Ejercicio("CURL POLEA", "CURL_POLEA.png", new TipoMusculo(1))); //BICEPS
            ejercicios.add(new Ejercicio("CURL MANCUERNA INCLINADO", "CURL_MANCUERNA_INCLINADO.jpg", new TipoMusculo(1))); //BICEPS
            ejercicios.add(new Ejercicio("CURL CONCENTRADO", "CURL_CONCENTRADO.png", new TipoMusculo(1))); //BICEPS
            
            //TRICEPS 4
            ejercicios.add(new Ejercicio("EXTENSION DE POLEA", "EXTENSION_POLEA.jpg", new TipoMusculo(2))); //TRICEPS
            ejercicios.add(new Ejercicio("FONDOS", "FONDOS.png", new TipoMusculo(2))); //TRICEPS
            ejercicios.add(new Ejercicio("PUSH DOWN", "PUSH_DOWN.png", new TipoMusculo(2))); //TRICEPS
            ejercicios.add(new Ejercicio("SUPINO", "SUPINO.jpg", new TipoMusculo(2))); //TRICEPS
            
            
            //ESPALDA 8
            ejercicios.add(new Ejercicio("DOMINADAS", "DOMINADAS.png", new TipoMusculo(3))); //ESPALDA
            ejercicios.add(new Ejercicio("REMO BARRA T", "REMO_BARRA_T.jpg", new TipoMusculo(3))); //ESPALDA
            ejercicios.add(new Ejercicio("REMO CON MANCUERNA", "REMO_CON_MANCUERNA.png", new TipoMusculo(3))); //ESPALDA
            ejercicios.add(new Ejercicio("REMO AL PISO", "REMO_AL_PISO.png", new TipoMusculo(3))); //ESPALDA
            ejercicios.add(new Ejercicio("REMO CON BARRA", "REMO_CON_BARRA.png", new TipoMusculo(3))); //ESPALDA
            ejercicios.add(new Ejercicio("JALONES ADELANTE", "JALONES_ADELANTE.png", new TipoMusculo(3))); //ESPALDA            
            
            //PECHO 13
            ejercicios.add(new Ejercicio("PECHO PLANO", "PECHO_PLANO.png", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("PECHO INCLINADO", "PECHO_INCLINADO.png", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("PECHO DECLINADO", "PECHO_DECLINADO.png", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("APERTURA CON MANCUERNAS BANCO DECLINADO", "APERTURA_CON_MANCUERNAS_BANCO_DECLINADO.jpg", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("APERTURA CON MANCUERNAS BANCO PLANO", "APERTURA_CON_MANCUERNAS_BANCO_PLANO.png", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("APERTURA CON MANCUERNAS BANCO INCLINADO", "APERTURA_CON_MANCUERNAS_BANCO_INCLINADO.png", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("FONDOS", "FONDOS.png", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("PECK DECK", "PECK_DECK.png", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("PRESS CON MANCUERNAS PECHO PLANO", "PRESS_CON_MANCUERNAS_PECHO_PLANO.jpg", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("PRESS CON MANCUERNAS PECHO INCLINADO", "PRESS_CON_MANCUERNAS_PECHO_INCLINADO.png", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("PRESS CON MANCUERNAS PECHO DECLINADO", "PRESS_CON_MANCUERNAS_PECHO_DECLINADO.jpg", new TipoMusculo(4))); //PECHO
            ejercicios.add(new Ejercicio("PULL OVER CON MANCUERNA", "PULL_OVER_MANCUERNA.jpg", new TipoMusculo(4))); //PECHO
            
            
            //PIERNA 7
            ejercicios.add(new Ejercicio("CURL PIERNA", "CURL_PIERNA.png", new TipoMusculo(5))); //PIERNA
            ejercicios.add(new Ejercicio("CURL PIERNA DECLINADO", "CURL_PIERNA_DECLINADO.png", new TipoMusculo(5))); //PIERNA
            ejercicios.add(new Ejercicio("CURL UNA PIERNA DECLINADO", "CURL_UNA_PIERNA_DECLINADO.jpg", new TipoMusculo(5))); //PIERNA
            ejercicios.add(new Ejercicio("CURL UNA PIERNA DE PIE", "CURL_UNA_PIERNA_DE_PIE.png", new TipoMusculo(5))); //PIERNA
            ejercicios.add(new Ejercicio("PRENSA PIERNAS INCLINADO", "PRENSA_PIERNAS_INCLINADO.png", new TipoMusculo(5))); //PIERNA
            ejercicios.add(new Ejercicio("PRENSA PIERNAS PLANO", "PRENSA_PIERNAS_PLANO.png", new TipoMusculo(5))); //PIERNA
            
            //ABDOMEN
            
            ejercicios.add(new Ejercicio("ABDOMINALES EN MAQUINA", "ABDOMINALES_EN_MAQUINA.png", new TipoMusculo(6))); 
            ejercicios.add(new Ejercicio("ABDOMINALES EN BANCA INCLINADA", "ABDOMINALES_BANCA_INCLINADA.jpg", new TipoMusculo(6))); 
            ejercicios.add(new Ejercicio("ABDOMINALES CON ELEVACION DE PIERNAS", "ABDOMINALES_CON_ELEVACION_PIERNAS.png", new TipoMusculo(6))); 
            ejercicios.add(new Ejercicio("ABDOMINALES CON RUEDA", "ABDOMINALES_CON_RUEDA.png", new TipoMusculo(6))); 
            ejercicios.add(new Ejercicio("ABDOMINALES EN TRX", "ABDOMINALES_EN_TRX.png", new TipoMusculo(6))); 
            ejercicios.add(new Ejercicio("ABDOMINALES CON PIERNA CRUZADA", "ABDOMINALES_CON_PIERNA_CRUZADA.png", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("FLEXION Y EXTENSION DE PIERNAS", "FLEXION_EXTENSION_DE_PIERNAS.png", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("CRUNCH CON BALON MEDICINAL", "CRUNCH_CON_BALON_MEDICINAL.png", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("CRUNCHES", "CRUNCHES.png", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("DOBLE CRUNCH", "DOBLE_CRUNCH.png", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("ABDOMINALES CON ELEVACION DE RODILLAS EN BARRA DE DOMINADAS", "ABDOMINALES_CON_ELEVACION_DE_RODILLAS_EN_BARRA_DE_DOMINADAS.png", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("GIROS RUSOS", "GIROS_RUSOS.png", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("FLEXION LATERAL DE TORSO CON MANCUERNAS", "FLEXION_LATERAL_DE_TORSO_CON_MANCUERNAS.jpg", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("FLEXION LATERAL DE TORSO", "FLEXION_LATERAL_DE_TORSO.jpg", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("CRUNCH LATERAL", "CRUNCH_LATERAL.jpg", new TipoMusculo(6)));
            
            //HOMBRO
            ejercicios.add(new Ejercicio("PRESS MILITAR CON BARRA", "PRESS_MILITAR_CON_BARRA.jpg", new TipoMusculo(7)));
            ejercicios.add(new Ejercicio("PRESS MILITAR CON MANCUERNA", "PRESS_MILITAR_CON_MANCUERNA.png", new TipoMusculo(7)));
            ejercicios.add(new Ejercicio("PRESS EN MAQUINA HAMMER", "PRESS_EN_MAQUINA_HAMMER.png", new TipoMusculo(7)));
            ejercicios.add(new Ejercicio("ELEVACION LATERAL CON MANCUERNAS", "ELEVACION_LATERAL_CON_MANCUERNAS.png", new TipoMusculo(7)));
            ejercicios.add(new Ejercicio("ELEVACIONES FRONTALES", "ELEVACIONES_FRONTALES.png", new TipoMusculo(7)));
            ejercicios.add(new Ejercicio("ELEVACIONES LATERALES TUMBADO", "ELEVACIONES_LATERALES_TUMBADO.jpg", new TipoMusculo(7)));
            ejercicios.add(new Ejercicio("PRESS ARNOLD", "PRESS_ARNOLD.png", new TipoMusculo(7)));
            ejercicios.add(new Ejercicio("ELEVACIONES LATERALES A UNA MANO", "ELEVACIONES_LATERALES_A_UNA_MANO.png", new TipoMusculo(7)));
            ejercicios.add(new Ejercicio("REMO PARADO", "REMO_PARADO.jpg", new TipoMusculo(7)));
            
            //TOTAL 39
            rep.saveAll(ejercicios);
        }
    }
}
