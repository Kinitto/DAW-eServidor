package com.example.demo.service.impl;


import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.PedidoProducto;
import com.example.demo.model.Producto;

import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoServiceI;
/**
 * servicio de Producto
 * @author joaquin
 *
 */
@Primary
@Service("ProductoServiceImpl")
public class ProductoServiceImpl implements ProductoServiceI {

	@Autowired
	private ProductoRepository productoRepository;
	
	/**
	 * guarda un producto
	 */
	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}
	/**
	 * busca un producto por id
	 */

	@Override
	public Producto findById(long id) {
		return productoRepository.findById(id).orElse(null);
	}

	/**
	 * busca todos los productos
	 */
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	/**
	 * crea productos al iniciar la aplicación
	 */
	@PostConstruct
	public void init() {
		productoRepository.saveAll(Arrays.asList(
				new Producto(null, "Camiseta de Gatos",15),
				new Producto(null,"Pantalon Vaquero",25),
				new Producto(null, "Bomber Deportiva",65)));
	}
	

}
