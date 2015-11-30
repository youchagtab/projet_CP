<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">  
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
	
<%@ include file="header.jsp" %>




	<br>
	<br>
	<br>

	<div class="div-conteneur" id="div-accueil">
		&nbsp;<a href="AjouterProjet" role="button" class="btn btn-primary btn-large">Ajouter un projet</a> <br/> <br/>
		<table class="table1">
			<tr>
				<th class="thprojet">PROJET</th>
				<th class="thprojet">DESCRIPTION</th>
				<th class="thprojet">REPERTOIRE GITHUB</th>
				<th class="thprojet">Actions</th>
			</tr>
			<c:forEach items="${model.projets}" var="p">
				<tr>

					<td>${p.noms}</td>
					<td>${p.description}</td>
					<td>${p.repertoireGitHub}</td>
					<td><a href="Projet?idProjet=${p.idProjet }" role="button"  class="btn btn-success btn-large">Afficher</a> <a
						href="javascript:confirmer('acceuil?action=delete&ref=${p.idProjet}&refUtil=${utilisateur.idUtilisateur}')" class="btn btn-warning btn-large">Se
					
					
				</tr>
			</c:forEach>
		</table>
	</div>

    <br> <br><br><br><br><br><br>
    
    <%@ include file="footer.jsp" %>

</body>
</html>