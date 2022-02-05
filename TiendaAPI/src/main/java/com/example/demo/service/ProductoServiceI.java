package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Producto;

public interface ProductoServiceI {
	
	public Producto save(Producto producto);

	public Producto findById(long id);
	
	public List<Producto> findAll();
}
