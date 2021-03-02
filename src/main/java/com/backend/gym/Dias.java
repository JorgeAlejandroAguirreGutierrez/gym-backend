package com.backend.gym;

import java.util.HashMap;
import java.util.Map;

public enum Dias {
	DIA1("1", "LUNES"), 
	DIA2("2", "MARTES"),
	DIA3("3", "MARTES"),
	DIA4("4", "MARTES"),
	DIA5("5", "MARTES"),
	DIA6("6", "MARTES"),
	DIA7("7", "MARTES");
	
    private String numero;
    private String descripcion;

    private Dias(String numero, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
    }

    public String getNumero() {
		return numero;
	}
    
    public String getDescripcion() {
		return descripcion;
	}

    private static final Map<String, Dias> lookup = new HashMap<>();

    static {
        for (Dias env : Dias.values()) {
            lookup.put(env.getNumero(), env);
        }
    }

    public static Dias get(String url) {
        return lookup.get(url);
    }
}
