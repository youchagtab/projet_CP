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
<<<<<<< HEAD
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
				<td>Difficult�</td>
				<td>Priorit�</td>
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
=======
		<h3>Bienvenue Monsieur ${utilisateur.nom} ${utilisateur.prenom}</h3>
		<br/>
		
		<di>
			<h2>Projet : <c:out value="${ projet.description }"/></h2>
			<br/>
			<strong>Backlog : </strong><a href="AjouterUserStory?idProjet=${projet.idProjet}">Ajouter</a>
				<table class="table1">
					<tr>
						<td>#</td><td>Description</td><td>Difficult�</td><td>Priorit�</td><td>Actions</td>
					</tr>
					<c:forEach var="userStory" items="${ userStories }">
					<tr>
						<td>${ userStory.idUS }</td><td>${ userStory.description }</td><td>${ userStory.difficulte }</td><td>${ userStory.priorite}</td><td><a href="ModifierUserStory?idUserStory=${userStory.idUS}&idProjet=${projet.idProjet}"> Modifier </a>|<a href="javascript:confirmer('SupprimerUserStory?idUserStory=${userStory.idUS}&idProjet=${projet.idProjet}')"> Supprimer </a></td>
					</tr>
					</c:forEach>
				</table>
		</div>
	<br>
	<br>
	<br>
		<form action="deconnexion" method="post">
		<input type="submit" value="deconnexion" name="action" />
	</form>
	<br>
	<br>
	<br>
	<dv> <footer> outil de de gestion de projet r�alis� dans
		le cadre du module Conduite de projet </footer> </dv>
		<br/>
>>>>>>> 1a1b1af047d3f2feef7fc1e088495056516865bb
</body>
</html>