package com.vipper.modelo;

import java.io.Serializable;

public class ServicioProducto implements Serializable{
	//Atributos
	private int id_servicio;
	private String descrip;
	private double coste;
	private int id;
	private double iva;
	
	
	//Métodos
	@Override
	public String toString() {
		return "ServiciosProductos [id_servicio=" + id_servicio + ", descrip=" + descrip + ", coste=" + coste + ", id="
				+ id + ", iva=" + iva + "]";
	}
	
	
	//Constructores
	public ServicioProducto() {}

	public ServicioProducto(int id_servicio, String descrip, double coste, int id, double iva) {
		super();
		this.id_servicio = id_servicio;
		this.descrip = descrip;
		this.coste = coste;
		this.id = id;
		this.iva = iva;
	}

	
	//Getters Setters
	public int getId_servicio() {
		return id_servicio;
	}


	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}


	public String getDescrip() {
		return descrip;
	}


	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}


	public double getCoste() {
		return coste;
	}


	public void setCoste(double coste) {
		this.coste = coste;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getIva() {
		return iva;
	}


	public void setIva(double iva) {
		this.iva = iva;
	}
}
