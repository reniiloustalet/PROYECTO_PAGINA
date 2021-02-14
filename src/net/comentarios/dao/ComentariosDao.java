package net.comentarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.comentarios.model.Comentarios;

public class ComentariosDao {
		
		Connection connection;
		PreparedStatement ps;
		String instruccionSql;
		int result;

		public Connection getConexion() {
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagina", "root", "root");

		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		}
		
		public void comentarios(Comentarios comentarios) {
			
			instruccionSql = "INSERT INTO comentarios (usuario, comentario) VALUES (?, ?)";
			try {
			connection = getConexion();
			ps = connection.prepareStatement(instruccionSql);
			ps.setString(1, comentarios.getUsuario());
			ps.setString(2, comentarios.getComentario());
			
			ps.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
		}
			}
		
}
