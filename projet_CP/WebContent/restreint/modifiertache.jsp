<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>modification d'une tâche</title>
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

	<br />

	<div class="div-conteneur" id="div-modifTache">
		<h3>Modifier une tâche</h3>
		<form action="ModifierTache" method="post">
			<table class="table1">
			    <tr>
					<td>Description :</td>
					<td><textarea name="description">${tache.description }</textarea></td>
				</tr>
			    <tr>
					<td>Tag :</td>
					<td><textarea name="tag">${tache.tag }</textarea></td>
				</tr>
				
				<tr>
					<td>cout :</td>
					<td><textarea name="cout">${tache.cout}</textarea></td>
				</tr>
				<tr>
					<td>status :</td>
					<td><textarea name="status">${tache.status}</textarea></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="hidden" name="idTache" value="${param.idTache }" class="input-bouton">
						<input type="hidden" name="idUserStory" value="${param.idUserStory }" class="input-bouton">
						<input type="hidden" name="idProjet" value="${param.idProjet }" class="input-bouton">
						<input type="hidden" name="idSprint" value="${param.idSprint }" class="input-bouton">
						
						<input type="submit" value="Modifier" class="input-bouton" />
						<input type="reset" value="Effacer" class="input-bouton" /></td>
				</tr>
			</table>
		</form>


	</div>

	<br>
	<br>
	<br>
	<form action="deconnexion" method="post">
		<input type="submit" value="deconnexion" name="action"
			class="input-bouton" />
	</form>
	<br>
	<br>
	<br>
    <footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer> 


</body>
</html>