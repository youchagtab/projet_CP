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
		<aside id="tete-aside" class="aside-conteneur">
			Bienvenu ${utilisateur.nom} ${utilisateur.prenom}&nbsp;
			<aside id="tete-menus"  class="aside-conteneur">
				<ul>
					<li><a href="#" id="menu-ppale" class="menu-ppale">__</a>
					
						<ul>
							<li><a href="#" class="menu-ppale">Mes infos</a></li>
							<li><a href="#" class="menu-ppale">Mes groupes</a></li>
							<li><a href="#" class="menu-ppale">Historique</a></li>
							<li><form action="deconnexion" method="post">
									<input type="submit" value="deconnexion" name="action" id="input-menuDeconnexion" class="input-bouton"/>
								</form></li>
						</ul></li>
				</ul>
			</aside>
		</aside>

	</header>
	<nav id="barre-menus" class="nav-conteneur">
		<ul>
			<li><a href="accueil.jsp" class="menu-horizontale">accueil</a></li>
			<li><a href="../restreint/ajouterprojet.jsp" class="menu-horizontale">ajouter un projet</a></li>
			<li><a href="../restreint/contacts.jsp" class="menu-horizontale">contact  </a></li>
		</ul>
	</nav>
	<div>
		<h2>Projet : <c:out value="${projet.description}"/></h2>
		<h2>Tâche : <c:out value="${tache.description}"/></h2>
		<table class="table1">
			<tr>
				<td class="thprojet">Liste des tâches</td>
				<td class="thprojet">Dependances</td>
			</tr>
			<tr>
				<!-- Form ajouter tâches to dependance liste -->
				<td>
					<form action="DependanceEntreTaches" method="get">
						<c:forEach var="p" items="${ Taches }">
							<p><input type="checkbox" name="tachescheckbox" value="${ p.idTache}" />&nbsp;${ p.description }</p>
						</c:forEach>
						<p><input type="submit" value=">>>>>"/></p>
						<input type="hidden" value="${param.idUS}" name="idUS"/></p>
					</form>
				</td>
				<!-- Form supprimer tâches from dependance liste -->
				<td>
					<form action="SupprimerDependanceEntreTaches" method="post">
						<c:forEach var="p" items="${ TachesUserStory }">
						<p><input type="checkbox" name="tachescheckbox" value="${ p.idTache}" />&nbsp;${ p.description }</p>
					    </c:forEach>
						<p><input type="submit" value="<<<<<"/></p>
					</form>
				</td>
			</tr>
		</table>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	    <br> <br><br><br><br><br><br>
	
	
	<footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer>
</body>
</html>