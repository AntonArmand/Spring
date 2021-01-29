<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form method="POST" modelAttribute="clientParDefaut" action="resultClient">
	<label>Nom</label>
	<form:input path="nom"/><p>
	<label>Prenom</label>
	<form:input path="prenom"/><p>
	<label>Adresse</label>
	<form:input path="adresse"/><p>
	<label>Code postal</label>
	<form:input path="codepostal"/><p>
	<label>ville</label>
	<form:input path="ville"/><p>
	<input type="submit" value="Créer l'utilisateur" name="ajouter"/><p>
</form:form>