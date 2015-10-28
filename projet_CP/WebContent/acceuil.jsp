<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
<link rel="stylesheet" type="text/css" href="style_acceuil.css">
<script type="text/javascript">
	function confirmer(url) {
		var repo = confirm("etes vous sure de vouloir supprimer ce projet?");
		if (repo == true) {
			document.location = url;
		}
	}
</script>
</head>
<body>

	<h3>bienvenue Monsieur ${utilisateur.nom} ${utilisateur.prenom}</h3>

	<div>
		<form action="acceuil" method="post">
			<table>
				<tr>
					<td>Mot clé:</td>
					<td><input type="text" name="motCle" /></td>
					<td><input type="submit" value="chercher" name="action" /></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<table class="table1">
			<tr>
				<th>PROJET</th>
				<th>DESCRIPTION</th>
			</tr>
			<c:forEach items="${model.projets}" var="p">
				<tr>

					<td>${p.noms}</td>
					<td>${p.description}</td>
					<td><a href="userstory.jsp">Afficher</a></td>
					<td><a href="javascript:confirmer('acceuil?action=delete&ref=${p.idProjet}')">Supprimer </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="deconnexion" method="post">
		<input type="submit" value="deconnexion" name="action" />
	</form>
</body>
</html>