package net.comentarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.comentarios.model.Comentarios;

public class ComentariosDao {
	
	public int comentarios (Comentarios comentarios) throws ClassNotFoundException {
		
		Connection connection;
		PreparedStatement miStatement;
		String instruccionSql = "INSERT INTO comentarios (usuario, comentario) VALUES (?, ?)";
		int result = 0;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagina", "root", "root");

			miStatement = connection.prepareStatement(instruccionSql);
			miStatement.setString(1, comentarios.getUsuario());
			miStatement.setString(2, comentarios.getComentario());
			
			miStatement.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	return result;
	
	}
	
}
