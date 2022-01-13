package com.example.demo.service;

import com.example.demo.model.Pedido;

public interface PedidoServiceI {
	
	public Pedido save(Pedido e);

	public Pedido findById(long id);

}
