<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<link rel="stylesheet" type="text/css" href="style_acceuil.css">
<link rel="stylesheet" type="text/css" href="projet.css">
<link rel="stylesheet" type="text/css" href="menus.css">
<title>projet</title>
</head>
<body>

	<header>

		<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" />
		<aside>Bienvenu ${utilisateur.nom} ${utilisateur.prenom}</aside>
	</header>
	<nav>
		<ul>
			<li><a href="restreint/accueil.jsp">accueil</a></li>
			<li><a href="restreint/ajouterprojet.jsp">ajouter un projet</a></li>
			<li><a href="restreint/contacts.jsp">contact </a></li>
		</ul>
	</nav>
	<div>
		<h2>Projet : <c:out value="${projet.description}"/></h2>
		<h2>Tâche : <c:out value="${tache.description}"/></h2>
		<table class="table1">
			<tr>
				<td>Liste des tâches</td>
				<td>Dependances</td>
			</tr>
			<tr>
				<!-- Form ajouter tâches to dependance liste -->
				<td>
					<form actione="#" method="post">
						<p>Tâche 1 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p>Tâche 2 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p>Tâche 3 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p>Tâche 4 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p>Tâche 5 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p><input type="submit" value=">>>>>"/></p>
					</form>
				</td>
				<!-- Form supprimer tâches from dependance liste -->
				<td>
					<form actione="#" method="post">
						<p>Tâche 1 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p>Tâche 2 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p>Tâche 3 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p>Tâche 4 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p>Tâche 5 <input type="checkbox" name="taches" value="<c:out value="tache.idTache"/>"/></p>
						<p><input type="submit" value="<<<<<"/></p>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>