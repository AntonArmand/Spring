<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Test2a</title>
</head>
<body>
<h1>
	Bonjour depuis la jsp test3 !
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

<P> la servlet a envoyé les valeurs suivantes : ${chaine } </P>
</body>
</html>