package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_pedido")
public class Pedido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	 
	@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<pedidoProducto> productos = new ArrayList<>();
	
	private String email;
	
	private String telefono;
	
	private String direccion;
	
	private String fecha;

	
	public Pedido() {

	}

	

	public Pedido(Long idPedido, List<pedidoProducto> productos, String email, String telefono, String direccion,
			String fecha) {
		super();
		this.idPedido = idPedido;
		this.productos = productos;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fecha = fecha;
	}


	
	public Long getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}


	public List<pedidoProducto> getProductos() {
		return productos;
	}



	public void setProductos(List<pedidoProducto> productos) {
		this.productos = productos;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
	

}
