package com.example.demo.service;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;

public interface PedidoProductoServiceI {
	
	public PedidoProducto save(PedidoProducto pedidoProducto);

	public PedidoProducto findById(long id);

	public void borrarLineas(Pedido pedido, Long idLinea);

}