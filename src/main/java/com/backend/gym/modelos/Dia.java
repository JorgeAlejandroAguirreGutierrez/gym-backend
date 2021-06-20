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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dia")
public class Dia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @Column(name = "numero")
	private long numero;
	
    @Column(name = "nombre")
	private String nombre;
	
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
	@OrderBy("id ASC")
	@JoinColumn(name = "dia_id", nullable = true)
    private List<Rutina> rutinas;
	
	public long getNumero() {
		return numero;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Rutina> getRutinas() {
		return rutinas;
	}
	
}
