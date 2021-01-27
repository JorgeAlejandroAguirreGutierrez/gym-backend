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

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "dia_entrenamiento")
public class DiaEntrenamiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @JsonProperty("numero")
    @Column(name = "numero")
	private long numero;
	
	@ManyToOne
    @JsonProperty("ejercicio")
    @JoinColumn(name = "ejercicio_id", nullable = true)
    private Ejercicio ejercicio;
	
	@NotNull
    @NotEmpty
    @JsonProperty("repeticion")
    @Column(name = "repeticion")
	private long repeticion;
	
	@NotNull
    @NotEmpty
    @JsonProperty("veces")
    @Column(name = "veces")
	private long veces;
}
