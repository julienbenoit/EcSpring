<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="background-color: ligntgreen; color: darkgreen; text-align: center">${nomApp}</h1>
<h1>${salutation}</h1>
<h5><a href="listeEmploye">liste des employes</a></h5>
<h5><a href="ajouterEmploye">Ajouter employes</a></h5>
<h5><a href="modEmploye">modifier employes</a></h5>
<h5><a href="supEmploye">supprimer employes</a></h5>
<h5><a href="obEmploye">Obtenir un employe</a></h5>

Liste Employes
<table cellspacing="0" cellpadding="6" border="1" width="60%">
<tr bgcolor="grey" style="color: white;">
<th>Id</th>
<th>Nom</th>
<th>Mail</th>
</tr>
<c:forEach var="emp" items="${empListe}">
<tr bgcolor="lightyellow">
<td>${emp.id}</td>
<td>${emp.nom}</td>
<td>${emp.mail}</td>
</tr>

</c:forEach>

</table>
</body>
</html>