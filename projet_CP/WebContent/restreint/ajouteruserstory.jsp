<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style_acceuil.css">
<link rel="stylesheet" type="text/css" href="menus.css">
<title>user story</title>
</head>
<body>

	<header>

		<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" />
		<aside>Bienvenu ${utilisateur.nom} ${utilisateur.prenom}</aside>
	</header>
	<nav>
		<ul>
			<li><a href="accueil.jsp">accueil</a></li>
			<li><a href="ajouterprojet.jsp">ajouter un projet</a></li>
			<li><a href="contacts.jsp">contact </a></li>
		</ul>
	</nav>

	<br />
	<div>
		<h3>Ajouter "User Story"</h3>


		<form action="AjouterUserStory" method="post">
			<table class="table1">
				<tr>
					<td>Description :</td>
					<td><textarea name="description"></textarea></td>
				</tr>

			

				<tr>
					<td>Difficulté : </td>
					<td><input type="text" name="difficulte"/></td>
				</tr>

				<tr>
					<td>Priorité :</td>
					<td><input type="text" name="priorite" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="idProjet"
						value="${param.idProjet }"> <input type="submit"
						value="Ajouter" /> <input type="reset" value="Effacer" /></td>
				</tr>
			</table>
		</form>

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
	<dv> <footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer> </dv>
		<br/>

</body>
</html>