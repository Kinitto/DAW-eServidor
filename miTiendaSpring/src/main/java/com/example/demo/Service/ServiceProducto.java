package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ModelProducto;
@Service
public class ServiceProducto {
	private List<ModelProducto> listaProductos = new ArrayList<>();

	public List<ModelProducto> findAll() {
		return listaProductos;
	}
	
	public ModelProducto add(ModelProducto producto) {
			listaProductos.add(producto);
		
		return producto;
	}
	
}
