<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>sprint</title>
<script type="text/javascript">
	function confirmer(url) {
		var repo = confirm("Etez-vous s�rs de vouloir vous supprimer cette t�che?");
		if (repo == true) {
			document.location = url;
		}
	}
</script>
</head>
<body>

	<header>
		<%@ include file="header.jsp" %>

	</header>
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


		<a href="AjouterUserStorySprint?idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}"
			class="menu-ppale">Ajouter une US</a> <br />
		<br />
		<a href="AfficherGantt?idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}"
		class="menu-ppale">Gantt Test</a>

		<table class="table1">
		<br/>
			<tr>
				<th class="thprojet">USER STORY</th>
				<th class="thprojet">TACHES</th>
			</tr>
			<c:forEach var="userStory" items="${userStories}" begin="0"
				end="${fn:length(userStories)}" varStatus="status">
				<tr>
					<td><c:out value="${userStory.description}" /></td>
					<td><a href="restreint/ajoutertache.jsp?idUS=${userStory.idUS }&idSprint=${param.idSprint}&idProjet=${param.idProjet}">
							<button>ajouter une tache</button>
					</a>

						<ul>
							<c:forEach var="tache" items="${taches[(status.count)-1] }">
								<li><c:out value="${tache.description} [tag : ${tache.tag }, co�t : ${tache.cout }]" /> &nbsp;
									<aside id="taches-menus" class="aside-conteneur">
										<ul>
											<li><a href="#" id="menu-tache" class="menu-Sprint">__</a>

												<ul>
													<li><a href="ModifierTache?idUserStory=${userStory.idUS}&idTache=${tache.idTache}&idProjet=${projet.idProjet}&idSprint=${sprint.idSprint}" class="menu-ppale">
															Modifier </a></li>
													<li><a href="javascript:confirmer('SupprimerTache?idTache=${tache.idTache }&idSprint=${param.idSprint}&idProjet=${param.idProjet}')"
														class="menu-ppale"> Supprimer </a></li>
													<li><a href="DependanceEntreTaches?idTache=${tache.idTache}&idSprint=${sprint.idSprint}" class="menu-ppale">
															Dependance </a></li>
													<li><a href="AffectationTache?idTache=${tache.idTache}&idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}" class="menu-ppale">
															Affecter </a></li>
													<li><a href="SupprimerAffectation?idTache=${tache.idTache}&idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}" class="menu-ppale">
															Supprimer l'affectation </a></li>
												</ul>
										</ul>
									</aside></li>

							</c:forEach>
						</ul></td>
			</c:forEach>
		</table>
		
		<br/>
		<h2>Kanaban</h2>
			<table class="table1">
				<tr>
					<th>A FAIRE</th>
					<th>EN COURS</th>
					<th>FAIT</th>
				</tr>
				<tr>
					<td>Tache 5 [<a href="#">></a>]</td>
					<td>Tache 3 [Developpeur 1 | <a href="#"><</a> <a href="#">></a>]</td>
					<td>Tache 1 [Developpeur 1 | <a href="#"><</a>]</td>
				</tr>
				<tr>
					<td>Tache 6 [<a href="#">></a>]</td>
					<td>Tache 4 [Developpeur 2 | <a href="#"><</a> <a href="#">></a>]</td>
					<td>Tache 2 [Developpeur 2 | <a href="#"><</a>]</td>
				</tr>
				<tr>
					<td>Tache 7 [<a href="#">></a>]</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Tache 8 [<a href="#">></a>]</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Tache 9 [<a href="#">></a>]</td>
					<td></td>
					<td></td>
				</tr>
			</table>	
		<br/>
		
		<br/>
		<h2>Pert</h2>
		<object type="application/x-java-applet" height="500" width="700">
		  <param name="code" value="Main" />
		  <param name="archive" value="pert.jar,jgrapht-core-0.9.1.jar,jgrapht-ext-0.9.2.jar,jgraphx-1.10.1.3.jar,mysql-connector-java-5.1.29.jar" />
		  Pert :: Applet failed to run.  No Java plug-in was found.
		</object>
		<br/>
		
	 <c:if test="${Ganttexist == true}">
     <br />
     <h2>Gantt</h2>
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
	</c:if>

	</div>

	<br>
	<br>
	<br>
	<form action="deconnexion" method="post">
		<input type="submit" value="deconnexion" name="action" />
	</form>
	<br>
	<br>
	<br>
	 <footer> outil de de gestion de projet r�alis� dans
		le cadre du module Conduite de projet </footer> 
	

</body>
</html>
