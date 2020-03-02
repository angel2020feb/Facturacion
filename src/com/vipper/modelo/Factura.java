package com.vipper.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Factura implements Serializable{
	//Atributos
	private int id_factura;
	private int id;
	private int id_pedido;
	private LocalDate fecha;
	private int id_servicio;
	private double importe;
	private int id_forma_pago;
	private int id_contrato;
	private String concepto;
	private double iva;
	
	
	//Métodos
	@Override
	public String toString() {
		return "Facturas [id_factura=" + id_factura + ", id=" + id + ", id_pedido=" + id_pedido + ", fecha=" + fecha
				+ ", id_servicio=" + id_servicio + ", importe=" + importe + ", id_forma_pago=" + id_forma_pago
				+ ", id_contrato=" + id_contrato + ", concepto=" + concepto + ", iva=" + iva + "]";
	}
	
	
	//Constructores
	public Factura() {}
	
	public Factura(int id_factura, int id, int id_pedido, LocalDate fecha, int id_servicio, double importe,
			int id_forma_pago, int id_contrato, String concepto, double iva) {
		super();
		this.id_factura = id_factura;
		this.id = id;
		this.id_pedido = id_pedido;
		this.fecha = fecha;
		this.id_servicio = id_servicio;
		this.importe = importe;
		this.id_forma_pago = id_forma_pago;
		this.id_contrato = id_contrato;
		this.concepto = concepto;
		this.iva = iva;
	}


	//Getters y Setters
	public int getId_factura() {
		return id_factura;
	}


	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getId_servicio() {
		return id_servicio;
	}


	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public int getId_forma_pago() {
		return id_forma_pago;
	}


	public void setId_forma_pago(int id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}


	public int getId_contrato() {
		return id_contrato;
	}


	public void setId_contrato(int id_contrato) {
		this.id_contrato = id_contrato;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}


	public double getIva() {
		return iva;
	}


	public void setIva(double iva) {
		this.iva = iva;
	}
	
	
	
	
	
}
