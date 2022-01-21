package com.example.demo.service.impl;


import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;
import com.example.demo.model.dto.PedidoProductoDTO;
import com.example.demo.model.mapper.ProductoMapper;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoServiceI;

@Primary
@Service("ProductoServiceImpl")
public class ProductoServiceImpl implements ProductoServiceI {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ProductoMapper productoMapper;
	
	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto findById(long id) {
		return productoRepository.findById(id).orElse(null);
	}
	
	//Encuentra los productos de un pedido especifico y lo mapea a una lista de pedidoProductoDTO
	@Override
	public List<PedidoProductoDTO> findProductFromOrder(long id) {
		return productoMapper.pedProdDTOIListToPedProdTOList(
				productoRepository.findProductFromOrder(id));
	}

	@PostConstruct
	public void init() {
		productoRepository.saveAll(Arrays.asList(
				new Producto(null, "Camiseta de Gatos",15),
				new Producto(null,"Pantalon Vaquero",25),
				new Producto(null, "Bomber Deportiva",65)));
	}
	//encuentra un producto por su id
	@Override
	public List<Producto> findProducts(long id) {
		// TODO Auto-generated method stub
		return productoRepository.findProducts(id);
	}

}
