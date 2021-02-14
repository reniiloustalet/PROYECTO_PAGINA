package net.proyectopagina.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.proyectopagina.model.Usuario;

public class UsuarioDao {
	
	Connection connection = getConexion();
	PreparedStatement ps;
	ResultSet rs;
	boolean status = false;
	int i;
	String instruccionSql;
	Usuario usuario;
	
	public Connection getConexion() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pagina", "root", "root");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	//Registrar usuario
	public void registro(Usuario usuario) {
		
		instruccionSql = "INSERT INTO usuarios (usuario, clave) VALUES (?,?)";
		
		try {
			connection = getConexion();
			ps = connection.prepareStatement(instruccionSql);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getClave());
			
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Verificar si ya existe
	public boolean existeUsuario(String usuario, String clave) throws SQLException {
		
		instruccionSql = "SELECT * FROM usuarios WHERE usuario = ?";
		
		try {
			connection = getConexion();
			ps = connection.prepareStatement(instruccionSql);
			ps.setString(1, usuario);
			ps.setString(2, clave);
			rs = ps.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs.next();
	}
	
	//Inicio de sesión
	public boolean login(String usuario, String clave) throws SQLException {
		
		instruccionSql = "SELECT * FROM usuarios WHERE usuario = ? AND clave = ?";
		
		try {
			connection = getConexion();
			ps = connection.prepareStatement(instruccionSql);
			ps.setString(1, usuario);
			ps.setString(2, clave);
			rs = ps.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs.next();
	}
	
	//Actualizar clave
	public boolean editarClave(Usuario usuario) {
		
		instruccionSql = "UPDATE usuarios SET clave = ? WHERE usuario = ?";
		
		try {
			connection = getConexion();
			ps = connection.prepareStatement(instruccionSql);
			ps.setString(1, usuario.getClave());
			
			i = ps.executeUpdate();
			
			if(i == 1) {
				status = true;
			} else {
				status = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	
	//Eliminar usuario
	public boolean eliminar(int id) {
		
		instruccionSql = "DELETE FROM usuarios WHERE usuario = ? AND clave = ?";
		
		try {
			connection = getConexion();
			ps = connection.prepareStatement(instruccionSql);
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			
			if(i == 1) {
				status = true;
			}else {
				status = false;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}	

}
