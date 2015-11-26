<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>Ajouter un collaborateur</title>
</head>
<body>


	<%@ include file="header.jsp"%>






	<br />
	<div class="div-conteneur" id="div-ajoutCollaborateur">
		<h3>Ajouter un collaborateur</h3>

		<table class="table1">
			<tr>
				<td class="thprojet">Liste des Utilisateurs</td>
				<td class="thprojet">Collaborateurs du projet</td>
			</tr>
			<tr>
				<!-- Form ajouter un utilisateur au projet -->
				<td>
					<form action="AjouterCollaborateurs?idProjet=${projet.idProjet}"
						method="post">
						<c:forEach var="utilisateur" items="${utilisateurs}">

							<p>
								<c:out value="${utilisateur.nom}" />
								<input type="checkbox" name="ajoutUtilisateurs"
									value="<c:out value="${utilisateur.idUtilisateur}"/>" />
							</p>
						</c:forEach>
						<p>
							<input type="submit" value=">>>>>" />
						</p>
					</form>
				</td>
				<!-- Form supprimer utilisateur du du projet -->
				<td>
					<form action="SupprimerCollaborateurs?idProjet=${projet.idProjet}"
						method="post">
						<c:forEach var="collaborateur" items="${collaborateurs}">
							<p>
								<c:out value="${collaborateur.nom}" />
								<input type="checkbox" name="ajoutCollaborateurs"
									value="<c:out value="${collaborateur.idUtilisateur}"/>" />
							</p>
						</c:forEach>
						<p>
							<input type="submit" value="<<<<<" /></p>
					</form>
				</td>
			</tr>
		</table>


		<br>
		<br>

	</div>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<%@ include file="footer.jsp" %>
	

</body>
</html>