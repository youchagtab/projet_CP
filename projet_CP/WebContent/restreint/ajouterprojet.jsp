<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style_acceuil.css">
<link rel="stylesheet" type="text/css" href="menus.css">
<title>Insert title here</title>
</head>
<body>
	<header>

		<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" />
		<aside>Bienvenu ${utilisateur.nom} ${utilisateur.prenom}</aside>

	</header>
	<nav>
		<ul>
			<li><a href="accueil.jsp">accueil</a></li>
			<li><a href="ajouterprojet.jsp">ajouter un projet</a></li>
			<li><a href="contacts.jsp">contact </a></li>
		</ul>
	</nav>
	<br />
	<div>
		<h3>Ajouter un nouveau projet</h3>
		<form action="AjouterProjet" method="post">
			<table class="table1">
				<tr>
					<td>Nom :</td>
					<td><input type="text" name="noms" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><textarea name="description"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Ajouter" /> <input
						type="reset" value="Effacer	"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>