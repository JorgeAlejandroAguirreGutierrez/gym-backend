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
import com.backend.gym.modelos.TipoMusculo;
import com.backend.gym.repositorios.IParametroRepository;
import com.backend.gym.repositorios.ITipoMusculoRepository;

@Component
@Order(3)
@Profile({"dev","prod"})
public class TipoMusculoDatos implements ApplicationRunner {
	@Autowired
    private ITipoMusculoRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<TipoMusculo> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<TipoMusculo> tiposMusculo= new ArrayList<>();
            tiposMusculo.add(new TipoMusculo("BICEPS"));
            tiposMusculo.add(new TipoMusculo("TRICEPS"));
            tiposMusculo.add(new TipoMusculo("ESPALDA"));
            tiposMusculo.add(new TipoMusculo("PECHO"));
            tiposMusculo.add(new TipoMusculo("PIERNA"));
            tiposMusculo.add(new TipoMusculo("ABDOMEN"));
            tiposMusculo.add(new TipoMusculo("HOMBRO"));
            tiposMusculo.add(new TipoMusculo("PANTORRILLA"));
            tiposMusculo.add(new TipoMusculo("ANTEBRAZO"));
            
            
            rep.saveAll(tiposMusculo);
        }
    }
}
