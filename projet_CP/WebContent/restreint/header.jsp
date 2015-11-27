<header>
	<img src="img/logo-bdx.png" alt='logo-bdx.img' align="center" />
	<aside id="tete-aside" class="aside-conteneur">
		${utilisateur.nom} ${utilisateur.prenom}&nbsp;
		<aside id="tete-menus" class="aside-conteneur">
			<ul>
				<li><a href="#" id="menu-ppale" class="menu-ppale">__</a>

					<ul>
						<li><a href="redirection?page=infos" class="menu-ppale">Mes infos</a></li>
						<li><a href="redirection?page=groupes" class="menu-ppale">Mes groupes</a></li>
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
     	<li><a href="javascript:history.go(-1)" class="menu-horizontale">Retour</a></li> &nbsp;&nbsp;
		<li><a href="acceuil" class="menu-horizontale">accueil</a></li>&nbsp;&nbsp;
		<li><a href="AjouterProjet" class="menu-horizontale">ajouter
				un projet</a></li>

	</ul>
</nav>


