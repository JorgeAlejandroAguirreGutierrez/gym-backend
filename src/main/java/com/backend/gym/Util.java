package com.backend.gym;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Util {
	
	public static String generarCodigo(String codigo, long conteo){
        String rellenoConteo = String.format("%06d" , conteo);
        return codigo+"-" + rellenoConteo;
    }
	
	public static String generarContrasena(String identificacion){
        String codigo = Constantes.GIMNASIO+identificacion;
        return codigo;
    }
	
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
