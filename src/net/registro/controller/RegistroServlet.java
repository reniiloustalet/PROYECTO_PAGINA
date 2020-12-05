package net.registro.controller;

import java.io.IOException;
import java.sql.SQLException;

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
	 * @return 
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
		
			try {
				if(registroDao.existeUsuario(usuario)) {
					request.getRequestDispatcher("usuarioExistente.jsp").forward(request, response);
			 	} else if(registroDao.existeEmail(email)) {
					request.getRequestDispatcher("emailExiste.jsp").forward(request, response);
				}else if(registroDao.registro(registro)){
					request.getRequestDispatcher("newUserConfirmacion.jsp").forward(request, response);
				}

				
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}

}
