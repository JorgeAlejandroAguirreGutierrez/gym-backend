package com.backend.gym.exception;

import com.backend.gym.Constantes;

public class SuscripcionInvalidaException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuscripcionInvalidaException() {
        super(Constantes.error_codigo_suscripcion_invalida);
    }
}
