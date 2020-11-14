package net.registro.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;

import net.registro.model.Registro;

public class RegistroDao {
	
	public boolean registro (Registro registro) throws ClassNotFoundException {

		Connection connection;
		PreparedStatement miStatement;
		String instruccionSql = "INSERT INTO usuarios (usuario, email, clave) VALUES (? , ?, ?)";
		boolean result = false;
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagina", "root", "root");

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
			
		} catch(Exception e){
			e.printStackTrace();
			
		} 
	
	
	return result;
		
	}	
}
	

