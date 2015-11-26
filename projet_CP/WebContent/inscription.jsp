<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inscription</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/erreurs.css" />
<link type="text/css" rel="stylesheet" href="css/style_connexion.css" />
<link rel="stylesheet" type="text/css" href="css/menus.css">
</head>
<body>

	<header>
		<article>
			<h1>Gérez vos projets avec SCRUM</h1>
		</article>
	</header>

	<nav id="barre-menus" class="nav-conteneur">
		<a type="submit" href="connexion.jsp" class="menu-horizontale" >Connexion</a>
	</nav>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="autour">
		<br> <br> <br>

		<div class="msg-erreurs">
			<c:out value="${requestScope.erreur }" />
		</div>



		<form method="post" action="inscription">
			<fieldset id="Fieldset">
				<legend>Inscription</legend>



				<input type="text" id="nom" name="nom" value="" size="20"
					maxlength="20" placeholder="Nom"
					required="Veuillez compléter ce champ" /> <span class="requis"></span>
				<input type="text" id="prenom" name="prenom" value="" size="20"
					maxlength="20" placeholder="Prénom"
					required="Veuillez compléter ce champ" /> <span class="requis">*</span>
				<input type="text" id="identifiant" name="identifiant" value=""
					size="20" maxlength="60" placeholder="identifiant"
					required="Veuillez compléter ce champ" /> <span class="requis">*</span>
				<input type="password" id="motDePasse" name="motDePasse" value=""
					size="20" maxlength="20" placeholder="mot de passe"
					required="Veuillez compléter ce champ" /> <span class="requis">*</span>
				<input type="password" id="confirmation" name="confirmation"
					value="" size="20" maxlength="20"
					placeholder="confirmation mot de passe"
					required="Veuillez compléter ce champ" /> <br /> <input
					type="submit" value="Inscription" class="sansLabel" /> <br />
			</fieldset>
		</form>

	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<%@ include file="../restreint/footer.jsp"%>


</body>
</html>