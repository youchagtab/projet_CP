<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajouter commit</title>
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
</head>
<body>
<%@ include file="header.jsp" %>



<br />
	<div class="div-conteneur" id="div-ajoutProjet">
		<h3>Ajouter un commit</h3>
		<c:out value="${erreur}" />
		<form action="AjouterCommit" method="post">
			<table class="table1">
				<tr>
					<td>NUMERO :</td>
					<td><input type="text" name="numero" class="input-bouton" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><textarea name="description"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="idTache" value="${param.idTache}"/>
					    <input type="hidden" name="idProjet" value="${param.idProjet}"/>
						<input type="submit" value="Ajouter" class="input-bouton" />
						<input type="reset" value="Effacer	"></td>
				</tr>
			</table>
		</form>
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