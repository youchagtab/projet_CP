<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<link rel="stylesheet" type="text/css" href="style_acceuil.css">
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

		<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" />
		<aside>Bienvenu ${utilisateur.nom} ${utilisateur.prenom}</aside>
	</header>



	<div>
		<h2>
			Projet :
			<c:out value="${ projet.description }" />
		</h2>
		<br /> <strong>Backlog : </strong> <a
			href="AjouterUserStory?idProjet=${projet.idProjet}">Ajouter</a>
		<table class="table1">
			<tr>
				<td>#</td>
				<td>Description</td>
				<td>Difficulté</td>
				<td>Priorité</td>
				<td>Action</td>
			</tr>
			<c:forEach var="userStory" items="${ userStories }">
				<tr>
					<td>${ userStory.idUS }</td>
					<td>${ userStory.description }</td>
					<td>${ userStory.difficulte }</td>
					<td>${ userStory.priorite}</td>
					<td><a
						href="ModifierUserStory?idUserStory=${userStory.idUS}&idProjet=${projet.idProjet}">
							Modifier </a>|<a
						href="javascript:confirmer('SupprimerUserStory?idUserStory=${userStory.idUS}&idProjet=${projet.idProjet}')">
							Supprimer </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<br />
</body>
</html>