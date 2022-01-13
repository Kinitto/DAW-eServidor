package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class pedidoProductoID implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long pedido;
 
    private Long producto;

	public pedidoProductoID() {
		
	}

	public Long getPedido() {
		return pedido;
	}

	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long producto) {
		this.producto = producto;
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
		pedidoProductoID other = (pedidoProductoID) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(producto, other.producto);
	}


    
}

