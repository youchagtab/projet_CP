<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style_acceuil.css">
<link rel="stylesheet" type="text/css" href="css/projet.css">
<link rel="stylesheet" type="text/css" href="css/menus.css">
<title>projet</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
google.load('visualization', '1.1', { packages : [ 'corechart' ]});
google.setOnLoadCallback(drawChart);

function drawChart() {
	var data = new google.visualization.DataTable();
	data.addColumn('number', 'Sprints');
	data.addColumn('number', 'Tendance');
	data.addColumn('number', 'Difficultés');

	//recuperation de donnees
	var listePointsDifficultes = ${listPointsDifficultes};

	var dernier = ${dernierPoint};

	//ajout des donnees
	var numRows = listePointsDifficultes.length;

	for (var i = 0; i < numRows; i++) {
		if (i == 0) {
			data.addRow([ i, listePointsDifficultes[i],listePointsDifficultes[i] ]);
		} else {
			data.addRow([ i, null, listePointsDifficultes[i] ]);
		}
	}

	data.addRow([ (dernier + numRows) - 1, 0, null ]);

	var options = {
		title : 'Burn down chart',
		subtitle : 'en difficultés par sprint',
		interpolateNulls : true,
		width : 900,
		height : 500,
		vAxis : { title : "Difficultés"},
		hAxis : {title : "Sprints"}
	};

	var chart = new google.visualization.LineChart(document.getElementById('linechart_material'));
	chart.draw(data, options);
}
</script>
<script type="text/javascript">
	function confirmer(url) {
		var repo = confirm("etes vous sure de vouloir supprimer cette user story?");
		if (repo == true) {
			document.location = url;
		}
	}
</script>
</head>
<body>


	<%@ include file="header.jsp"%>

	<br>
	<br>

	<h2 id="h2-projet">
		Projet :
		<c:out value="${ projet.description }" />
	</h2>

	<section class="section-conteneur" id="section-projet">



		<br /> <strong>Backlog : </strong> <a
			href="AjouterUserStory?idProjet=${projet.idProjet}" role="button"
			class="btn btn-primary btn-large">Ajouter une US</a> &nbsp; <a
			href="AfficherCollaborateurs?idProjet=${projet.idProjet}"
			role="button" class="btn btn-primary btn-large">Collaborateurs</a>&nbsp;
		<c:if test="${projet.estGitHub() }">
			<a href="ListCommitGitHub?idProjet=${projet.idProjet}" role="button"
				class="btn btn-default btn-large"> Commit du GitHub</a>
		</c:if>
		<br /> <br />
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
							role="button" class="btn btn-success btn-large"> Modifier </a>&nbsp;<a
							href="javascript:confirmer('SupprimerUserStory?idUserStory=${userStory.idUS}&idProjet=${projet.idProjet}')"
							role="button" class="btn btn-danger btn-large"> Supprimer </a></td>
					</tr>
				</c:forEach>
			</table>


		</article>

		<aside id="aside-sprint" class="aside-sprintConteneur">

			<a href="AjouterSprint?numero=${numero}&idProjet=${projet.idProjet}"
				role="button" class="btn btn-primary btn-large">Ajouter un
				sprint</a> <br /> <br />
			<c:forEach var="sprint" items="${sprints}">
				<a
					href="Sprint?idSprint=${sprint.idSprint}&idProjet=${projet.idProjet}"
					type="button" class="btn btn-info">sprint ${sprint.numero}</a>

			</c:forEach>

		</aside>
	</section>

	<br>

	<div id="linechart_material" class="div-conteneur"></div>


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
