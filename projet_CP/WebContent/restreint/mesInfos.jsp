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
<title>mes infos</title>

</head>
<body>


	<%@ include file="header.jsp"%>

	<br>
	<br>
	<br>
	<br>



	<div class="div-conteneur" id="div-Collabs">

		<h3>MES INFORMATIONS</h3>
		<form action="ModifierInfos" method="post">
			<table class="table1">
				<tr>
					<td>Prenom :</td>
					<td><input type="text" name="prenom"
						value="${utilisateur.prenom }" class="input-bouton" required="Veuillez compléter ce champ" /></td>
				</tr>
				<tr>
					<td>nom :</td>
					<td><input type="text" name="nom" value="${utilisateur.nom }"
						class="input-bouton"  required="Veuillez compléter ce champ"/></td>
				</tr>
				<tr>
					<td>mot de passe :</td>
					<td><input type="password" name="motDePasse"
						value="${utilisateur.motDePasse}" class="input-bouton" required="Veuillez compléter ce champ" /></td>
				</tr>

			</table>
            <br>
            <input type="hidden" name="idUtilisateur"
						value="${utilisateur.idUtilisateur }" class="input-bouton">
		    <input type="hidden" name="identifiant"
						value="${utilisateur.identifiant }" class="input-bouton">
			<input type="submit" value="Modifier" class="input-bouton" /> &nbsp;
			<input type="reset" value="Effacer" class="input-bouton" />
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