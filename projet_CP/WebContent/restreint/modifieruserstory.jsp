<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style_acceuil.css">
<title>Insert title here</title>
</head>
<body>
		<h3>Bienvenue Monsieur ${utilisateur.nom} ${utilisateur.prenom}</h3>
		<br/>
		<h3>Modifier "User Story"</h3>
		<form action="ModifierUserStory" method="post">
			<table class="table1">
				<tr>
					<td>Description : </td>
					<td><textarea name="description">${userStory.description }</textarea></td>
				</tr>
					<td>Difficult� : </td>
					<td><input type="text" name="difficulte" value="${userStory.difficulte}"/></td>
				<tr>
					<td>Priorit� : </td>
					<td><input type="text" name="priorite" value="${userStory.priorite}"/></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="idUserStory" value="${param.idUserStory }">
						<input type="hidden" name="idProjet" value="${param.idProjet }">
						<input type="submit" value="Modifier"/>
						<input type="reset" value="Effacer"/>
					</td>
				</tr>
			</table>
		</form>
		<br>
	<br>
	<br>
		<form action="deconnexion" method="post">
		<input type="submit" value="deconnexion" name="action" />
	</form>
	<br>
	<br>
	<br>
	<dv> <footer> outil de de gestion de projet r�alis� dans
		le cadre du module Conduite de projet </footer> </dv>
		<br/>
</body>
</html>