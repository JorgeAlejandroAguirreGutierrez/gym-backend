package com.backend.gym.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.backend.gym.modelos.Parametro;
import com.backend.gym.repositorios.IParametroRepository;

@Component
@Order(1)
public class ParametroDatos implements ApplicationRunner {
	@Autowired
    private IParametroRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	Optional<Parametro> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Parametro> parametros= new ArrayList<>();
            parametros.add(new Parametro("KILOGRAMOS", "KG", "MEDIDAPESO", true));
            parametros.add(new Parametro("LIBRAS", "LB", "MEDIDAPESO", true));
            parametros.add(new Parametro("SEGUNDOS", "SEG", "MEDIDATIEMPO", true));
            parametros.add(new Parametro("MINUTOS", "MIN", "MEDIDATIEMPO", true));
            parametros.add(new Parametro("HORAS", "HORAS", "MEDIDATIEMPO", true));
            //SLIDERS
            parametros.add(new Parametro("", "slider1.jpg", "SLIDER", false));
            parametros.add(new Parametro("", "slider2.jpg", "SLIDER", false));
            parametros.add(new Parametro("", "slider3.jpg", "SLIDER", false));
            parametros.add(new Parametro("", "slider4.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider5.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider6.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider7.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider8.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider9.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider10.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider11.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider12.jpg", "SLIDER", true));
            parametros.add(new Parametro("", "slider13.jpg", "SLIDER", true));
            //SERVICIOS
            parametros.add(new Parametro("", "servicio1.jpeg", "SERVICIO", true));
            parametros.add(new Parametro("", "servicio2.jpeg", "SERVICIO", true));
            parametros.add(new Parametro("", "servicio3.jpeg", "SERVICIO", true));
            
            parametros.add(new Parametro("AUMENTO DE MASA MUSCULAR", "Mediante el entrenamiento con pesas "
            		+ "y maquinas se tendra un aumento en la masa muscular, siguiendo el desarrollo de un "
            		+ "plan especifico para cada grupo muscular.", "DESCRIPCION", true));
            parametros.add(new Parametro("ENTRENAMIENTO CARDIOVASCULAR", "Mediante la practica de estos ejercicios "
            		+ "se pondra en movimiento los musculos mayores del cuerpo durante un periodo prolongado "
            		+ "ayudando a quemar grasa y perder calorias.", "DESCRIPCION", true));
            parametros.add(new Parametro("ENTRENAMIENTO FUNCIONAL", "Rutina de ejercicios "
            		+ "que se desarrollan repitiendo parametros similares a determinados movimientos "
            		+ "cotidianos como caminar, saltar, subir escaleras, levantar cargas, arrastrar; entre otros.", "DESCRIPCION", true));
            rep.saveAll(parametros);
        }
    }
}
