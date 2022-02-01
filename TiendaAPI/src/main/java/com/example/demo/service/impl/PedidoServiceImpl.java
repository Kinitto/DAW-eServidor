package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pedido;
import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.model.dto.PedidoProductoDTO;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.service.PedidoProductoServiceI;
import com.example.demo.service.PedidoServiceI;
import com.example.demo.service.ProductoServiceI;

@Primary
@Service("PedidoServiceImpl")
public class PedidoServiceImpl implements PedidoServiceI {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProductoServiceI productoService;
	
	@Autowired
	private PedidoProductoServiceI pedidoProductoService;
	
	@Override
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	@Override
	public Pedido findById(long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	//crea un nuevo pedido.
	@Override
	public Pedido crearPedido(Pedido pedidoDTO) {

	
			pedidoRepository.save(pedidoDTO);
			
			return pedidoDTO;
	}
	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return 	pedidoRepository.findAll();

	}

	@Override
	public double calcularTotal(List<PedidoProductoDTO> productos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTotal(Pedido pedidoActual, double total) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> findOrdersFromUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Pedido pedidoActual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Pedido pedidoModificado, Pedido pedidoActual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEnvio(Pedido pedidoActual, String envio) {
		// TODO Auto-generated method stub
		
	}

	
	
	

	

	

	

}
