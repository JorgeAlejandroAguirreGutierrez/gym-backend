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
    @Column(name = "estatura")
	private double estatura;
	
	@NotNull
    @Column(name = "edad")
	private long edad;
    
    @Column(name="activo")
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = true)
    private Perfil perfil;
    
    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "plan_id", nullable = true)
    private Plan plan;
    
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private List<Peso> pesos;
    
    @OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private List<Suscripcion> suscripciones;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private List<Objetivo> objetivos;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private List<Observacion> observaciones;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String identificacion, String contrasena, 
			long estatura, long edad, boolean activo,
			Perfil perfil, List<Peso> pesos, List<Observacion> observaciones,
			List<Objetivo> objetivos, List<Suscripcion>suscripciones ) {
		this.nombre=nombre;
		this.identificacion=identificacion;
		this.contrasena=contrasena;
		this.estatura=estatura;
		this.edad=edad;
		this.activo=activo;
		this.perfil=perfil;
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
	
	public double getEstatura() {
		return estatura;
	}
	
	public long getEdad() {
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
	
	public Plan getPlan() {
		return plan;
	}
	
	public List<Suscripcion> getSuscripciones() {
		return suscripciones;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void setEdad(long edad) {
		this.edad = edad;
	}
	
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
