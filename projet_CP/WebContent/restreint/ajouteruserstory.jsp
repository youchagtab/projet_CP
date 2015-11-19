<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>user story</title>
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
	<div class="div-conteneur" id="div-ajoutUSProjet">
		<h3>Ajouter "User Story"</h3>


		<form action="AjouterUserStory" method="post">
			<table class="table1">
				<tr>
					<td>Description :</td>
					<td><textarea name="description"></textarea></td>
				</tr>



				<tr>
					<td>Difficulté :</td>
					<td><input type="text" name="difficulte" class="input-bouton" /></td>
				</tr>

				<tr>
					<td>Priorité :</td>
					<td><input type="text" name="priorite" class="input-bouton" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="idProjet"
						value="${param.idProjet }" class="input-bouton"> <input
						type="submit" value="Ajouter" class="input-bouton" /> <input
						type="reset" value="Effacer" class="input-bouton" /></td>
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