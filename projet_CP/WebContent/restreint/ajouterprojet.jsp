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
		<h3>Ajouter un nouveau projet</h3>
		<form action="AjouterProjet" method="post">
			<table class="table1">
				<tr>
					<td>Nom : </td>
					<td><input type="text" name="noms"/></td>		
				</tr>
				<tr>
					<td>Description : </td>
					<td><textarea name="description"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ajouter"/>
						<input type="reset" value="Effacer	">
					</td>
				</tr>
			</table>
</body>
</html>