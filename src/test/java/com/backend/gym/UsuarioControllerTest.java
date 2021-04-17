package com.backend.gym;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.backend.gym.modelos.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import static org.hamcrest.Matchers.*;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
public class UsuarioControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    private static Usuario crearUsuario;

    private String token;

    @Test
    public void testA1WhenCreateClienteSuccess() throws Exception {
    	String filename = UsuarioControllerTest.class.getResource("/testdata/Usuario.json").getPath();
    	Gson gson = new Gson();
    	JsonReader reader = new JsonReader(new FileReader(filename));
    	Usuario usuario= gson.fromJson(reader, Usuario.class);
    	MvcResult result=this.mockMvc.perform(post("/gym/usuario/crearCliente").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token)
                .content(asJsonString(usuario)))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
    	crearUsuario= new ObjectMapper().readValue(json, Usuario.class);
    }
    @Test
    public void testA2WhenCreateClienteFailure() throws Exception {
    	String filename = UsuarioControllerTest.class.getResource("/testdata/UsuarioInvalido.json").getPath();
    	Gson gson = new Gson();
    	JsonReader reader = new JsonReader(new FileReader(filename));
    	Usuario usuario= gson.fromJson(reader, Usuario.class);
        this.mockMvc.perform(post("/gym/usuario/crearCliente").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token)
                .content(asJsonString(usuario)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testA3WhenConsultarUsuarioSuccess() throws Exception {
        this.mockMvc.perform(get("/gym/cliente").header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }
    
    @Test
    public void test4WhenObtenerUsuarioSuccess() throws Exception {
    	this.mockMvc.perform(get("/gym/cliente/"+crearUsuario.getId()).header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }
    
    @Test
    public void testA5WhenObtenerUsuarioFailure() throws Exception {
    	this.mockMvc.perform(get("/gym/usuario/"+crearUsuario.getId()+"1").header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isBadRequest());
    }
    
    @Test
    public void testA6WhenUpdateUsuarioSuccess() throws Exception {
    	crearUsuario.setEdad(20);
    	MvcResult result=this.mockMvc.perform(put("/gym/usuario").contentType(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + token)
                .content(asJsonString(crearUsuario)))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
    	crearUsuario= new ObjectMapper().readValue(json, Usuario.class);
    }
    
    @Test
    public void testA7WhenConsultarClientesPorNombreIdentificacionSuccess() throws Exception {
    	MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    	params.add("nombre", crearUsuario.getNombre());
    	params.add("nombre", crearUsuario.getIdentificacion());
    	MvcResult result=this.mockMvc.perform(put("/gym/usuario/consultarClientesPorNombreIdentificacion").contentType(MediaType.APPLICATION_JSON)
    			.queryParams(params)
    			.header("Authorization", "Bearer " + token)
                .content(asJsonString(crearUsuario)))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
    	crearUsuario= new ObjectMapper().readValue(json, Usuario.class);
    }
    
    @Test
    public void testA8WhenConsultarClientesSuccess() throws Exception {
    	this.mockMvc.perform(get("/gym/usuario/consultarClientes").header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }
    
    @Test
    public void testA9WhenConsultarAdminsSuccess() throws Exception {
    	this.mockMvc.perform(get("/gym/usuario/consultarAdmins").header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }
    
    @Test
    public void testB1WhenObtenerPorIdentificacionSuccess() throws Exception {
    	this.mockMvc.perform(get("/gym/usuario/obtenerPorIdentificacion/"+crearUsuario.getIdentificacion()).header("Authorization", "Bearer " + token)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(not(empty()))));
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
