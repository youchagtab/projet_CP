<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Connexion</title>
 <link type="text/css" rel="stylesheet" href="CP_Inscription.css" />
</head>
<body  >
<dv>
   <h1> CP Gérez vos projets avec  Agile</h1>


</dv>



<di id="autourConnexion">
    <br><br><br>
    	<c:out value="${requestScope.erreur }"/>
        <form method="post" action="Connexion">
            <fieldset id="Field">
                <legend>Connexion</legend>
                        
                <label for="identifiant">Identifiant <span class="requis"></span></label>
                <input type="text" id="identifiant" name="Identifiant" value="" size="20" maxlength="60" placeholder="identifiant" required="Veuillez compléter ce champ" />
                <br />

                <label for="motdepasse">Mot de passe <span class="requis"></span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" placeholder="mot de passe" required="Veuillez compléter ce champ"/>
                <br />

 
                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
            
            
            
        </form>
        
        <br><br>
        
        <a type="submit" href="CP_Inscription.jsp" class="sansLabel"><button>Inscription</button></a>
        
      </di>

</body>
</html>