package com.backend.gym.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "nombre")
	private String nombre;
	
	@NotNull
    @NotEmpty
    @Column(name = "contrasena")
	private String contrasena;
	
	@NotNull
    @NotEmpty
    @Column(name = "imagen")
	private String imagen;
	
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public String getImagen() {
		return imagen;
	}
}
