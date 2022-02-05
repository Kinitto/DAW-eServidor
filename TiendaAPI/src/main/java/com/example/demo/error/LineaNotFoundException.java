package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class LineaNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6734027569391630482L;
	
	public LineaNotFoundException(Long id) {
		super("No se puede encontrar la linea de pedido con el ID: " + id);
	}
}
