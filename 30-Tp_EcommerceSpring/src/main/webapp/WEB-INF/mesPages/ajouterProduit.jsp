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
			href="${pageContext.request.contextPath }/adminPro/accueilAdminPro">accueilAdminPro</a></li>
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
		
<h2>Formulaire ajouter produit</h2>
	<form:form method="POST" action="soumettreFormAjoutProduit"
		modelAttribute="produitForm">
		<table>
			<tr>
				<td>${produitForm.id}</td>
				<td><form:input path="id" type="hidden" /></td>

			</tr>
			<tr>
				<td><form:label path="idProduit">Num:</form:label></td>
				<td><form:input path="idProduit" /></td>
				<td><form:errors path="idProduit" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="designation">designation:</form:label></td>
				<td><form:input path="designation" /></td>
				<td><form:errors path="designation" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="prix">prix</form:label></td>
				<td><form:input path="prix" /></td>
				<td><form:errors path="prix" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="selectionne">Selection initialiser a false</form:label></td>
				<td><form:input path="selectionne" /></td>
				<td><form:errors path="selectionne" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="categorie_associe.id">Id Categorie</form:label></td>
				<td><form:input path="categorie_associe.id" /></td>
				<td><form:errors path="categorie_associe.id"
						cssStyle="color:red" /></td>

			</tr>
			<tr>
				<td><input type="submit" value="soummettre" /></td>

			</tr>
		</table>
	</form:form>
	</div>


	
</body>
</html>