package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Usuario;
import com.example.demo.model.dto.PedidoProductoDTO;

public interface PedidoServiceI {
	
	public Pedido save(Pedido pedido);

	public Pedido findById(long id);

	public Pedido crearPedido(Pedido pedido);
	
	public double calcularTotal(List<PedidoProductoDTO> productos);

	public void setTotal(Pedido pedidoActual, double total);

	public List<Pedido> findOrdersFromUser(Long id);

	public void edit(Pedido pedidoModificado, Pedido pedidoActual);

	public void addEnvio(Pedido pedidoActual, String envio);

	public List<Pedido> findAll();

	public Pedido editPedido(Long id, Pedido pedidoDTO);

	public Pedido delete(Long id);

	public PedidoProducto crearLinea(PedidoProducto lineaPedidoDTO, Long id);

	public void setTotalPrecio(PedidoProducto lineaPedidoDTO);

	public List<PedidoProducto> getListaLineas(Long id);


}
