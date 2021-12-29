package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ModelPedido;
import com.example.demo.Model.ModelProducto;
import com.example.demo.Model.ModelUsuario;
@Service
public class ServiceProducto {
	private List<ModelProducto> listaProductos = new ArrayList<>();

	public List<ModelProducto> findAll() {
		return listaProductos;
	}
	
	public List<ModelProducto> clear() {
		listaProductos.clear();
		return listaProductos;
	}
	
	public List<ModelProducto> findProducto(int id) {

		List<ModelProducto> producto = listaProductos.stream()
			    .filter(i -> i.getIdPedido() == id).collect(Collectors.toList());
		return producto;		
		
	}
	

	/**
	 * obtenemos cantidad de lista de productos
	 * @return
	 */
	public int cantidad() {
		return listaProductos.size();
	}
	/**
	 * añadimos producto a la lista de productos.
	 * @param producto
	 * @return
	 */
	
	public ModelProducto add(ModelProducto producto) {
			listaProductos.add(producto);
		
		return producto;
	}
	
}
