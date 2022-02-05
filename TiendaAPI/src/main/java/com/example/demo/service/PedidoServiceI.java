package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;

public interface PedidoServiceI {
	
	public Pedido save(Pedido pedido);

	public Pedido findById(long id);

	public Pedido crearPedido(Pedido pedido);

	public List<Pedido> findAll();

	public Pedido editPedido(Long id, Pedido pedidoDTO);

	public Pedido delete(Long id);

	public PedidoProducto crearLinea(PedidoProducto lineaPedidoDTO, Long id);

	public void setTotalPrecio(PedidoProducto lineaPedidoDTO);
	
	public void restarPrecio(PedidoProducto lineaPedidoDTO);

	public List<PedidoProducto> getListaLineas(Long id);


}
