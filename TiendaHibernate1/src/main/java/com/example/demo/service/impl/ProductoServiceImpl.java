package com.example.demo.service.impl;


import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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

}
