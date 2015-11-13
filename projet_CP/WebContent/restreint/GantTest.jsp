<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
</head>
	<body>
<header> 
<img src="img/logo-bdx.png" alt='logo-bdx.img' align="left" /> 
<aside id="tete-aside" class="aside-conteneur"> 
Bienvenu ${utilisateur.nom} ${utilisateur.prenom}&nbsp; 
<aside id="tete-menus" class="aside-conteneur">
<ul>
	<li><a href="#" id="menu-ppale" class="menu-ppale">__</a>

		<ul>
			<li><a href="#" class="menu-ppale">Mes infos</a></li>
			<li><a href="#" class="menu-ppale">Mes groupes</a></li>
			<li><a href="#" class="menu-ppale">Historique</a></li>
			<li><form action="deconnexion" method="post">
					<input type="submit" value="deconnexion" name="action"
						id="input-menuDeconnexion" class="input-bouton" />
				</form></li>
		</ul></li>
</ul>
</aside> </aside> </header>

<nav id="barre-menus" class="nav-conteneur">
<ul>
	<li><a href="accueil.jsp" class="menu-horizontale">accueil</a></li>
	<li><a href="../restreint/ajouterprojet.jsp"
		class="menu-horizontale">ajouter un projet</a></li>
	<li><a href="../restreint/contacts.jsp" class="menu-horizontale">contact
	</a></li>
</ul>
</nav>
<br />
<div class="div-conteneur" id="div-sprint">
	<h2>
		Sprint ${ sprint.numero }
		<!--  <c:out value="${ sprint.numero }" />  -->
	</h2>
	Gantt <br />

	<table class="table1">
		<tr>
			<td class="thprojet">Developeur</td>
			<c:forEach begin="0" end="${maxdate-1}" var="val">
				<td class="thprojet"><c:out value="${val}" /></td>
			</c:forEach>
		<tr />
		<c:forEach var="utilisateur" items="${ collaborateurs }">
			<tr>
				<td>${ utilisateur.getNom()}</td>
				<c:forEach begin="0" end="${maxdate-1}" var="val">
				<c:if test="${val==0}">
				   <td colspan="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val].getDuree() }" >
		              	 <c:out value="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val].getTag()}"/>
		           </td>
				</c:if>
				<c:if test="${val!=0}">
					<c:if test="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val] != GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val-1]}">
				         <td colspan="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val].getDuree() }" >
		              	      <c:out value="${GanttParIdCollaborateur.get(utilisateur.getIdUtilisateur())[val].getTag()}"/>
		              	 </td>
					</c:if>
				</c:if>
				
                </c:forEach>
		</c:forEach>
	</table>
	</body>
	
</html>