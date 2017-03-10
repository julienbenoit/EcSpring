<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Liste Employes
<h5><a href="${pageContext.request.contextPath }/employe/affichFormAjout">Ajout test un employe</a></h5>
<table cellspacing="0" cellpadding="6" border="1" width="60%">
<tr bgcolor="grey" style="color: white;">
<th>Id</th>
<th>Nom</th>
<th>Mail</th>
<th>Supp/Edit</th>
</tr>
<c:forEach var="emp" items="${empListe}">
<tr bgcolor="lightyellow">
<td>${emp.id}</td>
<td>${emp.nom}</td>
<td>${emp.mail}</td>
<td><a href="supprimerEmploye?id_param=${emp.id}">supp</a>|<a href="affichFormmodif?id_param=${emp.id}">Edit</a></td>
</tr>

</c:forEach>

</table>
</body>
</html>