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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * clase pedidoProducto / lineaPedido
 * @author joaquin
 *
 */
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
	private Long idLinea;

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
		this.idLinea = idLinea;
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return idLinea;
	}

	public void setId(Long idLinea) {
		this.idLinea = idLinea;
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
