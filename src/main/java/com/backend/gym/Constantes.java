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
	
	public static final String LOGMETHOD = "Ingresa al método: ";
	public static final String LOGCLASS = " de la clase: ";
	
	public static final String PERFILADMIN = "ADMIN";
	public static final String PERFILCLIENTE = "CLIENTE";
	
	public static String guardarArchivo(MultipartFile archivo, long consecutivo ) throws Exception 
    {
		try {
			String ruta=consecutivo+archivo.getOriginalFilename();
	        File archivoConvertir = new File("src/main/storage", ruta );
	        FileOutputStream archivoSalida = new FileOutputStream( archivoConvertir );
	        archivoSalida.write( archivo.getBytes() );
	        archivoSalida.close();
	        return ruta;
		}catch(IOException e) {
			throw new Exception();
		}
    }
}
