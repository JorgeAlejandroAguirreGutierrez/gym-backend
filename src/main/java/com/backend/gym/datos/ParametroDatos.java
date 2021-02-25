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

import com.backend.gym.modelos.Parametro;
import com.backend.gym.repositorios.IParametroRepository;

@Component
@Order(2)
@Profile({"dev","prod"})
public class ParametroDatos implements ApplicationRunner {
	@Autowired
    private IParametroRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Parametro> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Parametro> parametros= new ArrayList<>();
            //MUSCULO
            parametros.add(new Parametro(null, "BICEPS", "MUSCULO", true));
            parametros.add(new Parametro(null, "TRICEPS", "MUSCULO", true));
            parametros.add(new Parametro(null, "BRAZO", "MUSCULO", true));
            parametros.add(new Parametro(null, "ESPALDA", "MUSCULO", true));
            parametros.add(new Parametro(null, "PECHO", "MUSCULO", true));
            parametros.add(new Parametro(null, "ABDOMEN", "MUSCULO", true));
            parametros.add(new Parametro(null, "HOMBRO", "MUSCULO", true));
            parametros.add(new Parametro(null, "PIERNA", "MUSCULO", true));
            parametros.add(new Parametro(null, "PANTORRILLA", "MUSCULO", true));
            
            
            rep.saveAll(parametros);
        }
    }
}
