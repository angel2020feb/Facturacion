package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vipper.modelo.*;

public class AccesoBBDD extends Conexion {
	
	public boolean checkNull(Object o) {
		return (o == null) ? true : false;
	}
	
	//Acceso a tablas en la BBDD
	//----- Pedido
	public List<Pedido> mostrarTodosPedidos() throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "call facturacion.mostrarTodosPedidos()";
		List<Pedido> result = new ArrayList<Pedido>();
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		//int id_pedido, String descrip, int id, int id_forma_pago, double total, LocalDate fecha,
		//int id_servicio, int id_contrato, double importe_facturado
		while (rs.next()) {
			result.add(
				new Pedido(
					rs.getInt("id_pedido"), 
					rs.getString("descrip"),
					rs.getInt("id"),
					rs.getInt("id_forma_pago"),
					rs.getDouble("total"),
					rs.getDate("fecha").toLocalDate(),
					rs.getInt("id_servicio"),
					rs.getInt("id_contrato"),
					rs.getDouble("importe_facturado")
				)
			);
		}

		cerrarConexion();		
		return result;		
	}

	public Pedido mostrarPedido(int idPedido) throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "call facturacion.mostrarPedido(?);";
		Pedido result = null;
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		st.setInt(1,idPedido);		
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		if (rs.next()) {
			result = new Pedido(
				rs.getInt("id_pedido"), 
				rs.getString("descrip"),
				rs.getInt("id"),
				rs.getInt("id_forma_pago"),
				rs.getDouble("total"),
				rs.getDate("fecha").toLocalDate(),
				rs.getInt("id_servicio"),
				rs.getInt("id_contrato"),
				rs.getDouble("importe_facturado")
			);
		}
		
		cerrarConexion();		
		return result;		
	}

	
	//----- ClienteProveedor
	public List<ClienteProveedor> mostrarTodosClientesProveedores() throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "call facturacion.mostrarTodosCliProv();";
		List<ClienteProveedor> result = new ArrayList<ClienteProveedor>();
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		//(int id, String NIF, String nombre, String direccion, String tipo, String email,
		//String telefono)
		while (rs.next()) {
			result.add(
				new ClienteProveedor(
					rs.getInt("id"), 
					rs.getString("NIF"),
					rs.getString("nombre"),
					rs.getString("direccion"),
					rs.getString("tipo"),
					rs.getString("email"),
					rs.getString("telefono")
				)
			);
		}
		
		cerrarConexion();		
		return result;		
	}

	public ClienteProveedor mostrarClienteProveedor(int idCP) throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "call facturacion.mostrarCliProv(?);";
		ClienteProveedor result = null;
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		st.setInt(1,idCP);		
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		if (rs.next()) {
			result = new ClienteProveedor(
				rs.getInt("id"), 
				rs.getString("NIF"),
				rs.getString("nombre"),
				rs.getString("direccion"),
				rs.getString("tipo"),
				rs.getString("email"),
				rs.getString("telefono")
			);
		}
		
		cerrarConexion();		
		return result;		
	}
	
	
	//----- Factura
	public List<Factura> mostrarTodosFacturas() throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "      ";
		List<Factura> result = new ArrayList<Factura>();
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		//(int id_factura, int id, int id_pedido, LocalDate fecha, int id_servicio, double importe,
		//int id_forma_pago, int id_contrato, String concepto, double iva)
		while (rs.next()) {
			result.add(
				new Factura(
					rs.getInt("id_factura"), 
					rs.getInt("id"), 
					rs.getInt("id_pedido"), 
					rs.getDate("fecha").toLocalDate(),
					rs.getInt("id_servicio"),
					rs.getDouble("importe"),
					rs.getInt("id_forma_pago"),
					rs.getInt("id_contrato"),
					rs.getString("concepto"),
					rs.getDouble("iva")
				)
			);
		}
		
		cerrarConexion();		
		return result;		
	}

	public Factura mostrarFactura(int idFactura) throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "     ";
		Factura result = null;
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		st.setInt(1,idFactura);		
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		if (rs.next()) {
			result = new Factura(
					rs.getInt("id_factura"), 
					rs.getInt("id"), 
					rs.getInt("id_pedido"), 
					rs.getDate("fecha").toLocalDate(),
					rs.getInt("id_servicio"),
					rs.getDouble("importe"),
					rs.getInt("id_forma_pago"),
					rs.getInt("id_contrato"),
					rs.getString("concepto"),
					rs.getDouble("iva")
				);
		}
		
		cerrarConexion();		
		return result;		
	}
	
	
	
	
	//----- ServicioProducto
	public List<ServicioProducto> mostrarTodosServiciosProductos() throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "      ";
		List<ServicioProducto> result = new ArrayList<ServicioProducto>();
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		//int id_servicio, String descrip, double coste, int id, double iva
		while (rs.next()) {
			result.add(
				new ServicioProducto(
					rs.getInt("id_servicio"), 
					rs.getString("descrip"),
					rs.getDouble("coste"),
					rs.getInt("id"),
					rs.getDouble("iva")
				)
			);
		}
		
		cerrarConexion();		
		return result;		
	}

	public ServicioProducto mostrarServicioProducto(int idPedido) throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "     ";
		ServicioProducto result = null;
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		st.setInt(1,idPedido);		
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		if (rs.next()) {
			result = new ServicioProducto(
				rs.getInt("id_servicio"), 
				rs.getString("descrip"),
				rs.getDouble("coste"),
				rs.getInt("id"),
				rs.getDouble("iva")
			);
		}
		
		cerrarConexion();		
		return result;		
	}

	
	//----- Login usuario
	public String verificarPassword(String usuario) throws ClassNotFoundException, SQLException {
		String SQL = "call facturacion.verificarPassword(?)";		
		CallableStatement st;
		ResultSet rs;
		String password = null;
		
		//Abrir conexion
		abrirConexion();
		
		//Obtener el comando
		st = miConexion.prepareCall(SQL);
		
		//Asignar valores
		st.setString(1, usuario);
		
		//Ejecutar
		rs = st.executeQuery();
		
		if (rs.next()) {
			password = rs.getString("password");
		}
				
		//Cerrar conexion
		cerrarConexion();
		
		//System.out.println("PROCEDIMIENTO ALMACENADO:");
		//System.out.println(password);
		
		return password;
	}

	public Usuario mostrarUsuario(String usuario) throws ClassNotFoundException, SQLException{
		//Definir variables
		String SQL = "call facturacion.mostrarUsuario(?);";
		Usuario result = null;
		CallableStatement st;
		ResultSet rs;
		
		//Abrir la conexion
		abrirConexion();
		
		//Recoger el comando
		st = miConexion.prepareCall(SQL);
		st.setString(1,usuario);		
		
		//Ejecutamos el comando
		rs = st.executeQuery();
		
		//Recorremos el Result Set para crear la conexión
		if (rs.next()) {
			//int idUsuario, String nomUsuario, String password, int tipoUsuario
			result = new Usuario(
				rs.getInt("id_usuario"), 
				rs.getString("nom_usuario"),
				rs.getString("password"),
				rs.getInt("tipoUsuario")
			);
		}
		
		cerrarConexion();		
		return result;		
	}

	
}
