<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
</head>
<body>

	<%@ include file="header.jsp"%>

	<br />
	<div class="div-conteneur" id="div-sprint">
		<h2>
			Sprint ${ sprint.numero }
			<!--  <c:out value="${ sprint.numero }" />  -->

		</h2>
		<c:if test="${Ganttexist == true}">
    
	Gantt <br />
			<table class="table1">
				<tr>
					<td class="thprojet">Developeur</td>
					<c:forEach begin="0" end="${maxdate-1}" var="val">
						<td class="thprojet"><c:out value="${val}" /></td>
					</c:forEach>
				<tr />
				<c:forEach var="utilisateur" items="${ collaborateurs }">
					<tr>
						<td>${ utilisateur.getNom()}</td>
						<c:forEach begin="0" end="${maxdate-1}" var="val">
							<c:if test="${val==0}">
								<td
									colspan="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val].getDuree() }">
									<c:out
										value="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val].getTag()}" />
								</td>
							</c:if>
							<c:if test="${val!=0}">
								<c:if
									test="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val] != GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val-1]}">
									<td
										colspan="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val].getDuree() }">
										<c:out
											value="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val].getTag()}" />
									</td>
								</c:if>
							</c:if>

						</c:forEach>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<%@ include file="footer.jsp"%>
	
</body>

</html>