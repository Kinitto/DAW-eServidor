package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.pedidoProducto;
import com.example.demo.repository.pedidoProductoRepository;
import com.example.demo.service.pedidoProductoServiceI;

@Primary
@Service("pedidoProductoServiceImpl")
public class pedidoProductoServiceImpl implements pedidoProductoServiceI {

	@Autowired
	private pedidoProductoRepository pedidoProductoRepo;
	
	@Override
	public pedidoProducto save(pedidoProducto pedidoProducto) {
		// TODO Auto-generated method stub
		return pedidoProductoRepo.save(pedidoProducto);
	}

	@Override
	public pedidoProducto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
