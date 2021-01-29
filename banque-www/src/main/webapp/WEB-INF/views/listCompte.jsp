<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
<title> Liste des comptes bancaires</title>

</head>
<body>
<h1>
	Liste des comptes bancaires
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
<tr><th>ID</th><th>Solde actuel</th></tr>
<c:forEach var ="entry" items="${data}">
<tr><td>${entry.key}</td><td>${entry.value}</td></tr>
</c:forEach>
</table>
</body>
</html>