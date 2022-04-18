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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sesion")
public class Sesion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "estado")
    private boolean estado;
    
    @NotNull
    @Column(name = "fecha_apertura")
    private Date fechaApertura;
    
    @Column(name = "fecha_cierre")
    private Date fechaCierre;
    
    @Transient
    private String endpoint;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    private Usuario usuario;
	
    public long getId() {
		return id;
	}
	
    public boolean isEstado() {
		return estado;
	}
    
    public Date getFechaApertura() {
		return fechaApertura;
	}
    
    public Date getFechaCierre() {
		return fechaCierre;
	}
    public Usuario getUsuario() {
		return usuario;
	}
    
    public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    public String getEndpoint() {
		return endpoint;
	}
    
    public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
}
