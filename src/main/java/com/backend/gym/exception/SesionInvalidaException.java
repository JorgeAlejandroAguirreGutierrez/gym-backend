package com.backend.gym.exception;

import com.backend.gym.Constantes;
import com.backend.gym.Util;

public class SesionInvalidaException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SesionInvalidaException() {
        super(Constantes.error_codigo_sesion_invalida);
    }
}
