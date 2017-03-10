<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- ajout de la tag lib form de spring -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Formulaire</h1>
	<form method="GET" action="supprimerEmploye">
		<!--pas besoin car command model attribute ou commandName="clientForm"-->
		<table>
			<tr>
				<td>Id: </td>
				<td><input name="id_param" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="value" /></td>

			</tr>


		</table>
	</form>
</body>
</html>