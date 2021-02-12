/*package net.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.login.bean.LoginBean;
import net.login.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
/*@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public LoginServlet() {
        super();
    }
    
    public void init() {
    	loginDao = new LoginDao();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Capturar los datos del formulario
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		LoginBean loginBean = new LoginBean();
		
		loginBean.setUsuario(usuario);
		loginBean.setClave(clave);

		//validar el usuario y la clave
		try {
			if(loginDao.login(loginBean)) {
				request.setAttribute("usuario", usuario);
				HttpSession ses = request.getSession(); 
				ses.setAttribute("usuario", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("seriesNetflix.jsp");
				rd.forward(request, response);
			} else {
				request.getRequestDispatcher("usuarioInexistente.jsp").forward(request, response);
			}

			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
	}

}*/


