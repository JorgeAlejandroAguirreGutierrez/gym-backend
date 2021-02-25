package com.backend.gym.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "peso")
public class Peso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @NotEmpty
    @Column(name = "fecha")
	private Date fecha;
	
	@NotNull
    @NotEmpty
    @Column(name = "valor")
	private double valor;
	
	public long getId() {
		return id;
	}
	
	public Date getFecha() {
		return fecha;
	}
}
