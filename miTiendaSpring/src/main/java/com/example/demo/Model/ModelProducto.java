package com.example.demo.Model;

import java.util.Objects;

import javax.validation.constraints.Min;

public class ModelProducto {

	private int idPedido;
	private String nombre;
	@Min(1)
	private int cantidad;
	private int precio;

	public ModelProducto() {

	}

	public ModelProducto(int idPedido, String nombre, int cantidad, int precio) {
		super();
		this.idPedido = idPedido;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;

	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, idPedido, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelProducto other = (ModelProducto) obj;
		return cantidad == other.cantidad && idPedido == other.idPedido && Objects.equals(nombre, other.nombre)
				&& precio == other.precio;
	}

	@Override
	public String toString() {
		return "ModelProducto [idPedido=" + idPedido + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio="
				+ precio + "]";
	}

}
