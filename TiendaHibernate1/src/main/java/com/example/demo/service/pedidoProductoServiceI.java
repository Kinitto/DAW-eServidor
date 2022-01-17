package com.example.demo.service;

import com.example.demo.model.pedidoProducto;

public interface pedidoProductoServiceI {
	
	public pedidoProducto save(pedidoProducto pedidoProducto);

	public pedidoProducto findById(long id);

}