package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.PedidoProducto;
import com.example.demo.repository.PedidoProductoRepository;
import com.example.demo.service.PedidoProductoServiceI;

@Primary
@Service("pedidoProductoServiceImpl")
public class PedidoProductoServiceImpl implements PedidoProductoServiceI {

	@Autowired
	private PedidoProductoRepository PedidoProductoRepository;

	@Override
	public PedidoProducto save(PedidoProducto PedidoProducto) {
		// TODO Auto-generated method stub
		return PedidoProductoRepository.save(PedidoProducto);
	}

	@Override
	public PedidoProducto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
