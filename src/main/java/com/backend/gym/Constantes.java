package com.backend.gym;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Constantes {
	public static final String USUARIOCONTROLLER = "/gym/usuario";
	public static final String EJERCICIOCONTROLLER = "/gym/ejercicio";
	public static final String PERFILCONTROLLER = "/gym/perfil";
	public static final String SESIONCONTROLLER = "/gym/sesion";
	public static final String PARAMETROCONTROLLER = "/gym/parametro";
	public static final String TIPOMUSCULOCONTROLLER = "/gym/tipomusculo";
	
	public static final String LOGMETHOD = "Ingresa al método: ";
	public static final String LOGCLASS = " de la clase: ";
	
	public static final String PERFILADMIN = "ADMIN";
	public static final String PERFILCLIENTE = "CLIENTE";
	
	public static final String GIMNASIOOLIMPIA = "GIMNASIOOLIMPIA";
	
	public static final String FORMATOFECHA = "yyyy-MM-dd";
	
	public static String vacio="";
    public static String error_codigo_modelo_existente="4001";
    public static String error_codigo_modelo_no_existente="4002";
    public static String error_codigo_suscripcion_invalida="4003";
    public static String error_codigo_sesion_invalida="4004";
	
	
	
}
