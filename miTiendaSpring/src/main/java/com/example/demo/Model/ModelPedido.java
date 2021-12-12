package com.example.demo.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ModelPedido {
	
	
	private List<ModelProducto> producto;
	private String email;
	private String telefono;
	private String direccion;
	
	public ModelPedido() {
		
	}
	
	public ModelPedido(List<ModelProducto> product, String email, String telefono, String direccion) {
		super();
		this.producto = product;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}


	public List<ModelProducto> getProducto() {
		return producto;
	}

	public void setProducto(List<ModelProducto> producto) {
		this.producto = producto;
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

	@Override
	public int hashCode() {
		return Objects.hash(direccion, email, producto, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelPedido other = (ModelPedido) obj;
		return Objects.equals(direccion, other.direccion) && Objects.equals(email, other.email)
				&& Objects.equals(producto, other.producto) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "ModelPedido [producto=" + producto + ", email=" + email + ", telefono=" + telefono + ", direccion="
				+ direccion + "]";
	}

		
	}

	
