package com.backend.gym.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "plan_entrenamiento")
public class PlanEntrenamiento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @Column(name = "numero")
	private long numero;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private List<RutinaEntrenamiento> rutinasEntrenamiento;
	
	public long getId() {
		return id;
	}
	
	public long getNumero() {
		return numero;
	}
	
	public List<RutinaEntrenamiento> getRutinasEntrenamiento() {
		return rutinasEntrenamiento;
	}
}
