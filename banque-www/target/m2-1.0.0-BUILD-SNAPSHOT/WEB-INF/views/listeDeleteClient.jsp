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
	<title>Suppresion Client</title>
</head>
<body>
<h2> S�lectionnez le client a supprimer :</h2>
<table>
	<th>Nom</th>
	<th>Prenom</th>
	<th>Adresse</th>
	<th>Code Postal</th>
	<th>Ville</th>
	<th></th>
	<c:forEach var="listeC" items="${listeC}">
	<tr>
		<td>${listeC.nom}</td>
		<td>${listeC.prenom}</td>
		<td>${listeC.adresse}</td>
		<td>${listeC.codepostal}</td>
		<td>${listeC.ville}</td>
		<td><a href="deleteClient?id=${listeC.id}">Supprimer</a></td>
	</tr>
	</c:forEach>
</table>
<br>
<button><a href="./">Retour � la page d'accueil</a></button>
</body>
</html>