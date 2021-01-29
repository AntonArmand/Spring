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
	<title>Montant</title>
</head>
<body>
<h2> Saisissez le montant du virement :</h2>
<form method="POST" action="resultVirement?idD=${idD}&idC=${idC}">
	<label>Montant du virement :</label>
	<br>
	<input type="text" name="montant" placeholder="Saisissez le montant"/><p>
	<input type="submit" value="Effectuez le virement" name="virement"/><p>
</form>
<br>
<button><a href="./">Retour à la page d'accueil</a></button>
</body>
</html>