<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- ajout de la tag lib form de spring -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html >
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
		<h2>Formulaire ajouter produit</h2>

	<form:form method="GET" action="enregistrerCommandeSoum"
		commandName="commandeForm">
		<table>
			
			<tr>
				<td><form:label path="idCommande">Numero commande:</form:label></td>
				<td><form:input path="idCommande" /></td>
				<td><form:errors path="idCommande" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="client_associe.idClient">Numero client:</form:label></td>
				<td><form:input path="client_associe.idClient" /></td>
				<td><form:errors path="client_associe.idClient" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td><form:label path="client_associe.nomClient">Nom:</form:label></td>
				<td><form:input path="client_associe.nomClient" /></td>
				<td><form:errors path="client_associe.nomClient" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="client_associe.adresse">Adresse</form:label></td>
				<td><form:input path="client_associe.adresse" /></td>
				<td><form:errors path="client_associe.adresse" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td><form:label path="client_associe.email">Mail</form:label></td>
				<td><form:input path="client_associe.email" /></td>
				<td><form:errors path="client_associe.email" cssStyle="color:red" /></td>
				
			</tr>
			<tr>
				<td><form:label path="client_associe.tel">Telephone</form:label></td>
				<td><form:input path="client_associe.tel" /></td>
				<td><form:errors path="client_associe.tel" cssStyle="color:red" /></td>
				
			</tr>
			<tr>
				<td><input type="submit" value="soummettre" /></td>

			</tr>
		</table>
	</form:form>
	</div>

	
</body>
</html>