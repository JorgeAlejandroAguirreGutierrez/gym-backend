package com.backend.gym.datos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.backend.gym.modelos.TipoMusculo;
import com.backend.gym.repositorios.ITipoMusculoRepository;

@Component
@Order(3)
public class TipoMusculoDatos implements ApplicationRunner {
	@Autowired
    private ITipoMusculoRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<TipoMusculo> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<TipoMusculo> tiposMusculo= new ArrayList<>();
            tiposMusculo.add(new TipoMusculo("BICEPS"));//1
            tiposMusculo.add(new TipoMusculo("TRICEPS")); //2
            tiposMusculo.add(new TipoMusculo("ESPALDA")); //3
            tiposMusculo.add(new TipoMusculo("PECHO")); //4
            tiposMusculo.add(new TipoMusculo("PIERNA")); //5
            tiposMusculo.add(new TipoMusculo("ABDOMEN")); //6
            tiposMusculo.add(new TipoMusculo("HOMBRO")); //7
            tiposMusculo.add(new TipoMusculo("ANTEBRAZO")); //8
            tiposMusculo.add(new TipoMusculo("ADUCTORES")); //9
            tiposMusculo.add(new TipoMusculo("ABDUCTORES")); //10
            tiposMusculo.add(new TipoMusculo("GLUTEO")); //11
            tiposMusculo.add(new TipoMusculo("PANTORRILLAS")); //12
            tiposMusculo.add(new TipoMusculo("FUNCIONAL")); //13
            tiposMusculo.add(new TipoMusculo("CARDIO")); //14
            tiposMusculo.add(new TipoMusculo("HIT BOX FUNCIONAL")); //14
            
            
            rep.saveAll(tiposMusculo);
        }
    }
}
