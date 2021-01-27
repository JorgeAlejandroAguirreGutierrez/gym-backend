package com.backend.gym;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Util {
	public static String generarCodigo(String codigo, long conteo){
        String rellenoConteo = String.format("%06d" , conteo);
        return codigo+"-" + rellenoConteo;
    }
    
    public static String vacio="";
    public static String error_registro_existente="REGISTRO EXISTENTE";
    public static String error_registro_no_existente="REGISTRO NO EXISTENTE";
}
