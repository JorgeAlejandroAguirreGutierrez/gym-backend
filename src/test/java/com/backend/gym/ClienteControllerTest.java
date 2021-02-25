package com.backend.gym;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.backend.gym.modelos.Usuario;
import com.backend.gym.repositorios.IUsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import static org.hamcrest.Matchers.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.FileReader;

/**
 * Pruebas unitarias para la entidad cliente 
 *
 * @author Alejandro Aguirre
 * @date 10/01/2021
 * @since 10/01/2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    
    private static Usuario crearCliente;
    
    private static IUsuarioRepository clienteRepository;
    
    @Autowired
    public void setTypeRemittanceRepository (IUsuarioRepository c) {
    	clienteRepository= c;
    }

    private String token;

    @Test
    public void test1WhenCreateClienteSuccess() throws Exception {
    	String filename = ClienteControllerTest.class.getResource("/testdata/Cliente.json").getPath();
    	Gson gson = new Gson();
    	JsonReader reader = new JsonReader(new FileReader(filename));
    	Usuario cliente= gson.fromJson(reader, Usuario.class);
    	MvcResult result=this.mockMvc.perform(post("/gym/cliente").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token)
                .content(asJsonString(cliente)))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
    	crearCliente= new ObjectMapper().readValue(json, Usuario.class);
    }
    @Test
    public void test2WhenCreateCustomerFailure() throws Exception {
    	String filename = ClienteControllerTest.class.getResource("/testdata/ClienteInvalido.json").getPath();
    	Gson gson = new Gson();
    	JsonReader reader = new JsonReader(new FileReader(filename));
    	Usuario cliente= gson.fromJson(reader, Usuario.class);
        this.mockMvc.perform(post("/gym/cliente").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token)
                .content(asJsonString(cliente)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test3WhenConsultarClienteSuccess() throws Exception {
        this.mockMvc.perform(get("/gym/cliente").header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }
    
    @Test
    public void test4WhenObtenerClienteSuccess() throws Exception {
    	this.mockMvc.perform(get("/gym/cliente/"+crearCliente.getId()).header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }
    
    @Test
    public void test5WhenObtenerClienteFailure() throws Exception {
    	this.mockMvc.perform(get("/gym/cliente/"+crearCliente.getId()+"1").header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isBadRequest());
    }
    
    @AfterClass
    public static void after() throws Exception {
    	//clienteRepository.deleteById(crearCliente.getId());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
