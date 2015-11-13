package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.IProjetDAO;
import dao.IProjetUtilisateurDAO;
import dao.IUtilisateurDAO;
import dao.ProjetDAOimpl;
import dao.ProjetUtilisateurDAOimpl;
import dao.UtilisateurDAOimpl;

@WebServlet("/AjouterCollaborateurs")
public class AjouterCollaborateur extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE_AJOUTER_Collab = "/restreint/ajouterCollaborateur.jsp";
	public static final String VUE_PROJET = "/projet_CP/projet";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String ATT_PROJET = "projet";
	public static final String ATT_COLLABORATEURS = "collaborateurs";
	public static final String ATT_UTILISATEURS = "utilisateurs";
	public static final String IDs_UTILISATEURS_A_AJOUTER= "ajoutUtilisateurs";



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idProjet = request.getParameter(PARAM_ID_PROJET);

		IProjetDAO projetDAO =new ProjetDAOimpl();
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		IProjetUtilisateurDAO projetUtilisateur = new ProjetUtilisateurDAOimpl();
		List<Integer> collaborateursIDs = projetUtilisateur.listerIdUtilisateurs(Integer.parseInt(idProjet));



		/*recuperation des  collaborateurs*/
		List<Utilisateur> collaborateurs = new ArrayList<Utilisateur>();
		IUtilisateurDAO utilisateurDAO =new UtilisateurDAOimpl();


		Iterator<Integer> iter = collaborateursIDs.iterator();
		while (iter.hasNext()) {
			beans.Utilisateur utilisateur = utilisateurDAO.recupererUtilisateur(iter.next());
			collaborateurs.add(utilisateur);
		}


		/*recuperation des utilisateurs non collaborateurs sur le projet*/
		List<Utilisateur> utilisateurs =utilisateurDAO.lister();

		while (iter.hasNext()) {
			beans.Utilisateur utilisateur = utilisateurDAO.recupererUtilisateur(iter.next());
			utilisateurs.remove(utilisateur);	
		}


		request.setAttribute(ATT_PROJET, projet);
		request.setAttribute(ATT_UTILISATEURS, utilisateurs);
		request.setAttribute(ATT_COLLABORATEURS, collaborateurs);

		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_Collab).forward(request, response);


	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] utilisateursSelect = request.getParameterValues(IDs_UTILISATEURS_A_AJOUTER);
		String idProjet = request.getParameter(PARAM_ID_PROJET);


		//recuperation collabs existants
		IProjetUtilisateurDAO projetUtilisateur = new ProjetUtilisateurDAOimpl();
		List<Integer> collaborateursIDs = projetUtilisateur.listerIdUtilisateurs(Integer.parseInt(idProjet));


		//ajout collaborateur
		if(utilisateursSelect!=null){
			for(int i=0; i<utilisateursSelect.length;i++){	
				int idUtilisateur = Integer.parseInt(utilisateursSelect[i]);
				if(!collaborateursIDs.contains(idUtilisateur)){
					projetUtilisateur.ajouter(Integer.parseInt(idProjet),idUtilisateur);
				} else{
					System.out.println("utilisateur déjà collaborateur sur ce projet");
				}
			}

		} else {
			System.out.println("pas d'utilisateurs choisis pour ajoutés");
		}

		doGet(request, response);


	}




}
