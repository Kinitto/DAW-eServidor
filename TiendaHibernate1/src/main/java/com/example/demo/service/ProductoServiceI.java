package com.example.demo.service;

import com.example.demo.model.Producto;

public interface ProductoServiceI {
	
	public Producto save(Producto producto);

	public Producto findById(long id);
	
}
