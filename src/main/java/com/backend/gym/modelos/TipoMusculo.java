package com.backend.gym.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tipo_musculo")
public class TipoMusculo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @Column(name = "descripcion")
	private String descripcion;
	
	public TipoMusculo() {
		
	}
	
	public TipoMusculo(long id) {
		this.id=id;
	}
	
	public TipoMusculo(String descripcion) {
		this.descripcion=descripcion;
	}
	
	public long getId() {
		return id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
