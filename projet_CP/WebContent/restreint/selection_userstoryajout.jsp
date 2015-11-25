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

	
		<%@ include file="header.jsp" %>

	


	<br />
	<div class="div-conteneur" id="div-ajoutUSSprint">
		<h3>Ajouter "User Story" au sprint</h3>

        <table class="table1">
			<tr>
				<td class="thprojet">Liste des tâches</td>
				<td class="thprojet">Tâches dans le sprint</td>
			</tr>
			<tr>
				<!-- Form ajouter us au sprint -->
				<td>
					<form action="#" method="post">
						<p> u s à ajouter 1 <input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p>u s à ajouter 2 <input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p>u s à ajouter 3<input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p>u s à ajouter 4 <input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p>u s à ajouter 5<input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p><input type="submit" value=">>>>>"/></p>
					</form>
				</td>
				<!-- Form supprimer us du sprint -->
				<td>
					<form action="#" method="post">
						<p>u s 1  déjà dans le sprint  <input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p>u s 2  déjà dans le sprint <input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p>u s 3  déjà dans le sprint <input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p>u s 4  déjà dans le sprint  <input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p>u s 5  déjà dans le sprint  <input type="checkbox" name="userStories" value="<c:out value="userStory.idUS"/>"/></p>
						<p><input type="submit" value="<<<<<"/></p>
					</form>
				</td>
			</tr>
		</table>

		<!--  <form action="AjouterUserStorySprint" method="post" id="liste-us">
			<ul>
				<c:forEach var="userStory" items="${ userStories }">
					<li><INPUT type="checkbox" name="selectionUS"
						value="${userStory}">${userStory}</li>
				</c:forEach>
			</ul>

			<input type="submit" value="Valider" />

		</form> -->
		
	<br><br>

	<a href="AjouterUserStory?idSprint=${sprint.idSprint}" class="menu-ppale">Ajouter une
		nouvelle US au sprint</a>
	<br>
		
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