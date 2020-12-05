package net.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.login.bean.LoginBean;

public class LoginDao {
	
	Connection connection = getConexion();
	PreparedStatement miStatement;
	ResultSet rs;
	boolean status = false;
	String instruccionSql;
	
	public Connection getConexion() {

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagina", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public boolean login (LoginBean loginBean) throws ClassNotFoundException {

		instruccionSql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ?";
		
		try {

			miStatement = connection.prepareStatement(instruccionSql);
			miStatement.setString(1, loginBean.getUsuario());
			miStatement.setString(2, loginBean.getClave());

			rs = miStatement.executeQuery();
			
			status = rs.next();
	
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} 
		
		return status;
	}


}
