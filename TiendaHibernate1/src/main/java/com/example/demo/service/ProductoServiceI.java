package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.model.dto.PedidoProductoDTO;

public interface ProductoServiceI {
	
	public Producto save(Producto producto);

	public Producto findById(long id);
	
	public List<PedidoProductoDTO> findProductFromOrder(long id);

	public List<Producto> findProducts(long id);
}
