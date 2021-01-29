<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
<title>Ajouter un client:</title>

</head>
<body>
<h1>
Ajouter un client:
</h1>
<style>
table, p, h1, li{
 fonnt-family:arial, sans-serif;
 border-collapse : collapse;
 width: 100%

}

td, th {
   border: 1px solid #dddddd;
   text-align: left;
   padding: 8px;
}

tr:nth-child(even){
   background-color: #dddddd;}
}
</style>
<form method="POST">  <!-- appele en post -->
	<b>Nom du client : </b>   
	<input required  type="text" name="nom"/><p>
	<b>Prenom du client : </b>
	<input required  type="text" name="prenom"/><p>
	<b>Adresse du client : </b>
	<input  required type="text" name="adresse"/><p>
	<b>Code postal du client : </b>
	<input required  type="text" name="codepostal"/><p>
	<b>Ville du client: </b>
	<input required type="text" name="ville"/><p>
	<b>Mot de passe du client : </b>
	<input required type="password" name="mdp"/><p>
	<input type="submit" name="ajouter"/><p>

</form>
</body>
</html>