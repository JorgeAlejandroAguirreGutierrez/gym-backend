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
@Table(name = "ejercicio")
public class Ejercicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "descripcion")
	private String descripcion;
	
	@NotNull
    @NotEmpty
    @Column(name = "tipo")
	private String tipo;
	
    @Column(name = "imagen")
	private String imagen;
	
	public long getId() {
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
