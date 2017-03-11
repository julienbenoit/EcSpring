<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/js/bootstrap.js"/>" />

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

li a:hover:not (.active ) {
	background-color: #555;
	color: white;
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
		<h2>Formulaire ajouter categorie</h2>

	<form:form method="POST" action="soumettreFormAjoutCat"
		modelAttribute="categorieForm">
		<table>
			<tr>
				<td>${categorieForm.id}</td>
				<td><form:input path="id" type="hidden" /></td>

			</tr>
			<tr>
				<td><form:label path="idCategorie">Num:</form:label></td>
				<td><form:input path="idCategorie" /></td>
				<td><form:errors path="idCategorie" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="nomCategorie">Nom:</form:label></td>
				<td><form:input path="nomCategorie" /></td>
				<td><form:errors path="nomCategorie" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color:red" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="value" /></td>

			</tr>


		</table>
	</form:form>
	</div>



	
</body>
</html>