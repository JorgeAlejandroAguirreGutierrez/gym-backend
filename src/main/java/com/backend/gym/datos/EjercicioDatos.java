package com.backend.gym.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.backend.gym.modelos.Ejercicio;
import com.backend.gym.modelos.TipoMusculo;
import com.backend.gym.repositorios.IEjercicioRepository;

@Component
@Order(4)
public class EjercicioDatos implements ApplicationRunner {
	@Autowired
    private IEjercicioRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Ejercicio> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Ejercicio> ejercicios= new ArrayList<>();
            //MUSCULO 
            
            //BICEPS
            ejercicios.add(new Ejercicio("CURL MARTILLO", "CURL_MARTILLO.png", new TipoMusculo(1)));
            ejercicios.add(new Ejercicio("CURL BARRA", "CURL_BARRA.png", new TipoMusculo(1)));
            ejercicios.add(new Ejercicio("CURL MANCUERNA", "CURL_MANCUERNA.jpg", new TipoMusculo(1)));
            ejercicios.add(new Ejercicio("CURL SCOTT", "CURL_SCOTT.jpg", new TipoMusculo(1)));
            ejercicios.add(new Ejercicio("CURL POLEA", "CURL_POLEA.png", new TipoMusculo(1)));
            ejercicios.add(new Ejercicio("CURL MANCUERNA INCLINADO", "CURL_MANCUERNA_INCLINADO.jpg", new TipoMusculo(1)));
            ejercicios.add(new Ejercicio("CURL CONCENTRADO", "CURL_CONCENTRADO.png", new TipoMusculo(1)));
            ejercicios.add(new Ejercicio("CURL DE BICEPS EN TRX", "CURL_DE_BICEPS_EN_TRX.jpg", new TipoMusculo(1)));
            
            //TRICEPS
            ejercicios.add(new Ejercicio("EXTENSION DE POLEA", "EXTENSION_POLEA.jpg", new TipoMusculo(2))); 
            ejercicios.add(new Ejercicio("FONDOS", "FONDOS.png", new TipoMusculo(2))); 
            ejercicios.add(new Ejercicio("PUSH DOWN", "PUSH_DOWN.png", new TipoMusculo(2)));
            ejercicios.add(new Ejercicio("SUPINO", "SUPINO.jpg", new TipoMusculo(2)));
            ejercicios.add(new Ejercicio("PRESS FRANCES", "PRESS_FRANCES.jpg", new TipoMusculo(2)));
            ejercicios.add(new Ejercicio("PRESS FRANCES CON BANCO INCLINADO", "PRESS_FRANCES_CON_BANCO_INCLINADO.jpg", new TipoMusculo(2)));
            ejercicios.add(new Ejercicio("EXTENSION DE TRICEPS CON MANCUERNA A UNA MANO", "EXTENSION_DE_TRICEPS_CON_MANCUERNA_A_UNA_MANO.jpg", new TipoMusculo(2)));
            ejercicios.add(new Ejercicio("PRESS COPA", "EXTENSION_DE_TRICEPS_CON_MANCUERNAS.jpg", new TipoMusculo(2)));
            ejercicios.add(new Ejercicio("EXTENSION DE TRICEPS CON TRX", "EXTENSION_DE_TRICEPS_EN_TRX.jpg", new TipoMusculo(2)));
            
            //ESPALDA
            ejercicios.add(new Ejercicio("DOMINADAS", "DOMINADAS.png", new TipoMusculo(3)));
            ejercicios.add(new Ejercicio("REMO BARRA T", "REMO_BARRA_T.jpg", new TipoMusculo(3)));
            ejercicios.add(new Ejercicio("REMO CON MANCUERNA", "REMO_CON_MANCUERNA.png", new TipoMusculo(3)));
            ejercicios.add(new Ejercicio("REMO AL PISO", "REMO_AL_PISO.png", new TipoMusculo(3))); 
            ejercicios.add(new Ejercicio("REMO CON BARRA", "REMO_CON_BARRA.png", new TipoMusculo(3))); 
            ejercicios.add(new Ejercicio("JALON POLEA ADELANTE", "JALONES_ADELANTE.png", new TipoMusculo(3))); 
            ejercicios.add(new Ejercicio("JALON POLEA ATRAS", "JALON_POLEA_ATRAS.png", new TipoMusculo(3)));
            ejercicios.add(new Ejercicio("JALON POLEA ALTA", "JALON_POLEA_ALTA.png", new TipoMusculo(3)));
            ejercicios.add(new Ejercicio("DORSALES EN MAQUINA HAMMER", "DORSALES_EN_MAQUINA_HAMMER.png", new TipoMusculo(3)));
            
