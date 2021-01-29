<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
<title> Virements</title>

</head>
<body>
<h1>
	Virements d'un compte vers un autre
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

<form method="POST">
<b>Compte émetteur : </b>
<select required=""  name='lists'>  
	<option selected="selected">
   <c:forEach var ="entry" items="${data}">
       <option id="${entry.key}" value="${entry.key}">${entry.value}</option>   
   </c:forEach>
</select><p>
<b>Compte bénéficiaire : </b>
<select required=""  name='lists2'> 
<option selected="selected"> 
   <c:forEach var ="entry" items="${data}">
       <option id="${entry.key}" value="${entry.key}">${entry.value}</option>   
   </c:forEach>
</select><p>
<b>Montant : </b>
<input required="true"  type="text" name="montant"/><p>
<input type="submit" name="ajouter"/><p>

</form>

</body>
</html>