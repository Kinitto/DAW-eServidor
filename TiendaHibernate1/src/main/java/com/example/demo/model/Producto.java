package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_producto")  
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<pedidoProducto> pedido = new ArrayList<>();
	
	private String nombre;
		
	private int precio;

	


	public Producto(String nombre, int precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto(Long idProducto, List<pedidoProducto> pedido, String nombre, int precio) {
		super();
		this.idProducto = idProducto;
		this.pedido = pedido;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	
	
	public List<pedidoProducto> getPedidos() {
		return pedido;
	}

	public void setPedidos(List<pedidoProducto> pedido) {
		this.pedido = pedido;
	}
	
	
	@Column(nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	@Column(nullable = false)
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}


	
	

}
