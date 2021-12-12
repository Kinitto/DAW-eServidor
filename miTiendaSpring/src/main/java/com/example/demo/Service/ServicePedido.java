package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ModelPedido;


@Service
public class ServicePedido {

	private List<ModelPedido> listaPedido = new ArrayList<>();

	public List<ModelPedido> findAll() {
		return listaPedido;
	}
	
	public ModelPedido add(ModelPedido pedido) {
			listaPedido.add(pedido);
		
		return pedido;
	}
	
}
