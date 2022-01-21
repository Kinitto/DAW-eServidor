package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Pedido;
import com.example.demo.model.Usuario;
import com.example.demo.model.dto.PedidoProductoDTO;

public interface PedidoServiceI {
	
	public Pedido save(Pedido pedido);

	public Pedido findById(long id);

	public Pedido crearPedido(Usuario usuario, List<Integer> cantidades);
	
	public double calcularTotal(List<PedidoProductoDTO> productos);

	public void setTotal(Pedido pedidoActual, double total);

	public List<Pedido> findProductsFromUser(Long id);
	
	public void delete(Pedido pedidoActual);

	public void edit(Pedido pedido);


}
