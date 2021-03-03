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
@Table(name = "suscripcion")
public class Suscripcion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "fecha")
	private String fecha;
	
	@Column(name = "valor")
	private double valor;
	
	public long getId() {
		return id;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public double getValor() {
		return valor;
	}
}
