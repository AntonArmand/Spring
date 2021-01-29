<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<style>
h1 {
	front-family: arial, sans-serif;
	border-collapse: collapse;
	wight: 100%;
	text-align: center
}
table, p, li {
	front-family: arial, sans-serif;
	border-collapse: collapse;
	wight: 100%;
}

td, th {
	border: 1px, solid, #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<head>
	<title>Liste Comptes</title>
</head>
<body>
<h2> Choisir compte debiteur</h2>
<table>
	<th>Numéro</th>
	<th>Nom</th>
	<th>Prénom</th>
	<th>Solde du compte</th>
	<c:forEach var="listeC" items="${listeC}">
	<tr>
		<td>${listeC.numero}</td>
		<td>${listeC.client.nom}</td>
		<td>${listeC.client.prenom}</td>
		<td>${listeC.solde}</td>
		<td><a href="virementForm?id=${listeC.numero}">Debiteur</a></td>
	</tr>
	</c:forEach>
</table>
<br>
<button><a href="./">Retour à la page d'accueil</a></button>
</body>
</html>