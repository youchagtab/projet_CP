<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/projet.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>projet</title>
</head>
<body>


	<%@ include file="header.jsp"%>

	<div class="div-conteneur" >

		<h2>T�che : ${tache.description}</h2>
		<table class="table1">
			<tr>
				<td class="thprojet">Liste des t�ches</td>
				<td class="thprojet">Dependances</td>
			</tr>
			<tr>
				<!-- Form ajouter t�ches to dependance liste -->
				<td>
					<form action="DependanceEntreTaches" method="post">
						<c:forEach var="p" items="${taches}">
							<p>
								<input type="checkbox" name="tachescheckbox"
									value="${p.idTache}" />&nbsp;${ p.description }
							</p>
						</c:forEach>
						<p>
							<input type="submit" value=">>>>>" />
						</p>
						<input type="hidden" value="${param.idSprint}" name="idSprint" />
						</p>
						<input type="hidden" value="${param.idTache}" name="idTache" />
						</p>
					</form>
				</td>
				<!-- Form supprimer t�ches from dependance liste -->
				<td>
					<form action="SupprimerDependanceEntreTaches" method="post">
						<c:forEach var="p" items="${ tachesDep}">
							<p>
								<input type="checkbox" name="tachescheckbox"
									value="${ p.idTache}" />&nbsp;${ p.description }
							</p>
						</c:forEach>
						<p>
							<input type="submit" value="<<<<<" /></p>
						<input type="hidden" value="${param.idSprint}" name="idSprint" />
						<input type="hidden" value="${param.idTache}" name="idTache" />
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


	 <%@ include file="footer.jsp" %>
</body>
</html>