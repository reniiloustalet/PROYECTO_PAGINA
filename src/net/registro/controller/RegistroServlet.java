package net.registro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.registro.dao.RegistroDao;
import net.registro.model.Registro;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RegistroDao registroDao = new RegistroDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		
		Registro registro = new Registro();
		
		registro.setUsuario(usuario);
		registro.setEmail(email);
		registro.setClave(clave);
		
		boolean result = false;
		
		try {
			result = registroDao.registro(registro);
				if(result) {
					response.sendRedirect("newUserConfirmacion.jsp");
					//request.getRequestDispatcher("newuser.jsp").forward(request, response);
				} else {
					response.sendRedirect("usuarioExistente.jsp");
				}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	
		
	}

}
