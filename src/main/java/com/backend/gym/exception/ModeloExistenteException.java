package com.backend.gym.exception;

import com.backend.gym.Constantes;

public class ModeloExistenteException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModeloExistenteException() {
        super(Constantes.error_codigo_modelo_existente);
    }
}
