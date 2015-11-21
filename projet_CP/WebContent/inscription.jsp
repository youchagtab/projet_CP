<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inscription</title>
 <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
    <div class="autour">
    <br><br><br>
    <c:out value="${requestScope.erreur }"/> 
        <form method="post" action="inscription">
            <fieldset id="Fieldset">
                <legend>Inscription</legend>
               
                
                
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" placeholder="Nom"  required="Veuillez compléter ce champ"/>
                <br />
                
                <label for="prenom">prenom  d'utilisateur</label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" placeholder="Prénom" required="Veuillez compléter ce champ"/>
                <br />

                <label for="identifiant">Identifiant <span class="requis">*</span></label>
                <input type="text" id="identifiant" name="identifiant" value="" size="20" maxlength="60" placeholder="identifiant" required="Veuillez compléter ce champ" />
                <br />

                <label for="motDePasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motDePasse" name="motDePasse" value="" size="20" maxlength="20" placeholder="mot de passe" required="Veuillez compléter ce champ"/>
                <br />

                <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" placeholder="confirmation mot de passe"  required="Veuillez compléter ce champ"/>
                <br />


                <input type="submit" value="Inscription" class="sansLabel" />
                <br />
            </fieldset>
        </form>
        
      </div>
      
 
         <br> <br><br>
	<div> <footer> outil de de gestion de projet réalisé dans
	le cadre du module Conduite de projet </footer> </div>
    

</body>
</html>