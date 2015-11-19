<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
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

	<header>
		<%@ include file="header.jsp" %>

	</header>
	<nav id="barre-menus" class="nav-conteneur">
		<ul>
			<li><a href="accueil.jsp" class="menu-horizontale">accueil</a></li>
			<li><a href="../restreint/ajouterprojet.jsp"
				class="menu-horizontale">ajouter un projet</a></li>
			<li><a href="../restreint/contacts.jsp" class="menu-horizontale">contact
			</a></li>
		</ul>
	</nav>



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

	<a href="AjouterCollaborateurs?idProjet=${projet.idProjet}" class="menu-ppale">Ajouter des collaborateurs</a>
	<br>

	</div>




	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<footer> outil de de gestion de projet réalisé dans le cadre
		du module Conduite de projet </footer>

</body>
</html>