<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>sprint</title>
</head>
<body>

	<header>
		<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" />
		<aside>
			Bienvenu ${utilisateur.nom} ${utilisateur.prenom}&nbsp;
			<aside id="tete-menus" class="tete-menus">
				<ul>
					<li><a href="#" id="menu-ppale"  class="menu-ppale">__</a>

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

		<h2>
			sprint
			<!--  <c:out value="${ sprint.numero }" />  -->
		</h2>


		<a href="AjouterUserStorySprint">Ajouter une US</a> <br>

		<table class="table1">
			<tr>
				<th>USER STORY</th>
				<th>TACHES</th>
			</tr>
			<c:forEach var="userStory" items="${userStories}">
				<tr>
					<td><c:out value="${userStory.key}" /></td>
					<td><a href="restreint/ajoutertache.jsp">
							<button>ajouter une tache</button>
					</a>

						<ul>
							<c:forEach var="tache" items="${userStory.value}">
								<li><c:out value="${tache}" /> &nbsp;
									<aside id="taches-menus" class="tete-menus" >
										<ul>
											<li><a href="#" id="menu-tache" class="menu-ppale">__</a>

												<ul>
													<li><a href="#">Modifier</a></li>
													<li><a href="#">Supprimer</a></li>
												</ul></li>
										</ul>
									</aside></li>
							</c:forEach>
						</ul></td>
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
	<dv> <footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer> </dv>
	<br />

</body>
</html>