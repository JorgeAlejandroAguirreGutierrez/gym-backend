package com.backend.gym.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
public class Plan {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@OrderBy("numero ASC")
	@OneToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = true)
    private List<Dia> dias;
	
	
	public long getId() {
		return id;
	}
	
	public List<Dia> getDias() {
		return dias;
	}
}
