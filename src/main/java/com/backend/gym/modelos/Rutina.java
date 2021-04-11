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
@Table(name = "rutina")
public class Rutina {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    @Column(name = "repeticiones")
	private long repeticiones;
	
    @Column(name = "veces")
	private long veces;
	
    @Column(name = "valor_tiempo")
	private long valorTiempo;
	
    @Column(name = "medida_tiempo")
	private String medidaTiempo;
	
    @Column(name = "valor_peso")
	private double valorPeso;
	
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
	
	public long getValorTiempo() {
		return valorTiempo;
	}
	
	public String getMedidaTiempo() {
		return medidaTiempo;
	}
}
