package com.example.demo.service;

import com.example.demo.model.PedidoProducto;

public interface PedidoProductoServiceI {
	
	public PedidoProducto save(PedidoProducto pedidoProducto);

	public PedidoProducto findById(long id);

}