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
	<title>Liste des virements</title>
</head>
<body>
<h2> Liste des virements :</h2>
<table>
	<th>Débiteur</th>
	<th>Créditeur</th>
	<th>Montant du virement</th>
	<c:forEach var="listeV" items="${listeV}">
	<tr>
		<td>${listeV.compted.client.nom} ${listeV.compted.client.prenom} numero ${listeV.compted.numero}</td>
		<td>${listeV.comptec.client.nom} ${listeV.comptec.client.prenom} numero ${listeV.comptec.numero}</td>
		<td>${listeV.somme}</td>
	</tr>
	</c:forEach>
</table>
<br>
<button><a href="./">Retour à la page d'accueil</a></button>
</body>
</html>