<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de sesión</title>
</head>
<body>

<h1 style="text-align:center">Iniciar sesión</h1>
<form action="<%= request.getContextPath() %>/LoginServlet" method="post">
	<table>
		<tr>
			<td width="13%"><label for="usuario">Nombre de usuario: </label></td>
			<td width="87%"><input type="text" name="usuario" required></td>
		</tr>
		<tr>
			<td><label for="clave">Clave: </label></td>
			<td><input type="password" name="clave" required></td>
		</tr>
	</table>
<p><input type="submit" value="Enviar" name="enviar"></p>
</form>
</body>
</html>