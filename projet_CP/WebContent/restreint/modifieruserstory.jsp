<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>modification du user story</title>
</head>
<body>

	
		<%@ include file="header.jsp" %>

	

	<br />

	<div class="div-conteneur" id="div-modifUS">
		<h3>Modifier la tache :</h3>
		<form action="ModifierUserStory" method="post">
			<table class="table1">
				<tr>
					<td>Description :</td>
					<td><textarea name="description">${userStory.description }</textarea></td>
				</tr>
				<td>Difficulté :</td>
				<td><input type="text" name="difficulte"
					value="${userStory.difficulte}" class="input-bouton" /></td>
				<tr>
					<td>Priorité :</td>
					<td><input type="text" name="priorite"
						value="${userStory.priorite}" class="input-bouton" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="idUserStory"
						value="${param.idUserStory }" class="input-bouton"> <input
						type="hidden" name="idProjet" value="${param.idProjet }"
						class="input-bouton"> <input type="submit"
						value="Modifier" class="input-bouton" /> <input type="reset"
						value="Effacer" class="input-bouton" /></td>
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