package com.example.demo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.service.PedidoServiceI;

@Primary
@Service("PedidoServiceImpl")
public class PedidoServiceImpl implements PedidoServiceI {

	@Override
	public Pedido save(Pedido e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
