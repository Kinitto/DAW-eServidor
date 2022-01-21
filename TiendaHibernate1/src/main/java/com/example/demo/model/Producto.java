package com.example.demo.model;

import java.io.Serializable;
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
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Integer precio;

	private CategoriaProducto categoria;

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	private List<PedidoProducto> pedidoProducto;

	public Producto() {
	}

	public Producto(Long id, String nombre, Integer precio, CategoriaProducto categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public CategoriaProducto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}

	public List<PedidoProducto> getPedidoProducto() {
		return pedidoProducto;
	}

	public void setPedidoProducto(List<PedidoProducto> pedidoProducto) {
		this.pedidoProducto = pedidoProducto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
