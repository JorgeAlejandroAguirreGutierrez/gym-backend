package com.backend.gym.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	 
	@NotNull
    @NotEmpty
    @JsonProperty("nombre")
    @Column(name = "nombre")
    private String nombre;
	
    @JsonProperty("contrasena")
    @Column(name = "contrasena")
	private String contrasena;
	
	@NotNull
    @NotEmpty
    @JsonProperty("talla")
    @Column(name = "talla")
	private String talla;
	
	@NotNull
    @NotEmpty
    @JsonProperty("peso")
    @Column(name = "peso")
	private String peso;
	
	@NotNull
    @NotEmpty
    @JsonProperty("edad")
    @Column(name = "edad")
	private String edad;
	
    @JsonProperty("imagen")
    @Column(name = "imagen")
	private String imagen;
    
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonProperty("suscripciones")
    @JoinColumn(name = "cliente_id")
    private List<Suscripcion> suscripciones;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonProperty("objetivos")
    @JoinColumn(name = "cliente_id")
    private List<Objetivo> objetivos;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonProperty("observaciones")
    @JoinColumn(name = "cliente_id")
    private List<Observacion> observaciones;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JsonProperty("plan_entrenamiento")
    @JoinColumn(name = "cliente_id")
    private List<DiaEntrenamiento> planEntrenamiento;
	
	public Cliente(long id, String nombre, String contrasena, String talla, String peso, String edad ) {
		this.id=id;
		this.nombre=nombre;
		this.contrasena=contrasena;
		this.talla=talla;
		this.peso=peso;
		this.edad=edad;
	}
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public String getTalla() {
		return talla;
	}
	
	public String getPeso() {
		return peso;
	}
	
	public String getEdad() {
		return edad;
	}
	
	public List<Objetivo> getObjetivos() {
		return objetivos;
	}
	public List<Observacion> getObservaciones() {
		return observaciones;
	}
}
