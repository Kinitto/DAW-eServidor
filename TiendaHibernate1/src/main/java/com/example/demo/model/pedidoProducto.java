package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Id
	@ManyToOne
	@JoinColumn(
				name="pedido_id",
				insertable = false, updatable = false
	)
	private Pedido pedido;
	
	@Id
	@ManyToOne
	@JoinColumn(
				name="producto_id",
				insertable = false, updatable = false
	)
    private Producto producto;
    
    private int cantidad;

	public pedidoProducto() {
	}

	public pedidoProducto(Pedido pedido, Producto producto, int cantidad) {
		super();
		this.pedido = pedido;
		this.producto = producto;
		this.cantidad = cantidad;
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

	@Override
	public int hashCode() {
		return Objects.hash(pedido, producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pedidoProducto that = (pedidoProducto) obj;
		return Objects.equals(pedido, that.pedido) && Objects.equals(producto, that.producto);
	}
	
	
    
    
}
