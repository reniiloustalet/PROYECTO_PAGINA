package net.comentarios.model;

public class Comentarios {
	
	private String usuario;
	private String comentario;
	
	public Comentarios(String usuario, String comentario) {
		super();
		this.usuario = usuario;
		this.comentario = comentario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
