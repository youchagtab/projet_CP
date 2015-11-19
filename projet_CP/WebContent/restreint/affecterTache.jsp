<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="./css/menus.css">
<title>Affectation</title>
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
	<div class="div-conteneur" id="div-ajoutTache">
		<h3>Affecter la tâche : </h3>


		<form action="AffectationTache" method="post">
			<table class="table1">
				<tr>
					<td>Tâche :</td>
					<td>
						<c:out value="${tache.description}"/>
					</td>
				</tr>
				<tr>
					<td>Développeur :</td>
					<td>
						<select name="idUtilisateur">
							<c:forEach var="developpeur" items="${developpeurs}">
								<option value="${developpeur.idUtilisateur }">${developpeur.nom } ${developpeur.prenom }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Debut :</td>
					<td><input type="text" name="debut"/></td>
				</tr>
				<tr>
					<td>Durée :</td>
					<td><input type="text" name="duree"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="idSprint" value="${param.idSprint}" class="input-bouton"> 
						<input type="hidden" name="idTache" value="${param.idTache}" class="input-bouton"> 
						<input type="hidden" name="idProjet" value="${param.idProjet}" class="input-bouton"> 
						<input type="submit" value="Affecter" class="input-bouton" /> 
						<input type="reset" value="Effacer" class="input-bouton" /></td>
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
	<footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer> 
	

</body>
</html>