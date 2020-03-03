package com.vipper.modelo;

public class Usuario {
	//----- Atributos
	private int idUsuario;
	private String nomUsuario;
	private String password;
	private int tipoUsuario;
	
	
	//----- Métodos
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nomUsuario=" + nomUsuario + ", password=" + password
				+ ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
	//----- Constructores
	public Usuario() {}
	
	public Usuario(int idUsuario, String nomUsuario, String password, int tipoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nomUsuario = nomUsuario;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}
	
	
	//----- Getters/Setters
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomUsuario() {
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}
