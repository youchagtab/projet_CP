<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<link rel="import" href="entete.jsp" />
<title>Insert title here</title>
</head>
<body>

		<%@ include file="header.jsp" %>

	<br />
	<div class="div-conteneur" id="div-ajoutProjet">
		<h3>Ajouter un nouveau projet</h3>
		<form action="AjouterProjet" method="post">
			<table class="table1">
				<tr>
					<td>Nom :</td>
					<td><input type="text" name="noms" class="input-bouton" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><textarea name="description"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Ajouter" class="input-bouton" />
						<input type="reset" value="Effacer	"></td>
				</tr>
			</table>
		</form>
	</div>
	    <br> <br><br><br><br><br><br>
	
	
	<footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer>
</body>
</html>