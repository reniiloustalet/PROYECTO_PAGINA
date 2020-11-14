package net.comentariosRealizados.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.comentariosRealizados.bean.ComentariosRealizadosBean;

public class ComentariosRealizadosDao {
		
	public List<ComentariosRealizadosBean> ComentariosRealizadosBean(){
		Connection connection;
		PreparedStatement miStatement;
		ResultSet rs;
		List<ComentariosRealizadosBean> list = new ArrayList<ComentariosRealizadosBean>();
		String instruccionSql = "SELECT * FROM comentarios";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagina", "root", "root");
			miStatement = connection.prepareStatement(instruccionSql);
			rs = miStatement.executeQuery();
			
			while(rs.next()) {
				ComentariosRealizadosBean crb = new ComentariosRealizadosBean();
				crb.setUsuario(rs.getString(1));
				crb.setComentario(rs.getString(2));
				list.add(crb);
				
			}
			
			rs.close();
			connection.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		
		return list;
				
		
	}

}
