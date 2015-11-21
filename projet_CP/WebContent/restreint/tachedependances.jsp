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
		<%@ include file="header.jsp" %>
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
					<form action="DependanceEntreTaches" method="post">
						<c:forEach var="p" items="${taches}">
							<p><input type="checkbox" name="tachescheckbox" value="${p.idTache}" />&nbsp;${ p.description }</p>
						</c:forEach>
						<p><input type="submit" value=">>>>>"/></p>
						<input type="hidden" value="${param.idSprint}" name="idSprint"/></p>
						<input type="hidden" value="${param.idTache}" name="idTache"/></p>
					</form>
				</td>
				<!-- Form supprimer tâches from dependance liste -->
				<td>
					<form action="SupprimerDependanceEntreTaches" method="post">
						<c:forEach var="p" items="${ tachesDep}">
						<p><input type="checkbox" name="tachescheckbox" value="${ p.idTache}" />&nbsp;${ p.description }</p>
					    </c:forEach>
						<p><input type="submit" value="<<<<<"/></p>
						<input type="hidden" value="${param.idSprint}" name="idSprint"/>
						<input type="hidden" value="${param.idTache}" name="idTache"/>
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