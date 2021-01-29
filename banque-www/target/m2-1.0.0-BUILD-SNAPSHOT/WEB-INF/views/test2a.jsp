<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Test2a</title>
</head>
<body>
<h1>
	Bonjour depuis la jsp test2a !
</h1>

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

<P> la servlet a envoyé les valeurs suivantes : </P>
<P> un : ${un}</P>
<table>
<tr><th>clé</th><th>Valeur</th></tr>
<tr><td>un </td><td>${un}</td></tr>
<tr><td>deux </td><td>${deux}</td></tr>
<tr><td>trois </td><td>${trois}</td></tr>
</table>
</body>
</html>