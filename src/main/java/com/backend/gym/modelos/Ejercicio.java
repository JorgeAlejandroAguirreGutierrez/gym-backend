package com.backend.gym.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ejercicio")
public class Ejercicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    @Column(name = "nombre")
	private String nombre;
	
    @Column(name = "nombre_personalizado")
	private String nombrePersonalizado;
	
	@Column(name = "detalle")
	private String detalle;
	
	@Column(name = "imagen")
	private String imagen;
	
	@ManyToOne
    @JoinColumn(name = "tipo_musculo_id", nullable = true)
    private TipoMusculo tipoMusculo;
	
    
    public Ejercicio() {
    	
    }
    
    public Ejercicio(String nombre, String nombrePersonalizado, String imagen, TipoMusculo tipoMusculo) {
    	this.nombre=nombre;
    	this.nombrePersonalizado=nombrePersonalizado;
    	this.detalle=null;
    	this.imagen=imagen;
    	this.tipoMusculo=tipoMusculo;
    }
    
    public Ejercicio(String nombre, String nombrePersonalizado, String detalle, String imagen, TipoMusculo tipoMusculo) {
    	this.nombre=nombre;
    	this.nombrePersonalizado=nombrePersonalizado;
    	this.detalle=detalle;
    	this.imagen=imagen;
    	this.tipoMusculo=tipoMusculo;
    }
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNombrePersonalizado() {
		return nombrePersonalizado;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public TipoMusculo getTipoMusculo() {
		return tipoMusculo;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
