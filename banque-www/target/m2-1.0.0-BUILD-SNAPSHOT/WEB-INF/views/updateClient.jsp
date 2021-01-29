<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<style>
table, p, h1 {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	widht: 100%;
}

td, th {
	border: 1px solid #dddddd;
	test-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Modifications Client</title>
</head>
<body>
<h2>Modifications de l'utilisateur :</h2>
<table>
  <tr><td>Nom : </td><td>${client.nom}</td></tr>
  <tr><td>Prenom : </td><td>${client.prenom}</td></tr>
  <tr><td>Adresse : </td><td>${client.adresse}</td></tr>
  <tr><td>Code postal : </td><td>${client.codepostal}</td></tr>
  <tr><td>Ville : </td><td>${client.ville}</td></tr>
</table>
<br>

<button><a href="./">Retour à la page d'accueil</a></button>

</body>
</html>