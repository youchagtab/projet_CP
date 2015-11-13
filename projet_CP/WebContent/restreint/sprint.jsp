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
		var repo = confirm("Etez-vous sûrs de vouloir vous supprimer cette tâche?");
		if (repo == true) {
			document.location = url;
		}
	}
</script>
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
			</aside>
		</aside>

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
		class="menu-ppale">Gantt Test</a> <br />

		<table class="table1">
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
								<li><c:out value="${tache.description}" /> &nbsp;
									<aside id="taches-menus" class="aside-conteneur">
										<ul>
											<li><a href="#" id="menu-tache" class="menu-Sprint">__</a>

												<ul>
													<li><a href="ModifierTache" class="menu-ppale">
															Modifier </a></li>
													<li><a href="javascript:confirmer('SupprimerTache?idTache=${tache.idTache }&idSprint=${param.idSprint}&idProjet=${param.idProjet}')"
														class="menu-ppale"> Supprimer </a></li>
														<li><a href="DependanceEntreTaches" class="menu-ppale">
															Dependance </a></li>
												</ul></li>
										</ul>
									</aside></li>

							</c:forEach>
						</ul></td>
			</c:forEach>
		</table>


<div align="center">
        <jsp:plugin
        	archive="applet.jar"
            type="applet"
            code="Main.class"
            codebase="/src/Pert"
            
            width="700" 
            height="500">
             
            <jsp:params>
                <jsp:param name="" value="" />
                <jsp:param name="" value="" />
            </jsp:params>
             
            <jsp:fallback>
                <p>Could not load applet!</p>
            </jsp:fallback>
             
        </jsp:plugin>
</div>


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
	 <footer> outil de de gestion de projet réalisé dans
		le cadre du module Conduite de projet </footer> 
	

</body>
</html>
