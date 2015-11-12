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
</head>
<body>

	<header>

		<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" />
		<aside>Bienvenu ${utilisateur.nom} ${utilisateur.prenom}</aside>
	</header>
	<nav>
		<ul>
			<li><a href="restreint/accueil.jsp">accueil</a></li>
			<li><a href="restreint/ajouterprojet.jsp">ajouter un projet</a></li>
			<li><a href="restreint/contacts.jsp">contact </a></li>
		</ul>
	</nav>
	<div>


		<table class="table1">
			<tr>
				<td><strong> Liste des UserStories</strong></td>

			</tr>



			<form action="AjouterUserStorySprint" method="post">
				<c:forEach var="p" items="${ userStories }">
					<tr>
						<td>${ p.description }<input type="checkbox"
							name="userstories" value="p.idUS" />
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td>
						<p>
							<input type="submit" value="Ajouter" />
						</p>
					</td>
				</tr>
			</form>



		</table>



		<!--
			 <table class="table1">
				<tr>
					<td>Liste des UserStories</td>
				</tr>
				<c:forEach var="p" items="${ userStories }">
					<tr>
						<td> ${ p.description } <input type="checkbox"
							name="userstories" value="p.idUS" /></td>		
					</tr>
				</c:forEach>
				<tr>
				    <td><a
							href="AjouterUserStorySprint?idUserStory=${userStory.idUS}&idProjet=${projet.idProjet}&idSprint=${sprint.idSprint}">
								Ajouter </a>
				    </td>

				    
				</tr>    
			</table>
			    -->

		<!--
				   <td>
				 	   <form action="AjouterUserStorySprint" method="post">
		                   <input type="submit" value="Ajouter" name="action" />
	                    </form>
	                </td>
	                -->

	</div>
</body>
</html>