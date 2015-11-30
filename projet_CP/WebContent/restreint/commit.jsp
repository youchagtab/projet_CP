<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page des commit</title>
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
</head>
<body>

<%@ include file="header.jsp" %>


<br>
	<br>
	<br>

	<div class="div-conteneur" id="div-accueil">
		&nbsp;<a href="AjouterCommit?idTache=${idTache}" class="menu-ppale">Ajouter un Commit</a> <br/> <br/>
		<table class="table1">
			<tr>
				<th class="thprojet">ID</th>
				<th class="thprojet">DESCRIPTION</th>
				
			</tr>
			<c:forEach items="${commits}" var="p">
				<tr>

					<td>${p.numero}</td>
					<td>${p.description}</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>

    <br> <br><br><br><br><br><br>
    
    <%@ include file="footer.jsp" %>







</body>
</html>