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

@WebServlet("/AfficherCollaborateurs")
public class CollaborateursProjet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE_Collaborateurs = "/restreint/CollaborateursProjet.jsp";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String ATT_PROJET = "projet";
	public static final String ATT_COLLABORATEURS = "collaborateurs";
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idProjet = request.getParameter(PARAM_ID_PROJET);
		IProjetDAO projetDAO =new ProjetDAOimpl();
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		IProjetUtilisateurDAO projetUtilisateur = new ProjetUtilisateurDAOimpl();
		List<Integer> collaborateursIDs = projetUtilisateur.listerIdUtilisateurs(Integer.parseInt(idProjet));
		
		
		List<Utilisateur> collaborateurs = new ArrayList<Utilisateur>();
		IUtilisateurDAO utilisateurDAO =new UtilisateurDAOimpl();
		
		Iterator<Integer> iter = collaborateursIDs.iterator();
		while (iter.hasNext()) {
			beans.Utilisateur utilisateur = utilisateurDAO.recupererUtilisateur(iter.next());
		     collaborateurs.add(utilisateur);
		}	
			
		request.setAttribute(ATT_PROJET, projet);
		request.setAttribute(ATT_COLLABORATEURS, collaborateurs);
		
		
		
		this.getServletContext().getRequestDispatcher(VUE_Collaborateurs).forward(request, response);
	};

}
