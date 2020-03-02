package com.vipper.modelo;

import java.io.Serializable;

public class ClienteProveedor implements Serializable {
	//Atributos
	private int id;
	private String NIF;
	private String nombre;
	private String direccion;
	private String tipo;
	private String email;
	private String telefono;
	
	
	@Override
	public String toString() {
		return "ClienteProveedor [id=" + id + ", NIF=" + NIF + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", tipo=" + tipo + ", email=" + email + ", telefono=" + telefono + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	public ClienteProveedor() {
		// TODO Auto-generated constructor stub
	}

	public ClienteProveedor(int id, String NIF, String nombre, String direccion, String tipo, String email,
			String telefono) {
		super();
		this.id = id;
		this.NIF = NIF;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipo = tipo;
		this.email = email;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	
	

}
