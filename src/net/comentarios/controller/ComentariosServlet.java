package net.comentarios.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.comentarios.dao.ComentariosDao;
import net.comentarios.model.Comentarios;

/**
 * Servlet implementation class ComentariosServlet
 */
@WebServlet("/ComentariosServlet")
public class ComentariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ComentariosDao comentariosDao = new ComentariosDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComentariosServlet() {
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
		String comentario = request.getParameter("comentario");
		
		Comentarios comentarios = new Comentarios();
		
		comentarios.setUsuario(usuario);
		comentarios.setComentario(comentario);
		
		
		try {
			comentariosDao.comentarios(comentarios);
			if(usuario != null) {
			//HttpSession session = request.getSession();
			request.getRequestDispatcher("seriesNetflix.jsp").forward(request, response);
				//if(session.getAttribute("usuario") != null) {
					//request.getRequestDispatcher("comentarioConfirmacion.jsp").forward(request, response);
				//} else {
					//request.getRequestDispatcher("login.jsp").forward(request, response);
				//}
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}

		
	
