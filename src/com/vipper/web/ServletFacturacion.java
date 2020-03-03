package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.*;
import com.vipper.persistencia.*;


@WebServlet("/servletfacturacion")
public class ServletFacturacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletFacturacion() {
        super();

    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		System.out.println("INSIDE INIT");
		/*
		AccesoBBDD accesoBBDD = new AccesoBBDD();
		try {
			Pedido jPedido = accesoBBDD.mostrarPedido(1);
			System.out.println("Producto recogido" + jPedido.toString());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		} 
		*/

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recoger la opcion
				int jopcion = Integer.parseInt(request.getParameter("op"));
				RequestDispatcher rd = null;
				HttpSession miSesion = null;
				int jid = 0;				
				boolean jusuarioLogueado = false;
				
				AccesoBBDD accesoBBDD = null;
				Pedido jPedido = null;
				ClienteProveedor jClienteProveedor = null;
				ServicioProducto jServicioProducto = null;
				Factura jFactura = null;
				
				switch (jopcion) {
				case 1:			
					//MostrarTodos, se llama desde el index
					//Instanciar ArrayList
					List<Pedido> pedidosBBDD = null;
					accesoBBDD = new AccesoBBDD();
					try {
						pedidosBBDD = accesoBBDD.mostrarTodosPedidos();
					} catch (ClassNotFoundException | SQLException e) {
						System.out.println(e.toString());
					}
					
					//Guardar los productos en ámbito request HttpServletRequest
					request.setAttribute("requestTodosPedidos", pedidosBBDD);
					
					//Redirigir desde este Servlet a la pagina jsp de mostrar todos
					rd = request.getRequestDispatcher("/mostrartodospedidos.jsp");
					rd.forward(request, response); //Ejecuta el envío a través del response
					
					break;
					
				case 2:
					jPedido = (Pedido)request.getAttribute("pedido");

					accesoBBDD = new AccesoBBDD();
					try {
						jPedido = accesoBBDD.mostrarPedido(jPedido.getId_pedido());
						
						if (jPedido == null) {
							request.setAttribute("mensajeError", "Pedido no encontrado");
							rd = request.getRequestDispatcher("/paginaerror.jsp");
							rd.forward(request, response);
							break;
						}
						
						System.out.println("Pedido recogido" + jPedido.toString());
					} catch (ClassNotFoundException | SQLException e) {
						System.out.println(e.toString());
					} 
					//Se guarda el producto con los datos de la BBDD en el ambito request
					request.setAttribute("pedido", jPedido);
					rd = request.getRequestDispatcher("/mostrarpedido.jsp");
					rd.forward(request, response);
					break;
					
				case 3:			
					//MostrarTodos, se llama desde el index
					//Instanciar ArrayList
					List<ClienteProveedor> clientesProveedoresBBDD = null;
					accesoBBDD = new AccesoBBDD();
					try {
						clientesProveedoresBBDD = accesoBBDD.mostrarTodosClientesProveedores();
					} catch (ClassNotFoundException | SQLException e) {
						System.out.println(e.toString());
					}
					
					//Guardar los productos en ámbito request HttpServletRequest
					request.setAttribute("requestTodosClientesProveedores", clientesProveedoresBBDD);
					
					//Redirigir desde este Servlet a la pagina jsp de mostrar todos
					rd = request.getRequestDispatcher("/mostrartodosclientesproveedores.jsp");
					rd.forward(request, response); //Ejecuta el envío a través del response
					
					break;
					
				case 4:
					jClienteProveedor = (ClienteProveedor)request.getAttribute("clienteproveedor");
					accesoBBDD = new AccesoBBDD();
					try {
						jClienteProveedor = accesoBBDD.mostrarClienteProveedor(jClienteProveedor.getId());
						
						if (jClienteProveedor == null) {
							request.setAttribute("mensajeError", "Cliente/Proveedor no encontrado");
							rd = request.getRequestDispatcher("/paginaerror.jsp");
							rd.forward(request, response);
							break;
						}

						System.out.println("Cliente/Prov recogido" + jClienteProveedor.toString());
					} catch (ClassNotFoundException | SQLException e) {
						System.out.println(e.toString());
					} 
					//Se guarda el producto con los datos de la BBDD en el ambito request
					request.setAttribute("clienteproveedor", jClienteProveedor);
					rd = request.getRequestDispatcher("/mostrarclienteproveedor.jsp");
					rd.forward(request, response);
					break;
					
				case 5:			
					//MostrarTodos, se llama desde el index
					//Instanciar ArrayList
					List<ServicioProducto> serviciosProductosBBDD = null;
					accesoBBDD = new AccesoBBDD();
					try {
						serviciosProductosBBDD = accesoBBDD.mostrarTodosServiciosProductos();
					} catch (ClassNotFoundException | SQLException e) {
						System.out.println(e.toString());
					}
					
					//Guardar los productos en ámbito request HttpServletRequest
					request.setAttribute("requestTodosServiciosProductos", serviciosProductosBBDD);
					
					//Redirigir desde este Servlet a la pagina jsp de mostrar todos
					rd = request.getRequestDispatcher("/mostrartodosserviciosproductos.jsp");
					rd.forward(request, response); //Ejecuta el envío a través del response
					
					break;
					
				case 6:
					jServicioProducto = (ServicioProducto)request.getAttribute("servicioproducto");
					accesoBBDD = new AccesoBBDD();
					try {
						jServicioProducto = accesoBBDD.mostrarServicioProducto(jServicioProducto.getId_servicio());
						
						if (jServicioProducto == null) {
							request.setAttribute("mensajeError", "Servicio/Producto no encontrado");
							rd = request.getRequestDispatcher("/paginaerror.jsp");
							rd.forward(request, response);
							break;
						}

						System.out.println("Servicio/Producto encontrado" + jServicioProducto.toString());
					} catch (ClassNotFoundException | SQLException e) {
						System.out.println(e.toString());
					} 
					//Se guarda el producto con los datos de la BBDD en el ambito request
					request.setAttribute("servicioproducto", jServicioProducto);
					rd = request.getRequestDispatcher("/mostrarservicioproducto.jsp");
					rd.forward(request, response);
					break;

				case 7:			
					//MostrarTodos, se llama desde el index
					//Instanciar ArrayList
					List<Factura> facturasBBDD = null;
					accesoBBDD = new AccesoBBDD();
					try {
						facturasBBDD = accesoBBDD.mostrarTodosFacturas();
					} catch (ClassNotFoundException | SQLException e) {
						System.out.println(e.toString());
					}
					
					//Guardar los productos en ámbito request HttpServletRequest
					request.setAttribute("requestTodosFacturas", facturasBBDD);
					
					//Redirigir desde este Servlet a la pagina jsp de mostrar todos
					rd = request.getRequestDispatcher("/mostrartodosfacturas.jsp");
					rd.forward(request, response); //Ejecuta el envío a través del response
					
					break;
					
				case 8:
					jServicioProducto = (ServicioProducto)request.getAttribute("servicioproducto");
					accesoBBDD = new AccesoBBDD();
					try {
						jServicioProducto = accesoBBDD.mostrarServicioProducto(jServicioProducto.getId_servicio());
						
						if (jServicioProducto == null) {
							request.setAttribute("mensajeError", "Servicio/Producto no encontrado");
							rd = request.getRequestDispatcher("/paginaerror.jsp");
							rd.forward(request, response);
							break;
						}

						System.out.println("Servicio/Producto encontrado" + jServicioProducto.toString());
					} catch (ClassNotFoundException | SQLException e) {
						System.out.println(e.toString());
					} 
					//Se guarda el producto con los datos de la BBDD en el ambito request
					request.setAttribute("servicioproducto", jServicioProducto);
					rd = request.getRequestDispatcher("/mostrarservicioproducto.jsp");
					rd.forward(request, response);
					break;
					
					
					
				default:
					
					break;
					
				}
				
				
	}

}
