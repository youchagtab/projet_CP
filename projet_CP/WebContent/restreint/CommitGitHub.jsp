<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css"> 
<link rel="stylesheet" type="text/css" href="css/menus.css">  

</head>
<body>
	
<%@ include file="header.jsp" %>


	<br>
	<strong>COMMIT DU GITHUB: </strong>
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