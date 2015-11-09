<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="../css/menus.css">
<title>user story</title>
</head>
<body>

	<header>
		<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" />
		<aside>
			Bienvenu ${utilisateur.nom} ${utilisateur.prenom}&nbsp;
			<aside id="tete-menus" class="tete-menus">
				<ul>
					<li><a href="#" id="menu-ppale" class="menu-ppale">__</a>

						<ul>
							<li><a href="#">Mes infos</a></li>
							<li><a href="#">Mes groupes</a></li>
							<li><a href="#">Historique</a></li>
							<li><form action="deconnexion" method="post">
									<input type="submit" value="deconnexion" name="action" />
								</form></li>
						</ul></li>
				</ul>
			</aside>
		</aside>

	</header>
	<nav id="barre-menus">
		<ul>
			<li><a href="accueil.jsp">accueil</a></li>
			<li><a href="ajouterprojet.jsp">ajouter un projet</a></li>
			<li><a href="contacts.jsp">contact </a></li>
		</ul>
	</nav>

	<br />
	<div>
		<h3>Ajouter une tâche</h3>


		<form action="AjouterUneTache" method="post">
			<table class="table1">
				<tr>
					<td>Description :</td>
					<td><textarea name="description"></textarea></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="hidden" name="idUserStory"
						value="${param.idUserStory }"> <input type="submit"
						value="Ajouter" /> <input type="reset" value="Effacer" /></td>
				</tr>
			</table>
		</form>

	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<dv> <footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer> </dv>
	<br />

</body>
</html>