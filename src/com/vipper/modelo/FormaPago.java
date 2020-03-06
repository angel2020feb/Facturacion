package com.vipper.modelo;

public class FormaPago {
	private int id_formaPago;
	private String	string;
	private double valor;
	
	public FormaPago(int id_formaPago, String string, double valor) {
		super();
		this.id_formaPago = id_formaPago;
		this.string = string;
		this.valor = valor;
	}

	public FormaPago() {
		super();
	}

	@Override
	public String toString() {
		return "FormaPago [id_formaPago=" + id_formaPago + ", string=" + string + ", valor=" + valor + "]";
	}

	public int getId_formaPago() {
		return id_formaPago;
	}

	public void setId_formaPago(int id_formaPago) {
		this.id_formaPago = id_formaPago;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	


}
