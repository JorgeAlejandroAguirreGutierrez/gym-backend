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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @Column(name = "identificacion")
    private String identificacion;
	
    @Column(name = "contrasena")
	private String contrasena;
	
	@NotNull
    @NotEmpty
    @Column(name = "talla")
	private String talla;
	
	@NotNull
    @NotEmpty
    @Column(name = "edad")
	private String edad;
	
    @Column(name = "imagen")
	private String imagen;
    
    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = true)
    private Perfil perfil;
    
    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Sesion> sesiones;
    
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private List<Peso> pesos;
    
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private List<Suscripcion> suscripciones;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private List<Objetivo> objetivos;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private List<Observacion> observaciones;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private List<PlanEntrenamiento> planesEntrenamiento;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String identificacion, String contrasena, 
			String talla, String peso, String edad, String imagen, 
			Perfil perfil, List<Sesion> sesiones, List<Peso> pesos, List<Observacion> observaciones,
			List<Objetivo> objetivos, List<Suscripcion>suscripciones ) {
		this.nombre=nombre;
		this.identificacion=identificacion;
		this.contrasena=contrasena;
		this.talla=talla;
		this.edad=edad;
		this.imagen=imagen;
		this.perfil=perfil;
		this.sesiones=sesiones;
		this.pesos=pesos;
		this.observaciones=observaciones;
		this.objetivos=objetivos;
		this.suscripciones=suscripciones;
	}
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public String getTalla() {
		return talla;
	}
	
	public String getEdad() {
		return edad;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	
	public List<Peso> getPesos() {
		return pesos;
	}
	
	public List<Objetivo> getObjetivos() {
		return objetivos;
	}
	public List<Observacion> getObservaciones() {
		return observaciones;
	}
	
	public List<PlanEntrenamiento> getPlanesEntrenamiento() {
		return planesEntrenamiento;
	}
	
	public List<Suscripcion> getSuscripciones() {
		return suscripciones;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
