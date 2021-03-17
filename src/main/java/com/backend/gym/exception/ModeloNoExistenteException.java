package com.backend.gym.exception;

import com.backend.gym.Constantes;

public class ModeloNoExistenteException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModeloNoExistenteException() {
        super(Constantes.error_codigo_modelo_no_existente);
    }
}
