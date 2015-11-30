<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/projet.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>projet</title>
<script type="text/javascript">
	function confirmer(url) {
		var repo = confirm("etes vous sure de vouloir supprimer cet user story?");
		if (repo == true) {
			document.location = url;
		}
	}
</script>
</head>
<body>


		<%@ include file="header.jsp" %>

	<br><br><br>


	<div class="div-conteneur" id="div-Collabs">
		<h2 id="h2-projet">
			Projet :
			<c:out value="${ projet.description }" />
		</h2>

		<strong>> Liste des collaborateurs </strong><br /> <br />

		<ul>
			<c:forEach var="collaborateur" items="${ collaborateurs }">
					
						<li>${ collaborateur.prenom }&nbsp; ${ collaborateur.nom } </li>

			</c:forEach>
		</ul>
		
		
			<br><br>

	<a href="AjouterCollaborateurs?idProjet=${projet.idProjet}" role="button" class="btn btn-primary btn-large">Ajouter des collaborateurs</a>
	<br>

	</div>




	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	 <%@ include file="footer.jsp" %>
</body>
</html>