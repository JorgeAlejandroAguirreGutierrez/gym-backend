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

import com.backend.gym.modelos.Perfil;
import com.backend.gym.repositorios.IPerfilRepository;

@Component
@Order(1)
@Profile({"dev","prod"})
public class PerfilDatos implements ApplicationRunner {
	
	@Autowired
    private IPerfilRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Perfil> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Perfil> perfiles= new ArrayList<>();
         
            perfiles.add(new Perfil("ADMIN"));
            perfiles.add(new Perfil("CLIENTE"));
            rep.saveAll(perfiles);
        }
    }

}
