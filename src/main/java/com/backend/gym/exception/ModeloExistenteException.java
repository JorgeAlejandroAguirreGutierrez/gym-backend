package com.backend.gym.exception;

import com.backend.gym.Util;

public class ModeloExistenteException extends RuntimeException  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModeloExistenteException() {
        super(Util.error_registro_existente);
    }
}
