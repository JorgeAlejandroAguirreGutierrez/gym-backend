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

import com.backend.gym.modelos.Usuario;
import com.backend.gym.modelos.Objetivo;
import com.backend.gym.modelos.Observacion;
import com.backend.gym.modelos.Perfil;
import com.backend.gym.modelos.Peso;
import com.backend.gym.modelos.Sesion;
import com.backend.gym.modelos.Suscripcion;
import com.backend.gym.repositorios.IUsuarioRepository;

@Component
@Order(2)
@Profile({"dev","prod"})
public class UsuarioDatos implements ApplicationRunner {
	@Autowired
    private IUsuarioRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Usuario> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(new Usuario("DIEGO ARCILA", "15956607", "admin123",
            		25, 45, new Perfil(1), new ArrayList<Sesion>(), new ArrayList<Peso>(),
            		new ArrayList<Observacion>(), new ArrayList<Objetivo>(), new ArrayList<Suscripcion>()));
            rep.saveAll(usuarios);
        }
    }
}
