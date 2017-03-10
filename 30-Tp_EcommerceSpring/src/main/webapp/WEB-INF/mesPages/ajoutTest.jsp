<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="<c:url value="/resources/js/bootstrap.js"/>" />
</head>
<body>
	<h1>Ajout</h1>
	<form:form method="POST" action="soummettreFormAjout"
		commandName="employeForm">
		<!--pas besoin car command model attribute ou commandName="clientForm"-->
		<table>

			<tr>
				<td>${employeForm.id}</td>
				<td><form:input path="id" type="hidden" /></td>

			</tr>
			<tr>
				<td><form:label path="nom">Nom:</form:label></td>
				<td><form:input path="nom" /></td>
				<td><form:errors path="nom" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td><form:label path="mail">Mail:</form:label></td>
				<td><form:input path="mail" /></td>
				<td><form:errors path="mail" cssStyle="color:red" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="value" /></td>

			</tr>


		</table>
	</form:form>
</body>
</html>