package com.example.demo.Model;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class ModelUsuario {

	@Min(1)
	private long id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String password;
	@Email
	private String email;
	private String telefono;
	private String direccion;

	public ModelUsuario() {
	}

	public ModelUsuario(long id, String nombre, String password, String email, String telefono, String direccion) {

		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;

	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return Objects.hash(nombre, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelUsuario other = (ModelUsuario) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "ModelUsuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", email=" + email
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
}
