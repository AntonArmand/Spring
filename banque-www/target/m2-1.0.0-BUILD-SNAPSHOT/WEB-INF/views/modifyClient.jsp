<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Modifications Client</title>
</head>
<body>

<h2> Modifiez les informations du client :</h2>

<form method="POST" action="updateClient?id=${C.id}">
	<label>Nom :</label>
	<br>
	<input type="text" name="nom" value="${C.nom}"/><p>
	<label>Prenom :</label>
	<br>
	<input type="text" name="prenom" value="${C.prenom}"/><p>
	<label>Adresse :</label>
	<br>
	<input type="text" name="adresse" value="${C.adresse}"/><p>
	<label>Code postal :</label>
	<br>
	<input type="text" name="codepostal" value="${C.codepostal}"/><p>
	<label>Ville :</label>
	<br>
	<input type="text" name="ville" value="${C.ville}"/><p>
	<input type="submit" value="Enregistrer les modifications" name="update"/><p>
</form>

<button><a href="./">Retour à la page d'accueil sans sauvegarder</a></button>
</body>
</html>