<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css"> 
<link rel="stylesheet" type="text/css" href="css/menus.css">  

<script type="text/javascript">
	function confirmer(url) {
		var repo = confirm("Etez-vous sûrs de vouloir vous retirer de ce projet?");
		if (repo == true) {
			document.location = url;
		}
	}
</script>

</head>
<body>
	<header>
		<%@ include file="header.jsp" %>

	</header>
	<nav id="barre-menus" class="nav-conteneur">
		<ul>
			<li><a href="../restreint/ajouterprojet.jsp" class="menu-horizontale">ajouter un projet</a></li>
			<li><a href="../restreint/contacts.jsp" class="menu-horizontale">contact  </a></li>
		</ul>
	</nav>

	<br>
	<br>
	<br>

	<div class="div-conteneur" id="div-accueil">
		&nbsp;<a href="AjouterProjet" class="menu-ppale">Ajouter un projet</a> <br/> <br/>
		<table class="table1">
			<tr>
				<th class="thprojet">PROJET</th>
				<th class="thprojet">DESCRIPTION</th>
				<th class="thprojet">Actions</th>
			</tr>
			<c:forEach items="${model.projets}" var="p">
				<tr>

					<td>${p.noms}</td>
					<td>${p.description}</td>
					<td><a href="Projet?idProjet=${p.idProjet }" class="menu-ppale">Afficher</a> <a
						href="javascript:confirmer('acceuil?action=delete&ref=${p.idProjet}&refUtil=${utilisateur.idUtilisateur}')" class="menu-ppale">Se
							retirer </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="deconnexion" method="post">
		<input type="submit" value="deconnexion" name="action" id="input-deconnexion" class="input-bouton"/>
	</form>
    <br> <br><br><br><br><br><br>
	
	
	<footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer>
</body>
</html>