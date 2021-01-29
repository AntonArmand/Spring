<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
<title>Ajouter un compte</title>

</head>
<body>
<h1>
Ajouter un compte 
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
	<b>Montant du compte : </b>   
	<input required  type="text" name="montant"/><p>
	<input type="submit" name="ajouter"/><p>

</form>
</body>
</html>