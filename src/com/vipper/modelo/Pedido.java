package com.vipper.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Pedido implements Serializable{
	//Atributos
	private int id_pedido;
	private String descrip;
	private int id;
	private int id_forma_pago;
	private double total;
	private LocalDate fecha;
	private int id_servicio;
	private int id_contrato;
	private double importe_facturado;
	
	
	//Métodos
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", descrip=" + descrip + ", id=" + id + ", id_forma_pago="
				+ id_forma_pago + ", total=" + total + ", fecha=" + fecha + ", id_servicio=" + id_servicio
				+ ", id_contrato=" + id_contrato + ", importe_facturado=" + importe_facturado + "]";
	}
	
	public void actualizarImporteFacturado(double incremento) {
		importe_facturado+=incremento;
	}
	
	public Factura generarFactura(double importe, String concepto, double iva) {
		return new Factura(id_pedido,id,id_pedido,fecha,id_servicio,
				importe,id_forma_pago,id_contrato,concepto, iva);
	}
	
	
	//Constructores
	public Pedido() {}
		
	public Pedido(int id_pedido, String descrip, int id, int id_forma_pago, double total, LocalDate fecha,
			int id_servicio, int id_contrato, double importe_facturado) {
		super();
		this.id_pedido = id_pedido;
		this.descrip = descrip;
		this.id = id;
		this.id_forma_pago = id_forma_pago;
		this.total = total;
		this.fecha = fecha;
		this.id_servicio = id_servicio;
		this.id_contrato = id_contrato;
		this.importe_facturado = importe_facturado;
	}


	
	//Getters y Setters
	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(int id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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

	public int getId_contrato() {
		return id_contrato;
	}

	public void setId_contrato(int id_contrato) {
		this.id_contrato = id_contrato;
	}

	public double getImporte_facturado() {
		return importe_facturado;
	}

	public void setImporte_facturado(double importe_facturado) {
		this.importe_facturado = importe_facturado;
	}
	
	
	
}