            //PECHO
            ejercicios.add(new Ejercicio("PECHO PLANO", "PECHO_PLANO.png", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("PECHO INCLINADO", "PECHO_INCLINADO.png", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("PECHO DECLINADO", "PECHO_DECLINADO.png", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("APERTURA CON MANCUERNAS BANCO DECLINADO", "APERTURA_CON_MANCUERNAS_BANCO_DECLINADO.jpg", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("APERTURA CON MANCUERNAS BANCO PLANO", "APERTURA_CON_MANCUERNAS_BANCO_PLANO.png", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("APERTURA CON MANCUERNAS BANCO INCLINADO", "APERTURA_CON_MANCUERNAS_BANCO_INCLINADO.png", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("FONDOS", "FONDOS.png", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("PECK DECK", "PECK_DECK.png", new TipoMusculo(4))); 
            ejercicios.add(new Ejercicio("PRESS CON MANCUERNAS BANCO PLANO", "PRESS_CON_MANCUERNAS_PECHO_PLANO.jpg", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("PRESS CON MANCUERNAS BANCO INCLINADO", "PRESS_CON_MANCUERNAS_PECHO_INCLINADO.png", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("PRESS CON MANCUERNAS BANCO DECLINADO", "PRESS_CON_MANCUERNAS_PECHO_DECLINADO.jpg", new TipoMusculo(4)));
            ejercicios.add(new Ejercicio("PULL OVER CON MANCUERNA", "PULL_OVER_MANCUERNA.jpg", new TipoMusculo(4))); 
            ejercicios.add(new Ejercicio("PRESS EN MAQUINA MULTIFUNCIONAL", "PRESS_EN_MAQUINA_MULTIFUNCIONAL.png", new TipoMusculo(4))); 
            
            
            //PIERNA
            ejercicios.add(new Ejercicio("EXTENSION DE PIERNAS", "EXTENSION_DE_PIERNAS.png", new TipoMusculo(5)));
            ejercicios.add(new Ejercicio("CURL PIERNA DECLINADO", "CURL_PIERNA_DECLINADO.png", new TipoMusculo(5))); 
            ejercicios.add(new Ejercicio("CURL UNA PIERNA DECLINADO", "CURL_UNA_PIERNA_DECLINADO.jpg", new TipoMusculo(5))); 
            ejercicios.add(new Ejercicio("CURL UNA PIERNA DE PIE", "CURL_UNA_PIERNA_DE_PIE.png", new TipoMusculo(5))); 
            ejercicios.add(new Ejercicio("PRENSA PIERNAS INCLINADO", "PRENSA_PIERNAS_INCLINADO.png", new TipoMusculo(5)));
            ejercicios.add(new Ejercicio("PRENSA PIERNAS PLANO", "PRENSA_PIERNAS_PLANO.png", new TipoMusculo(5))); 
            ejercicios.add(new Ejercicio("SENTADILLA LIBRE", "SENTADILLA_LIBRE.png", new TipoMusculo(5)));
            ejercicios.add(new Ejercicio("SENTADILLA HACK", "SENTADILLA_HACK.png", new TipoMusculo(5)));
            ejercicios.add(new Ejercicio("SENTADILLAS EN TRX", "SENTADILLAS_EN_TRX.jpg", new TipoMusculo(5)));
            ejercicios.add(new Ejercicio("SENTADILLA CON BARRA", "SENTADILLA_CON_BARRA.png", new TipoMusculo(9)));
            
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
            
            //ANTEBRAZO
            ejercicios.add(new Ejercicio("CUERDA CON MANCUERNA SUPINACION", "CUERDA_CON_MANCUERNA_SUPINACION.jpg", new TipoMusculo(8)));
            ejercicios.add(new Ejercicio("CURL DE MUÑECA", "CURL_DE_MUNECA.png", new TipoMusculo(8)));
            ejercicios.add(new Ejercicio("CURL DE MUÑECA INVERTIDO", "CURL_DE_MUNECA_INVERTIDO.jpg", new TipoMusculo(8)));
            ejercicios.add(new Ejercicio("CURL MUÑECA EN SUPINACION", "CURL_MUNECA_EN_SUPINACION.jpg", new TipoMusculo(8)));
            
            
            //ADUCTORES
            ejercicios.add(new Ejercicio("SENTADILLA CON APOYO", "SENTADILLA_CON_APOYO.png", new TipoMusculo(9)));
            ejercicios.add(new Ejercicio("SENTADILLA ABIERTA", "SENTADILLA_ABIERTA.png", new TipoMusculo(9)));
            ejercicios.add(new Ejercicio("TIJERA LATERAL", "TIJERA_LATERAL.jpg", new TipoMusculo(9)));
            ejercicios.add(new Ejercicio("DESPLAZAMIENTO LATERAL CON PESO", "DESPLAZAMIENTO_LATERAL_CON_PESO.png", new TipoMusculo(9)));
            ejercicios.add(new Ejercicio("PRESS DE PIERNA ABIERTA", "PRESS_DE_PIERNA_ABIERTA.png", new TipoMusculo(9)));
            
            //ABDUCTORES
            ejercicios.add(new Ejercicio("ELEVACIONES LATERALES DE PIERNA EN MAQUINA", "ELEVACIONES_LATERALES_DE_PIERNA_EN_MAQUINA.png", new TipoMusculo(10)));
            
            
            //GLUTEO
            ejercicios.add(new Ejercicio("SENTADILLA BULGARA", "SENTADILLA_BULGARA.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("ZANCADAS CON MANCUERNAS", "ZANCADAS_CON_MANCUERNAS.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("DESPLANTES", "DESPLANTES.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("ZANCADA LATERAL CON MANCUERNAS", "ZANCADA_LATERAL_CON_MANCUERNAS.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("ZANCADA LATERAL CON BARRA", "ZANCADA_LATERAL_CON_BARRA.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("ZANCADA ADELANTE CON BARRA", "ZANCADA_ADELANTE_CON_BARRA.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("SENTADILLA PROFUNDA", "SENTADILLA_PROFUNDA.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("HIP THRUST", "HIP_THRUST.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("HIP THRUST CON BARRA", "HIP_THRUST_CON_BARRA.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("TIJERA EN MAQUINA HACK", "TIJERA_EN_MAQUINA_HACK.jpg", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("TIJERA EN TRX", "TIJERA_EN_TRX.jpg", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("PESO MUERTO CON BARRA", "PESO_MUERTO_CON_BARRA.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("PESO MUERTO RUMANO", "PESO_MUERTO_RUMANO.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("PESO MUERTO SENTADILLA ABIERTA", "PESO_MUERTO_SENTADILLA_ABIERTA.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("HIPEREXTENSIONES EN MAQUINA", "HIPEREXTENSIONES_EN_MAQUINA.png", new TipoMusculo(11)));
            
            //PANTORILLAS
            ejercicios.add(new Ejercicio("ELEVACION DE TALONES EN MAQUINA HACK", "ELEVACION_DE_TALONES_EN_MAQUINA_HACK.png", new TipoMusculo(12)));
            ejercicios.add(new Ejercicio("ELEVACION DE TALONES CON BARRA", "ELEVACION_DE_TALONES_CON_BARRA.jpg", new TipoMusculo(12)));
            ejercicios.add(new Ejercicio("ELEVACION DE TALONES EN MAQUINA DE PANTORRILLA", "ELEVACION_DE_TALONES_EN_MAQUINA_DE_PANTORRILLA.png", new TipoMusculo(12)));
            
            //FUNCIONAL
            ejercicios.add(new Ejercicio("BURPEES", "BURPEES.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("MOUNTAIN CLIMBER", "MOUNTAIN_CLIMBER.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("JUMPING JACK", "JUMPING_JACK.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("SENTADILLA CON SALTO", "SENTADILLA_CON_SALTO.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("PUSH UPS", "PUSH_UPS.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("FLEXIONES EN RODILLAS", "FLEXIONES_EN_RODILLAS.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("FLEXIONES CON NUDILLOS", "FLEXIONES_CON_NUDILLOS.jpg", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("FLEXIONES CON PALMAS", "FLEXIONES_CON_PALMAS.jpg", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("FLEXIONES EN BANCO PLANO", "FLEXIONES_EN_BANCO_PLANO.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("SKIPPING", "SKIPPING.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("SALTO CON CUERDA", "SALTO_CON_CUERDA.jpg", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("TROTAR", "TROTAR.png", new TipoMusculo(13)));
            ejercicios.add(new Ejercicio("SPRINTS EN TRX", "SPRINTS_EN_TRX.png", new TipoMusculo(13)));
            
            //FECHA: 29 DE ABRIL DEL 2021
            //GLUTEO
            ejercicios.add(new Ejercicio("PATADA DE GLUTEO", "PATADA_DE_GLUTEO.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("SENTADILLA SUMO", "SENTADILLA_SUMO.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("PESO MUERTO SUMO", "PESO_MUERTO_SUMO.png", new TipoMusculo(11)));
            ejercicios.add(new Ejercicio("TIJERA CON DESPLAZAMIENTO", "TIJERA_CON_DESPLZAMIENTO.png", new TipoMusculo(11)));
            
            //ABDOMINALES
            ejercicios.add(new Ejercicio("FLEXION LATERAL CON PESA", "FLEXION_LATERAL_CON_PESA.jpg", new TipoMusculo(6)));
            ejercicios.add(new Ejercicio("PLANCHAS", "PLANCHAS.png", new TipoMusculo(6)));
            
            //TRICEPS
            ejercicios.add(new Ejercicio("FONDOS EN MAQUINA HAMMER", "FONDOS_MAQUINA_HAMMER.jpg", new TipoMusculo(2)));
            ejercicios.add(new Ejercicio("KICK BACK", "KICK_BACK.jpg", new TipoMusculo(2)));
            ejercicios.add(new Ejercicio("PRESS CERRADO", "PRESS_CERRADO.png", new TipoMusculo(2)));
            
            //CARDIO
            ejercicios.add(new Ejercicio("TROTADORA", "TROTADORA.png", new TipoMusculo(14)));
            ejercicios.add(new Ejercicio("ELIPTICA", "ELIPTICA.png", new TipoMusculo(14)));
            ejercicios.add(new Ejercicio("BICICLETA", "BICICLETA.png", new TipoMusculo(14)));
            
            //FUNCIONAL
            ejercicios.add(new Ejercicio("ESCALERA DE EJERCICIOS", "ESCALERA_DE_EJERCICIOS.jpg", new TipoMusculo(14)));
            ejercicios.add(new Ejercicio("PRESS DE HOMBROS PESA RUSA", "PRESS_HOMBROS_PESA_RUSA.png", new TipoMusculo(14)));
            ejercicios.add(new Ejercicio("SWINGS A UNA MANO PESA RUSA", "SWINGS_A_UNA_MANO_PESA_RUSA.png", new TipoMusculo(14)));
            ejercicios.add(new Ejercicio("SQUAT SUMO", "SQUAT_SUMO.png", new TipoMusculo(14)));
            ejercicios.add(new Ejercicio("LOUNGES PRESS HOMBRO PESA RUSA", "LOUNGES_PRESS_HOMBRO_PESA_RUSA.png", new TipoMusculo(14)));
            ejercicios.add(new Ejercicio("SWING HOMBROS PESA RUSA", "SWING_HOMBROS_PESA_RUSA.jpeg", new TipoMusculo(14)));
            
            //TOTAL
            rep.saveAll(ejercicios);
        }
    }
}
