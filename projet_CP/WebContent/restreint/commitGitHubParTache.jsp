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
<br>
	<strong>COMMIT DU GITHUB: </strong> de format Tag_de_la_tache : message
	<br>
	<br>

		<table class="table1">
			<tr>
				<th class="thprojet">ID</th>
				<th class="thprojet">DATE</th>
				<th class="thprojet">AUTHEUR</th>
				<th class="thprojet">MESSAGE</th>
				
			</tr>
			<c:forEach items="${commits}" var="c">
				<tr>
					<td>${c.getSHA1()}</td>
					<td>${c.getCommitShortInfo().getAuthor().getDate()}</td>
					<td>${c.getCommitShortInfo().getAuthor().getName()}</td>
					<td>${c.getCommitShortInfo().getMessage()}</td>
				</tr>
			</c:forEach>
		</table>

    <br> <br><br><br><br><br><br>
    
    <%@ include file="footer.jsp" %>







</body>
</html>