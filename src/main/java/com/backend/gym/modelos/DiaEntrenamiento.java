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
@Table(name = "dia_entrenamiento")
public class DiaEntrenamiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "numero")
	private long numero;
	
	@ManyToOne
    @JoinColumn(name = "ejercicio_id", nullable = true)
    private Ejercicio ejercicio;
	
	@NotNull
    @NotEmpty
    @Column(name = "repeticion")
	private long repeticion;
	
	@NotNull
    @NotEmpty
    @Column(name = "veces")
	private long veces;
	
	public long getId() {
		return id;
	}
	
	public long getNumero() {
		return numero;
	}
	public Ejercicio getEjercicio() {
		return ejercicio;
	}
	public long getRepeticion() {
		return repeticion;
	}
	public long getVeces() {
		return veces;
	}
}
