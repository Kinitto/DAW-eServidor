package com.example.demo.service.impl;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.service.ProductoServiceI;

@Primary
@Service("ProductoServiceImpl")
public class ProductoServiceImpl implements ProductoServiceI {

	@Autowired
	private ProductoRepository productoRepository;
	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostConstruct
	public void init() {
		productoRepository.saveAll(Arrays.asList(
				new Producto("Camiseta",15),
				new Producto("Pantalon",25),
				new Producto("Camiseta",65)));
	}

}
