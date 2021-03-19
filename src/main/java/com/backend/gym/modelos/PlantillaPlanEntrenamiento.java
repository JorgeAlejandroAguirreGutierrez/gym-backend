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
@Table(name = "plantilla_plan_entrenamiento")
public class PlantillaPlanEntrenamiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
	@NotEmpty
    @Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@NotEmpty
    @Column(name = "somatotipo")
	private String somatotipo;
	
	@ManyToOne
    @JoinColumn(name = "plan_entrenamiento_id")
    private PlanEntrenamiento planEntrenamiento;
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getSomatotipo() {
		return somatotipo;
	}
	
	public PlanEntrenamiento getPlanEntrenamiento() {
		return planEntrenamiento;
	}
}
