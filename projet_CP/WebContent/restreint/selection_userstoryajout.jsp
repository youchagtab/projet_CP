<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>selection user story</title>
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
		<h3>Ajouter "User Story" au sprint</h3>


		<form action="AjouterUserStorySprint" method="post" id="liste-us">
			<ul>
				<c:forEach var="userStory" items="${ userStories }">
					<li><INPUT type="checkbox" name="selectionUS"
						value="${userStory}">${userStory}</li>
				</c:forEach>
			</ul>

			<input type="submit" value="Valider" />

		</form>
	</div>

	<br>

	<a href="AjouterUserStory?idSprint=${sprint.idSprint}">Ajouter une
		nouvelle US au sprint</a>
	<br>

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