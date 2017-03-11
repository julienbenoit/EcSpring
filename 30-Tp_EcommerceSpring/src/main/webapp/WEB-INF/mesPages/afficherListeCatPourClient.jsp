
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	margin: 0;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 25%;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

li a.active {
	background-color: #4CAF50;
	color: white;
}
li
 
a
:hover
:not
 
(
.active
 
)
{
background-color
:
 
#555
;

	
color
:
 
white
;


}
</style>

</head>
<body>

	<h1>Accueil Site pour Ecommerce</h1>

	<ul>
		<li><a
			href="${pageContext.request.contextPath }/adminPro/accueilAdminPro">accueilAdminPro</li>
		<li><a
			href="${pageContext.request.contextPath }/admin/accueilAdmin">accueilAdmin</a></li>
		<li><a href="listeCategorieClient">consulter categorie</a></li>
		<li><a href="listeProduitParCategorie">consulter produit par
				categorie</a></li>
		<li><a href="afficherListeProduitParSelection">consulter
				produit selectionne</a></li>
		<li><a href="listeProduitParMotCle">consulter produit par mot
				cle</a></li>
		<li><a href="supprimerProduitDansPanier">supprimer un produit
				au panier</a></li>
		<li><a href="enregistrerCommande">enregistrer une commande</a></li>
		<li><a href="ajouterProduitDansPanier">ajouter un produit du
				panier</a></li>
	</ul>

	<div style="margin-left: 25%; padding: 1px 16px; height: 1000px;">
		<h2>Liste Categorie</h2>
		<table cellspacing="0" cellpadding="6" border="1" width="60%">
			<tr bgcolor="grey" style="color: white;">
				<th>Id</th>
				<th>Num Categorie</th>
				<th>Nom</th>
				<th>Description</th>
			</tr>
			<c:forEach var="emp" items="${catListe}">
				<tr bgcolor="lightyellow">
					<td>${emp.id}</td>
					<td>${emp.idCategorie}</td>
					<td>${emp.nomCategorie}</td>
					<td>${emp.description}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>