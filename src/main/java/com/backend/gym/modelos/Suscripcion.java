package com.backend.gym.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "suscripcion")
public class Suscripcion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @Column(name = "fecha")
	private Date fecha;
	
	@ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    private Usuario usuario;
	
	public long getId() {
		return id;
	}
	
	public Date getFecha() {
		return fecha;
	}
}
