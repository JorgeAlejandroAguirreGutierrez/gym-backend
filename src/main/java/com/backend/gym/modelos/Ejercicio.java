package com.backend.gym.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ejercicio")
public class Ejercicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "imagen")
	private String imagen;
	
	@ManyToOne
    @JoinColumn(name = "tipo_musculo_id", nullable = true)
    private TipoMusculo tipoMusculo;
	
    
    public Ejercicio() {
    	
    }
    
    public Ejercicio(String descripcion, String imagen, TipoMusculo tipoMusculo) {
    	this.descripcion=descripcion;
    	this.imagen=imagen;
    	this.tipoMusculo=tipoMusculo;
    }
	
	public long getId() {
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
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
