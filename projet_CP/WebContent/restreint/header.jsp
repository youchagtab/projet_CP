<header>
	<img src="img/logo-bdx.png" alt='logo-bdx.img' align="center" />
	<aside id="tete-aside" class="aside-conteneur">
		${utilisateur.nom} ${utilisateur.prenom}&nbsp;
		<aside id="tete-menus" class="aside-conteneur">
			<ul>
				<li><a href="#" id="menu-ppale" class="menu-ppale">&nbsp;&nbsp;&nbsp;&nbsp;</a>

					<ul>
						<li><a href="redirection?page=infos" class="menu-ppale">Mes infos</a></li>
						<li><a href="redirection?page=groupes" class="menu-ppale">Mes groupes</a></li>
						<li><a href="deconnexion" class="menu-ppale">Déconnexion</a></li> 
					</ul></li>
			</ul>
		</aside>
	</aside>
</header>
<nav id="barre-menus" class="nav-conteneur">
	<ul id="ul-horizontale">
     	<li class="li-horizontale"><a href="javascript:history.go(-1)" class="menu-horizontale">Retour</a></li> &nbsp;&nbsp;
		<li class="li-horizontale"><a href="acceuil" class="menu-horizontale">Liste des projets</a></li>&nbsp;&nbsp;
		<li class="li-horizontale"><a href="AjouterProjet" class="menu-horizontale">Ajouter
				un projet</a></li> &nbsp;&nbsp;
		<li class="li-horizontale"><a href="redirection?page=infos" class="menu-horizontale">Mes infos</a></li> &nbsp;&nbsp;
		<li class="li-horizontale"><a href="redirection?page=groupes" class="menu-horizontale">Mes groupes</a></li> &nbsp;&nbsp;
		<li class="li-horizontale"><a href="deconnexion" class="menu-horizontale">Déconnexion</a></li> &nbsp;&nbsp;

	</ul>
</nav>


