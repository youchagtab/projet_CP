<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
<link rel="stylesheet" type="text/css" href="style_acceuil.css">

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
		<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" />
		<aside>Bienvenu ${utilisateur.nom}
			${utilisateur.prenom}</aside>
	</header>
	<br>
	<br>
	<br>

	<div>
		&nbsp;<a href="AjouterProjet">Ajouter</a>
 		<table class="table1">
			<tr>
				<th id="thprojet">PROJET</th>
				<th id="thdescription">DESCRIPTION</th>
				<th id="thactions">Actions</th>
			</tr>
			<c:forEach items="${model.projets}" var="p">
				<tr>

					<td>${p.noms}</td>
					<td>${p.description}</td>
					<td><a href="Projet?idProjet=${p.idProjet }">Afficher</a>
					<a
						href="javascript:confirmer('acceuil?action=delete&ref=${p.idProjet}&refUtil=${utilisateur.idUtilisateur}')">Se retirer
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="deconnexion" method="post">
		<input type="submit" value="deconnexion" name="action" />
	</form>
	<br>
	<br>
	<br>
	<dv> <footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer> </dv>
</body>
</html>