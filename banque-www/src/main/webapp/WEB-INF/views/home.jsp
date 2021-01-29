<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Accueil</title>
</head>
<body>
<h1>
	Bienvenue sur notre site web (BANQUE)
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


<table>
<tr><th> </th><th>Fonctionnalités</th><tr>
<tr><td><a href="ajoutClient">Ajouter un client</a></td><td>Cette fonction permet d'ajouter un client à la base de données</td></tr>
<tr><td><a href="listClient">Lister les clients</a></td><td>Cette fonction permet d'afficher la liste des clients et d'ajouter un compte rattaché à un compte client, également de lister les comptes bancaires d'un client</td></tr>
<tr><td><a href="virement"> Virements</a></td><td>Cette fonction permet permet de réaliser d'un compte émetteur vers un compte bénéficiaire </td></tr>


</table>
</body>
</html>
