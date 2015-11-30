<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="./css/menus.css">
<title>Affectation</title>
</head>
<body>

	<%@ include file="header.jsp"%>


	<br />
	<div class="div-conteneur" id="div-ajoutTache">
		<h3>Affectation :</h3>
		

		<table class="table1">
			<tr>
				<th>Gantt Prévisionnel</th>
				<th></th>
				<th>Gantt Effectif</th>
			</tr>
			<tr>
				<td>
					<!-- GANTT PREVISIONELLE -->
					<form action="AffectationTache" method="post">
						<table class="table1">
							<tr>
								<td>Tâche :</td>
								<td><c:out value="${tache.description}" /></td>
							</tr>
							<tr>
								<td>Développeur :</td>
								<td><select name="idUtilisateur">
										<c:forEach var="developpeur" items="${developpeurs}">
											<option value="${developpeur.idUtilisateur }">${developpeur.nom }
												${developpeur.prenom }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>Debut :</td>
								<td><input type="text" name="debut" /></td>
							</tr>
							<tr>
								<td>Durée :</td>
								<td><input type="text" name="duree" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="hidden" name="idSprint"
									value="${param.idSprint}" class="input-bouton"> <input
									type="hidden" name="idTache" value="${param.idTache}"
									class="input-bouton"> <input type="hidden"
									name="idProjet" value="${param.idProjet}" class="input-bouton">
									<input type="submit" value="Affecter" class="input-bouton" />
									<input type="reset" value="Effacer" class="input-bouton" /></td>
							</tr>
						</table>
					</form>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					<!-- GANTT EFFECTIF -->
					<form action="AffectationTacheEff" method="post">
						<table>
							<tr>
								<td>Tâche :</td>
								<td><c:out value="${tache.description}" /></td>
							</tr>
							<tr>
								<td>Développeur :</td>
								<td><select name="idUtilisateur">
										<c:forEach var="developpeur" items="${developpeurs}">
											<option value="${developpeur.idUtilisateur }">${developpeur.nom }
												${developpeur.prenom }</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td>Debut :</td>
								<td><input type="text" name="debut" /></td>
							</tr>
							<tr>
								<td>Durée :</td>
								<td><input type="text" name="duree" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="hidden" name="idSprint"
									value="${param.idSprint}" class="input-bouton"> <input
									type="hidden" name="idTache" value="${param.idTache}"
									class="input-bouton"> <input type="hidden"
									name="idProjet" value="${param.idProjet}" class="input-bouton">
									<input type="submit" value="Affecter" class="input-bouton" />
									<input type="reset" value="Effacer" class="input-bouton" /></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>

	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<%@ include file="footer.jsp"%>

</body>
</html>