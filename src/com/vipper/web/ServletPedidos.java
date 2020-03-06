package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.ClienteProveedor;
import com.vipper.modelo.Factura;
import com.vipper.modelo.Pedido;
import com.vipper.modelo.ServicioProducto;
import com.vipper.modelo.Usuario;
import com.vipper.persistencia.AccesoBBDD;


/**
 * Servlet implementation class ServletPedidos
 */
@WebServlet("/servletpedidos")
public class ServletPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedidos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jopcion = Integer.parseInt(request.getParameter("op"));
		int jid_servicio;
		int jid_usuario;
		String jdescripcion;
		int jformadepago;
		
		Pedido jpedido = null;
		RequestDispatcher rd = null;
		HttpSession miSesion = null;
		
		AccesoBBDD accesoBBDD = null;
		
		//miSesion = request.getSession();
		//String test = (String)miSesion.getAttribute("test");
		//System.out.println("LEIDO DESDE OTRO SERVLET: " + test);
		
		switch (jopcion) {
			// Generar o leer pedido, y añadir datos.
			case 1:			
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
				rd = request.getRequestDispatcher("/pedidoseleccionservicio.jsp");
				rd.forward(request, response); //Ejecuta el envío a través del response
				
				break;
				
			case 2:
				//1 Recoger los parámetros del servicio, buscar si existe pedido.
				miSesion = request.getSession();
				jid_servicio = Integer.parseInt(request.getParameter("id_servicio"));
				jid_usuario = ((Usuario)miSesion.getAttribute("usuarioInstance")).getIdUsuario();
				jpedido = (Pedido)miSesion.getAttribute("miPedido");
				
				//Si no hay pedido en la sesion se obtiene un null
				if (jpedido == null) {
					jpedido = new Pedido();
				}			
				//3 Añadir datos al pedido
				jpedido.setId_servicio(jid_servicio);
				jpedido.setId(jid_usuario);
				jpedido.setFecha(LocalDate.now());
				
				//Guardo el pedido en atributo de sesión
				miSesion.setAttribute("miPedido", jpedido);
				
				//4 Redirigir a mostrarCarrito.jsp
				rd = request.getRequestDispatcher("/pedidoformulariodatos.jsp");
				rd.forward(request, response); //Ejecuta el envío a través del response			
				
				break;
				
			case 3:
				//Añadir total
				
				//Venimos después de rellenar el formulario (Fase 2)
				//1 Recoger el id del servicio
				jdescripcion = request.getParameter("descripcion");	
				jformadepago = Integer.parseInt(request.getParameter("formapago"));
				//2 Recuperar la sesion y buscar si existe pedido.
				miSesion = request.getSession();
				jpedido = (Pedido)miSesion.getAttribute("miPedido");
				
				//Si no hay Pedido almacenado en la sesion se obtiene un null
				if (jpedido == null) {
					jpedido = new Pedido();
				}			
				//3 Añadir datos al pedido
				jpedido.setDescrip(jdescripcion);
				jpedido.setId_forma_pago(jformadepago);
				
				miSesion.setAttribute("miPedido", jpedido);
				
				System.out.println("PEDIDO COMPLETO: " + jpedido.toString());
				System.out.println("USUARIO: " + ((Usuario)miSesion.getAttribute("usuarioInstance")).toString());
				
				//4 Redirigir a menu
				//rd = request.getRequestDispatcher("/pedidoformulariodatos.jsp");
				//rd.forward(request, response); //Ejecuta el envío a través del response			
				
				break;
	
			default:
				break;
		}
	}

}
