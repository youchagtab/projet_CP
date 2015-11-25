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

	
		<%@ include file="header.jsp" %>


	<br />
	<div class="div-conteneur" id="div-ajoutTache">
		<h3>Ajouter une tâche</h3>


		<form action="/projet_CP/AjouterTache" method="post">
			<table class="table1">
				<tr>
					<td>Description :</td>
					<td>
						<textarea name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td>Tag :</td>
					<td><input type="text" name="tag"/></td>
				</tr>
				<tr>
					<td>Coût :</td>
					<td><input type="text" name="cout"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="idUserStory" value="${param.idUS}" class="input-bouton"> 
						<input type="hidden" name="idSprint" value="${param.idSprint}" class="input-bouton"> 
						<input type="hidden" name="idProjet" value="${param.idProjet}" class="input-bouton"> 
						<input type="submit" value="Ajouter" class="input-bouton" /> 
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