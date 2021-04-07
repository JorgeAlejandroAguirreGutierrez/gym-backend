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
@Table(name = "rutina_entrenamiento")
public class RutinaEntrenamiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @Column(name = "repeticiones")
	private long repeticiones;
	
	@NotNull
    @Column(name = "veces")
	private long veces;
	
    @Column(name = "valor_tiempo")
	private long valorTiempo;
	
    @Column(name = "medida_tiempo")
	private long medidaTiempo;
	
    @NotEmpty
    @Column(name = "valor_peso")
	private double valorPeso;
	
    @NotEmpty
    @Column(name = "medida_peso")
	private String medidaPeso;
	
	@ManyToOne
    @JoinColumn(name = "ejercicio_id", nullable = true)
    private Ejercicio ejercicio;
	
	public long getId() {
		return id;
	}
	public Ejercicio getEjercicio() {
		return ejercicio;
	}
	public long getRepeticiones() {
		return repeticiones;
	}
	public long getVeces() {
		return veces;
	}
	public double getValorPeso() {
		return valorPeso;
	}
	public String getMedidaPeso() {
		return medidaPeso;
	}
}
