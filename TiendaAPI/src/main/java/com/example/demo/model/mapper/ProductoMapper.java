package com.example.demo.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.dto.PedidoProductoDTO;
import com.example.demo.model.dto.interfaces.PedidoProductoDTOI;

@Component
public class ProductoMapper {

	public PedidoProductoDTO pedProdDTOIToPedProdDTO(PedidoProductoDTOI pedidoI) {
		PedidoProductoDTO pedido = new PedidoProductoDTO();
		
		pedido.setCantidad(pedidoI.getCantidad());
		pedido.setNombre(pedidoI.getNombre());
		pedido.setPrecio(pedidoI.getPrecio());
		
		return pedido;
	}
	
	public List<PedidoProductoDTO> pedProdDTOIListToPedProdTOList(List<PedidoProductoDTOI> pedidoI) {
		List<PedidoProductoDTO> pedidos = new ArrayList<>();
		
		for (PedidoProductoDTOI pedidoProductoDTOI : pedidoI) {
			pedidos.add(pedProdDTOIToPedProdDTO(pedidoProductoDTOI));
		}
		
		return pedidos;
	}
}
