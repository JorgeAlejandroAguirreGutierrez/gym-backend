package com.backend.gym.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "ejercicio")
public class Ejercicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @JsonProperty("codigo")
    @Column(name = "codigo")
	private String codigo;
	
	@NotNull
    @NotEmpty
    @JsonProperty("descripcion")
    @Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
    @NotEmpty
    @JsonProperty("tipo")
    @Column(name = "tipo")
	private String tipo;
	
	@NotNull
    @NotEmpty
    @JsonProperty("imagen")
    @Column(name = "imagen")
	private String imagen;
	
	public long getId() {
		return id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
}
