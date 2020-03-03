package com.vipper.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vipper.modelo.Usuario;
import com.vipper.persistencia.AccesoBBDD;

@WebServlet("/servletlogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jopcion = Integer.parseInt(request.getParameter("op"));
		RequestDispatcher rd = null;
		HttpSession miSesion = null;
		boolean jusuarioLogueado = false;
		AccesoBBDD accesoBBDD = null;
		Usuario usuario = null;
		String jusuario = "";
		String jpassword = "";
		String jtipousuario = "";
		
		switch (jopcion) {
		case 1:
			//Verificar si el usuario está logueado
			//Recoger las cookies
			
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("usuarionombre")) {
					jusuarioLogueado = true;
				}
				
				if(cookie.getName().equals("usuariotipo")) {
					jtipousuario = cookie.getValue();
				}
			}
						
			if (jusuarioLogueado) {
				if (jtipousuario.equals("1")) {
					rd = request.getRequestDispatcher("/menuadmin.jsp");
				} else if (jtipousuario.equals("0")) {
					rd = request.getRequestDispatcher("/menuuser.jsp");
				}			
			} else {
				rd = request.getRequestDispatcher("/login.jsp");
			}
			
			rd.forward(request, response);			
			break;
		case 2:
			//En caso de que la cookie NO exista, validamos con la BBDD
			//Recoger el nombre y el usuario de la BBDD
			//Acceder a la BBDD para verificarlo
			//Si la contraseña es correcta, lo redirigimos a /solicitarpago.jsp
			//Creamos la cookie
			//Si no es corrector, lo redirigimos a página de registro
			jusuario = request.getParameter("user");
			jpassword = request.getParameter("password");
						
			//System.out.println("JUSUARIO " + jusuario);
			//System.out.println("JPASSWORD " + jpassword);
			
			accesoBBDD = new AccesoBBDD();
			try {
				if (jpassword.equals(accesoBBDD.verificarPassword(jusuario))) {
					
					usuario = accesoBBDD.mostrarUsuario(jusuario);
					jtipousuario = String.valueOf(usuario.getTipoUsuario());
							
					Cookie miCookieUsuario = new Cookie("usuarionombre",jusuario);
					Cookie miCookieTipo = new Cookie("usuariotipo",jtipousuario);
					miCookieUsuario.setMaxAge(3600);
					miCookieTipo.setMaxAge(3600);
					
					response.addCookie(miCookieUsuario);
					response.addCookie(miCookieTipo);
					
					if (jtipousuario.equals("1")) {
						rd = request.getRequestDispatcher("/menuadmin.jsp");
					} else if (jtipousuario.equals("0")) {
						rd = request.getRequestDispatcher("/menuuser.jsp");
					}
					
					rd.forward(request, response);
					
				} else {
					request.setAttribute("mensajeError", "Usuario no encontrado");
					rd = request.getRequestDispatcher("/paginaerror.jsp");
					rd.forward(request, response);
					break;
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e.toString());
			}
			
			break;

		default:
			break;
		}
	}

}
