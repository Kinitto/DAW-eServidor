package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_pedidoProducto")
public class PedidoProducto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido_producto")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_pedido", foreignKey = @ForeignKey(name = "FK_PEDIDO_PRODUCTO__ID_PEDIDO"))
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "id_producto", foreignKey = @ForeignKey(name = "FK_PEDIDO_PRODUCTO__ID_PRODUCTO"))
	private Producto producto;

	private Integer cantidad;

	public PedidoProducto() {
	}

	public PedidoProducto(Long id, Pedido pedido, Producto producto, Integer cantidad) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
