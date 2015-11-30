<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>sprint</title>
<script type="text/javascript">
	function confirmer(url) {
		var repo = confirm("Etez-vous sûrs de vouloir vous supprimer cette tâche?");
		if (repo == true) {
			document.location = url;
		}
	}
</script>
</head>
<body>

	
		<%@ include file="header.jsp" %>

	

	<br />
	<div class="div-conteneur-sprint" id="div-sprint">

		<h2>
			Sprint ${ sprint.numero }
			<!--  <c:out value="${ sprint.numero }" />  -->
		</h2>


		<a href="AjouterUserStorySprint?idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}"
			type="button" class="btn btn-info">Ajouter une US</a> &nbsp;&nbsp;&nbsp;&nbsp;
	
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
					<td><a href="restreint/ajoutertache.jsp?idUS=${userStory.idUS }&idSprint=${param.idSprint}&idProjet=${param.idProjet}" type="button" class="btn btn-info"> ajouter une tache</a>

						<ul>
							<c:forEach var="tache" items="${taches[(status.count)-1] }">
								<li><c:out value="${tache.description} [tag : ${tache.tag }, coût : ${tache.cout }]" /> &nbsp;
									<aside id="taches-menus" class="aside-conteneur">
										<ul>
											<li><a href="#" id="menu-tache" class="menu-Sprint">&nbsp;&nbsp;&nbsp;&nbsp;</a>

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
													<li><a href="commit?idTache=${tache.idTache}&idProjet=${projet.idProjet}" class="menu-ppale">
															liste des commits </a></li>		
												</ul>
										</ul>
									</aside></li>

							</c:forEach>
						</ul></td>
			</c:forEach>
		</table>
		
		<br/>
		<c:if test="${tailleListeLongue!= 0}">
		<h2>Kanban</h2>
			<table class="table1">
				<tr>
					<th>A FAIRE</th>
					<th>EN COURS</th>
					<th>FAIT</th>
				</tr>
				<c:forEach begin="0" end="${tailleListeLongue-1}" var="val">
					<tr>
						<c:if test="${ val < tacheAFaire.size()}">
							<td>${tacheAFaire.get(val).description} <br/>
							[<a href="Kanban?idTache=${tacheAFaire.get(val).idTache}&idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}&status=EN_COURS">></a>]</td>
						</c:if>
						<c:if test="${ val >= tacheAFaire.size()}">
							<td></td>
						</c:if>
						
						<c:if test="${ val <tacheEnCours.size()}">
							<td>${tacheEnCours.get(val).description} <br/>
							 ${tacheEnCours.get(val).developpeur.nom} ${tacheEnCours.get(val).developpeur.prenom}  
							 [<a href="Kanban?idTache=${tacheEnCours.get(val).idTache}&idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}&status=A_FAIRE"><</a> 
							 <a href="Kanban?idTache=${tacheEnCours.get(val).idTache}&idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}&status=FAIT">></a>]
							 </td>
						</c:if>
						<c:if test="${ val >= tacheEnCours.size()}">
							<td></td>
						</c:if>
						
						
						<c:if test="${ val <tacheFinis.size()}">
							<td>${tacheFinis.get(val).description} <br/>
							 ${tacheFinis.get(val).developpeur.nom} ${tacheFinis.get(val).developpeur.prenom}  
							 [<a href="Kanban?idTache=${tacheFinis.get(val).idTache}&idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}&status=EN_COURS"><</a>]
							 </td>
						</c:if>
						<c:if test="${ val >= tacheFinis.size()}">
							<td></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>	
		</c:if>
		<br/>
		
		<br/>
		<c:if test="${not empty stringListTaches }">
			<h2>Pert</h2>
			<object type="application/x-java-applet" height="500" width="700">
			  <param name="code" value="Main" />
			  <param name="stringListTaches" value="${stringListTaches}"/>
			  <param name="stringListDependance" value="${stringListDependance}"/>
			  <param name="archive" value="pert.jar,jgrapht-core-0.9.1.jar,jgrapht-ext-0.9.2.jar,jgraphx-1.10.1.3.jar" />
			  Pert :: Applet failed to run.  No Java plug-in was found.
			</object>
		</c:if>	
		<br/>
		
	   
	 <c:if test="${Ganttexist == true}">
     <br />
  
     <h2>Gantt Previsionnel</h2>
     
     <div id="div-gantt" class="div-gantt" >
     
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
	
	<br/>
	
	<c:if test="${GanttexistEff == true}">
     <br />
     <h2>Gantt Effectif</h2>
     
    <div  class="div-gantt" >
	<table class="table1">
		<tr>
			<td class="thprojet">Developeur</td>
			<c:forEach begin="0" end="${maxdateEff-1}" var="val">
				<td class="thprojet"><c:out value="${val}" /></td>
			</c:forEach>
		<tr />
		<c:forEach var="utilisateur" items="${ collaborateursEff }">
			<tr>
				<td>${ utilisateur.getNom()}</td>
				<c:forEach begin="0" end="${maxdateEff-1}" var="val">
				<c:if test="${val==0}">
				   <td colspan="${GanttParIdCollaborateurEff.get(utilisateur.getIdUtilisateur())[val].getDuree() }" >
		              	 <c:out value="${GanttParIdCollaborateurEff.get(utilisateur.getIdUtilisateur())[val].getTag()}"/>
		           </td>
				</c:if>
				<c:if test="${val!=0}">
					<c:if test="${GanttParIdCollaborateurEff.get(utilisateur.getIdUtilisateur())[val] != GanttParIdCollaborateurEff.get(utilisateur.getIdUtilisateur())[val-1]}">
				         <td colspan="${GanttParIdCollaborateurEff.get(utilisateur.getIdUtilisateur())[val].getDuree() }" >
		              	      <c:out value="${GanttParIdCollaborateurEff.get(utilisateur.getIdUtilisateur())[val].getTag()}"/>
		              	 </td>
					</c:if>
				</c:if>
				
                </c:forEach>
		</c:forEach>
	</table>
	</c:if>
	</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	 <%@ include file="footer.jsp" %>
	

</body>
</html>
