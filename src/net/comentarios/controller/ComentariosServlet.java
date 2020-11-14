package net.comentarios.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.comentarios.dao.ComentariosDao;
import net.comentarios.model.Comentarios;
import net.login.bean.LoginBean;

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
		PrintWriter out = response.getWriter();
		
		
		try {
			comentariosDao.comentarios(comentarios);
			//if(usuario != null) {
			HttpSession session = request.getSession();
				/*if(session.getAttribute("usuario") != null) {
					response.sendRedirect("comentarioConfirmacion.jsp");
				} else{
					response.sendRedirect("login.jsp");
				}*/
				LoginBean loginBean = (LoginBean) session.getAttribute("usuario");
					if(loginBean == null) {
						request.getRequestDispatcher("login.jsp").forward(request, response);
						
					} else {
						response.sendRedirect("comentarioConfirmacion.jsp");
					}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
