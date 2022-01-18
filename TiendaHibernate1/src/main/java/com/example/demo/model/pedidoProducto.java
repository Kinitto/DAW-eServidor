package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_pedidoProducto")
public class pedidoProducto implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoProducto;
	
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
    private Producto producto;
    
    private int cantidad;

	public pedidoProducto() {
	}

	public pedidoProducto(Pedido pedido, Producto producto, int cantidad) {

		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	
	
	public Long getIdPedidoProducto() {
		return idPedidoProducto;
	}

	public void setIdPedidoProducto(Long idPedidoProducto) {
		this.idPedidoProducto = idPedidoProducto;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
    
}
