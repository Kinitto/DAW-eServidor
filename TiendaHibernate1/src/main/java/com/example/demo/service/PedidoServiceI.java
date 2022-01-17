package com.example.demo.service;

import com.example.demo.model.Pedido;

public interface PedidoServiceI {
	
	public Pedido save(Pedido pedido);

	public Pedido findById(long id);

}
