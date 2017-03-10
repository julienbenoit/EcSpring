<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- ajout de la tag lib form de spring -->
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Formulaire</h1>
<form:form method="POST" action="obtenirEmploye" modelAttribute="employeForm" ><!--pas besoin car command model attribute ou commandName="clientForm"-->
<table>
<tr>
<td><form:label path="id">Id:</form:label></td>
<td><form:input path="id"/></td>
<td><form:errors path="id" cssStyle="color:red"/></td>
</tr>

<tr>
<td><input type="submit" value="value"/>  </td>

</tr>


</table>
</form:form>
</body>
</html>