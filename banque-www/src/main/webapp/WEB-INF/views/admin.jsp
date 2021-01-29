<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<title>Home</title>
</head>
<body>
<h1>
Page admin !
</h1>
<style>
table, p, h1, li {​​​​​
font-family: arial, sans-serif;
border-collapse: collapse;
width: 100%;
}​​​​​

td, th {​​​​​
border: 1px solid #dddddd;
text-align: left;
padding: 8px;
}​​​​​
tr:nth-child(even) {​​​​​
background-color: #dddddd;
}​​​​​
</style>
<P> ${​​​​​message}​​​​​. </P>
<table>
<tr><th>action </th><th>description</th></tr>
<tr><td><a href="effacerClient">effacer</a></td><td>effacement d'un client</td></tr>
<tr><td><a href="editerClient">éditer</a></td><td>formulaire d'édition des données du client</td></tr>
<tr><td><a href="<c:url value="/j_spring_security_logout" />" > déconnexion</a></td><td>quitter le mode admin</td></tr>
</table>
</body>
</html>
