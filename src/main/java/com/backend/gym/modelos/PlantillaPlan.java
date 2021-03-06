package com.backend.gym.modelos;

import javax.persistence.CascadeType;
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
@Table(name = "plantilla_plan")
public class PlantillaPlan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
	@NotEmpty
    @Column(name = "nombre", unique=true)
	private String nombre;
	
	@NotNull
	@NotEmpty
    @Column(name = "somatotipo")
	private String somatotipo;
	
	@ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "plan_id")
    private Plan plan;
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getSomatotipo() {
		return somatotipo;
	}
	
	public Plan getPlan() {
		return plan;
	}
}
