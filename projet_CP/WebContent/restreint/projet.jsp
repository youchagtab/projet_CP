<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/projet.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>projet</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">

    google.load('visualization', '1.1', {packages: ['line']});
    google.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Sprints');
      data.addColumn('number', 'Difficultés par sprint');
      
      //recuperation de donnees
      var listePointsDifficultes=${listPointsDifficultes};
      
      //ajout des donnees
      var numRows = listePointsDifficultes.length;      
      for (var i = 0 ; i < numRows; i++) {
    	   data.addRow(["sprint "+(i+1), listePointsDifficultes[i]]);   	   
       }
   
      var options = {chart: {title: 'BurnDown chart',subtitle: 'en jours de la semaines'}, width: 900,height: 400,axes: { y: {all: {range: { min: 0 } } } }};
      
      var chart = new google.charts.Line(document.getElementById('linechart_material'));
      chart.draw(data, options);
   }
    
</script>
<script type="text/javascript">
	function confirmer(url) {
		var repo = confirm("etes vous sure de vouloir supprimer cet user story?");
		if (repo == true) {
			document.location = url;
		}
	}
</script>
</head>
<body>

	<header>
		<%@ include file="header.jsp"%>

	</header>
	<nav id="barre-menus" class="nav-conteneur">
		<ul>
			<li><a href="../restreint/acceuil.jsp" class="menu-horizontale">accueil</a></li>
			<li><a href="../restreint/ajouterprojet.jsp"
				class="menu-horizontale">ajouter un projet</a></li>
			<li><a href="../restreint/contacts.jsp" class="menu-horizontale">contact
			</a></li>
		</ul>
	</nav>

	<h2 id="h2-projet">
		Projet :
		<c:out value="${ projet.description }" />
	</h2>

	<section class="section-conteneur" id="section-projet">


		<br /> <strong>Backlog : </strong> <a
			href="AjouterUserStory?idProjet=${projet.idProjet}"
			class="menu-ppale">Ajouter une US</a> <br /> &nbsp; <a
			href="AfficherCollaborateurs?idProjet=${projet.idProjet}"
			class="menu-ppale">Collaborateurs</a> <br /> <br />
		<article>
			<table class="table1">
				<tr>
					<td class="thprojet">#</td>
					<td class="thprojet">Description</td>
					<td class="thprojet">Difficulté</td>
					<td class="thprojet">Priorité</td>
					<td class="thprojet">Actions</td>
				</tr>
				<c:forEach var="userStory" items="${ userStories }">
					<tr>
						<td>${ userStory.idUS }</td>
						<td>${ userStory.description }</td>
						<td>${ userStory.difficulte }</td>
						<td>${ userStory.priorite}</td>
						<td><a
							href="ModifierUserStory?idUserStory=${userStory.idUS}&idProjet=${projet.idProjet}"
							class="menu-ppale"> Modifier </a>&nbsp;<a
							href="javascript:confirmer('SupprimerUserStory?idUserStory=${userStory.idUS}&idProjet=${projet.idProjet}')"
							class="menu-ppale"> Supprimer </a></td>
					</tr>
				</c:forEach>
			</table>


		</article>

		<aside id="aside-sprint" class="aside-sprintConteneur">

			<a href="AjouterSprint?numero=${numero}&idProjet=${projet.idProjet}"
				id="a-ajouterSprint" class="a-sprint">Ajouter un sprint</a> <br />
			<br />
			<c:forEach var="sprint" items="${sprints}">
				<a
					href="Sprint?idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}"
					id="a-afficherSprint" class="a-sprint">sprint ${sprint.numero}</a>

			</c:forEach>

			<br> <a href="AjouterSprint1" class="a-afficherSprintTest"
				class="a-sprint">sprint test</a>

		</aside>
	</section>
	
	<div id="linechart_material" class="div-conteneur"></div>



	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<footer> outil de de gestion de projet réalisé dans le cadre
		du module Conduite de projet </footer>

</body>
</html>