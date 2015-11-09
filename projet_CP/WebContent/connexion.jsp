<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/erreurs.css" />
<link type="text/css" rel="stylesheet" href="css/style_connexion.css" />
</head>
<body>

	<dv> <header>
	<h1>Gérez vos projets avec SCRUM</h1>
	</header> </dv>

	<br>
	<br>

	<di class="autourConnexion"> <br>

	<div class="msg-erreurs">
		<c:out value="${requestScope.erreur }" />
	</div>


	<form method="post" action="Connexion">
		<fieldset id="Field">
			<legend>Connexion</legend>

			<!--  <label for="identifiant">Identifiant <span class="requis"></span></label> -->
			<input type="text" id="identifiant" name="identifiant" value=""
				size="20" maxlength="60" placeholder="identifiant"
				required="Veuillez compléter ce champ" /> <br />

			<!--  <label for="motdepasse">Mot de passe <span class="requis"></span></label>  -->
			<input type="password" id="motdepasse" name="motdepasse" value=""
				size="20" maxlength="20" placeholder="mot de passe"
				required="Veuillez compléter ce champ" /> <br /> <input
				type="submit" value="Connexion" class="sansLabel" /> <br />
		</fieldset>

		<br>



	</form>



	</di>

	<a type="submit" href="inscription.jsp" class="sansLabel"><button>Inscription</button></a>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<dv> <footer> outil de de gestion de projet réalisé dans
	le cadre du module Conduite de projet </footer> </dv>

</body>
</html>