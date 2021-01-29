<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
<title> Lister les utilisateurs</title>

</head>
<body>
<h1>
	Lister les utilisateurs  
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
<tr><th>ID</th><th>Nom et Prénom</th><th>Ajout d'un compte bancaire</th><th>Lister les comptes du client</th></tr>
<c:forEach var ="entry" items="${data}">

<tr><td>${entry.value} </td><td>${entry.key} </td><td><a href="addCompte?param=${entry.value}"> Ajouter</a></td><td><a href="listCompte?param=${entry.value}">Liste des comptes bancaires</td></tr>
</c:forEach>
</table>
</body>
</html>