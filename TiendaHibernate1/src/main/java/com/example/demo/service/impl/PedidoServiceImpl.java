package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoServiceI;

@Primary
@Service("PedidoServiceImpl")
public class PedidoServiceImpl implements PedidoServiceI {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido save(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido findById(long id) {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id).orElse(null);
	}

}
