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
		<h2>Formulaire</h2>

		<form:form method="POST" action="ajouterPanier"
			modelAttribute="produitForm">
			<table>

				<tr>
					<td><form:label path="idProduit">Id produit:</form:label></td>
					<td><form:input path="idProduit" /></td>
					<td><form:errors path="idProduit" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td><form:label path="quantite">Quantite:</form:label></td>
					<td><form:input path="quantite" /></td>
					<td><form:errors path="quantite" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="soummettre" /></td>

				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>