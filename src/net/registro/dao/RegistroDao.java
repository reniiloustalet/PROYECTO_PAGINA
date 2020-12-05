package net.registro.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.registro.model.Registro;


public class RegistroDao {
	
	Connection connection = getConexion();
	PreparedStatement miStatement;
	ResultSet rs;
	String instruccionSql;
	boolean result = false;
	
	public Connection getConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagina", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public boolean existeUsuario(String usuario) throws SQLException {
		instruccionSql = "SELECT * FROM usuarios WHERE usuario = '" + usuario + "'";
		
		try {
			miStatement = connection.prepareStatement(instruccionSql);
			rs = miStatement.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs.next();
	}

	
	public boolean existeEmail(String email) throws SQLException{
		 
		instruccionSql = "SELECT * FROM usuarios WHERE email = '" + email + "'";
		
		try {
			miStatement = connection.prepareStatement(instruccionSql);
			rs = miStatement.executeQuery();


		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs.next();
	}
		
	public boolean registro (Registro registro) throws ClassNotFoundException {
		
		instruccionSql = "INSERT INTO usuarios (usuario, email, clave) VALUES (? , ?, ?)";
		
		try{
			
			//Conexion para poder insertar los datos en la base de datos
			miStatement = connection.prepareStatement(instruccionSql);
			miStatement.setString(1, registro.getUsuario());
			miStatement.setString(2, registro.getEmail());
			miStatement.setString(3, registro.getClave());
			
			int i = miStatement.executeUpdate();
			
			if(i == 1) {
				result = true;
			} else if(i == 0) {
				result = false;
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} 
		
	return result;
		
	}	
}		
	
