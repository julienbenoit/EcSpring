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
<form:form method="POST" action="enregistrerEmploye" modelAttribute="employeForm" ><!--pas besoin car command model attribute ou commandName="clientForm"-->
<table>
<tr>
<td><form:label path="nom">Nom:</form:label></td>
<td><form:input path="nom"/></td>
<td><form:errors path="nom" cssStyle="color:red"/></td>
</tr>

<tr>
<td><form:label path="mail">Mail:</form:label></td>
<td><form:input path="mail"/></td>
<td><form:errors path="mail" cssStyle="color:red"/></td>
</tr>


<tr>
<td><input type="submit" value="value"/>  </td>

</tr>


</table>
</form:form>
</body>
</html>