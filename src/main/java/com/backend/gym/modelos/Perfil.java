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
@Table(name = "perfil")
public class Perfil {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotEmpty
    @Column(name = "descripcion")
    private String descripcion;
	
	public Perfil() {
		
	}
	
	public Perfil(long id) {
		this.id=id;
	}
	
	public Perfil(String descripcion) {
		this.descripcion=descripcion;
	}
	
	
    public long getId() {
		return id;
	}
	
    public String getDescripcion() {
		return descripcion;
	}
}
