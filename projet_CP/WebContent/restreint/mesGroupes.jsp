<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/projet.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>mes groupes</title>

</head>
<body>


	<%@ include file="header.jsp"%>

	<br>
	<br>
	<br>
	<br>

	<div class="div-conteneur" id="div-Collabs">
		<ul>
			<c:forEach var="projet" items="${projets}"
				begin="0" end="${fn:length(projets)}" varStatus="status">
				<li>
				    <p2>PROJET :<c:out value="${projet.noms }" /> </p2> 
					<ul>
						<c:forEach var="collaborateur" items="${collaborateurs[(status.count)-1] }">

							<li>${ collaborateur.prenom }&nbsp;${ collaborateur.nom }</li>

						</c:forEach>
					</ul>
				</li><br><br>
			</c:forEach>

		</ul>

	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<%@ include file="footer.jsp"%>
</body>
</html>