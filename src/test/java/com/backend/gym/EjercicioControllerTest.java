package com.backend.gym;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.backend.gym.modelos.Ejercicio;
import com.backend.gym.repositorios.IEjercicioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import static org.hamcrest.Matchers.*;
import org.junit.AfterClass;
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
 * Pruebas unitarias para la entidad ejercicio 
 *
 * @author Alejandro Aguirre
 * @date 10/01/2021
 * @since 10/01/2021
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EjercicioControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
    private static Ejercicio crearEjercicio;
    
    private static IEjercicioRepository ejercicioRepository;
    
    @Autowired
    public void setEjercicioRepository (IEjercicioRepository r) {
    	ejercicioRepository= r;
    }

    private String token;

    @Test
    public void test1WhenCrearEjercicioSuccess() throws Exception {
    	String filename = EjercicioControllerTest.class.getResource("/testdata/Ejercicio.json").getPath();
    	Gson gson = new Gson();
    	JsonReader reader = new JsonReader(new FileReader(filename));
    	Ejercicio ejercicio= gson.fromJson(reader, Ejercicio.class);
    	MvcResult result=this.mockMvc.perform(post("/gym/ejercicio").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token)
                .content(asJsonString(ejercicio)))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
    	crearEjercicio= new ObjectMapper().readValue(json, Ejercicio.class);
    }
    @Test
    public void test2WhenCreateEjercicioFailure() throws Exception {
    	String filename = EjercicioControllerTest.class.getResource("/testdata/EjercicioInvalido.json").getPath();
    	Gson gson = new Gson();
    	JsonReader reader = new JsonReader(new FileReader(filename));
    	Ejercicio ejercicio= gson.fromJson(reader, Ejercicio.class);
        this.mockMvc.perform(post("/gym/ejercicio").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token)
                .content(asJsonString(ejercicio)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test3WhenConsultarEjercicioSuccess() throws Exception {
        this.mockMvc.perform(get("/gym/ejercicio").header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }
    
    @Test
    public void test4WhenObtenerEjercicioSuccess() throws Exception {
    	this.mockMvc.perform(get("/gym/ejercicio/"+crearEjercicio.getId()).header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }
    
    @Test
    public void test5WhenObtenerEjercicioFailure() throws Exception {
    	this.mockMvc.perform(get("/gym/ejercicio/"+crearEjercicio.getId()+"1").header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isBadRequest());
    }
    
    @AfterClass
    public static void after() throws Exception {
    	ejercicioRepository.deleteById(crearEjercicio.getId());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
