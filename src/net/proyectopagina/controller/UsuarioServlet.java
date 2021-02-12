package net.proyectopagina.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.proyectopagina.dao.UsuarioDao;
import net.proyectopagina.model.Usuario;

/**
 * Servlet implementation class ProyectoPaginaServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao = new UsuarioDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
    	this.usuarioDao = new UsuarioDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		
		
		switch(action) {
		case "/registro":
			registro(request, response);
			break;
		case "/login":
			login(request, response);
			break;
		case "/actualizarUsuario":
			actualizarUsuario(request, response);
			break;
		case "/actualizarClave":
			actualizarClave(request, response);
			break;
		case "/eliminarUsuario":
			eliminarUsuario(request, response);
			break;
		default:
			break;
		}
		
	}

	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		usuarioDao.eliminarUsuario(id);
		response.sendRedirect("index.jsp");
		
	}

	private void actualizarClave(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		try {
			if(usuarioDao.login(usuario, clave)) {
				request.setAttribute("usuario", usuario);
				HttpSession ses = request.getSession();
				ses.setAttribute("usuario", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("seriesNetflix.jsp");
				rd.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('Datos incorrectos o usuario inexistente');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void registro(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		Usuario nuevoUsuario = new Usuario(usuario, clave);
		
		try {
		if(usuarioDao.registro(nuevoUsuario)) {
			
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
