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

import com.backend.gym.modelos.Cliente;
import com.backend.gym.modelos.Objetivo;
import com.backend.gym.modelos.Observacion;
import com.backend.gym.modelos.Perfil;
import com.backend.gym.modelos.Sesion;
import com.backend.gym.modelos.Suscripcion;
import com.backend.gym.repositorios.IClienteRepository;

@Component
@Order(2)
@Profile({"dev","prod"})
public class ClienteDatos implements ApplicationRunner {
	@Autowired
    private IClienteRepository rep;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Cliente> ant=rep.findById((long) 1);
        if (!ant.isPresent()) {
            List<Cliente> clientes = new ArrayList<>();
         
            clientes.add(new Cliente("DIEGO ARCILA", "1053847608", "admin123",
            		"TALLA1","PESO1", "EDAD1", "", new Perfil(1), new ArrayList<Sesion>(),
            		new ArrayList<Observacion>(), new ArrayList<Objetivo>(), new ArrayList<Suscripcion>()));
            clientes.add(new Cliente("JORGE ALEJANDRO AGUIRRRE GUTIERREZ", "1053847607", "cliente123",
            		"32","75KG", "25", "", new Perfil(2), new ArrayList<Sesion>(),
            		new ArrayList<Observacion>(), new ArrayList<Objetivo>(), new ArrayList<Suscripcion>()));
            rep.saveAll(clientes);
        }
    }
}
