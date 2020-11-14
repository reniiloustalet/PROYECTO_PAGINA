<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.registro.controller.RegistroServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrarse</title>
<script type="text/javascript">

	function validar(){
		
		var texto;
		var usuario = document.forms["formulario"]["usuario"].value;
		var email = document.forms["formulario"]["email"].value;
		var clave = document.forms["formulario"]["clave"].value;
		var clave2 = document.forms["formulario"]["clave2"].value;
		/*var usuario = document.getElementById("usuario").value;
		var email = document.getElementById("email").value;
		var clave = document.getElementById("clave").value;
		var clave2 = document.getElementById("clave2").value;*/
		
		if(usuario == null || usuario == ""){
			texto = "Ingresar un nombre de usuario";
			document.getElementById("info").innerHTML = texto;
			return false;
		} else if(usuario.length > 16){
			texto = "El usuario es muy largo";
			return false;
		} else if(clave == null || clave == "" || clave2 == null || clave2 == ""){
			texto = "Clave incompleta";
			document.getElementById("info").innerHTML = texto;
			return false;
		/*} else if(usuario.match(/^\s+$/){
			texto = "El usuario solo puede contener letras y numeros";
			document.getElementById("info").innerHTML = texto;
			return false;*/
		} else if(clave != clave2){
			texto = "Las claves no coinciden";
			document.getElementById("info").innerHTML = texto;
			return false;
		} else if(email == "" || email == null){
			texto = "Ingresar un email";
			document.getElementById("info").innerHTML = texto;
			return false;
		}
		
	}
		
</script>
</head>
<body>
<h1 style="text-align:center">Nuevo usuario</h1>
<div id="info"></div>
<form action="<%= request.getContextPath() %>/RegistroServlet" name="formulario" method="post" onsubmit="return validar();">
	<table>
		<tr>
			<td><label for="usuario">Nombre de usuario: </label>
			<td><input type="text" id="usuario" name="usuario"></td>
		</tr>
		<tr>
			<td><label for="email">Correo electronico: </label>
			<td><input type="email" id="email" name="email"></td>
		</tr>
		<tr>
			<td><label for="clave">Clave: </label>
			<td><input type="password" id="clave" name="clave"></td>
		</tr>
		<tr>
			<td><label for="clave2">Reingreso de clave: </label>
			<td><input type="password" id="clave2"></td>
		</tr>
	</table>
<p><input type="submit" value="Enviar" name="enviar"></p>
</form>
</body>
</html>