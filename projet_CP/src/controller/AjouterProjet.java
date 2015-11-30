package controller;

import java.io.IOException;

//import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import beans.Projet;
import beans.Utilisateur;
import dao.IProjetDAO;
import dao.IProjetUtilisateurDAO;
import dao.ProjetDAOimpl;
import dao.ProjetUtilisateurDAOimpl;

/**
 * Servlet implementation class AjouterProjet
 */
@WebServlet("/AjouterProjet")
public class AjouterProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_AJOUTER_PROJET = "/restreint/ajouterprojet.jsp";
	public static final String VUE_ACCEUIL = "/projet_CP/acceuil";
	public static final String PARAM_NOMS = "noms";
	public static final String PARAM_DESCRIPTION = "description";
	public static final String PARAM_GITHUB = "repertoireGitHub";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_PROJET)
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String noms = request.getParameter(PARAM_NOMS);
		String description = request.getParameter(PARAM_DESCRIPTION);

		if (request.getParameter(PARAM_NOMS) != null
				&& request.getParameter(PARAM_DESCRIPTION) != null
				&& !request.getParameter(PARAM_NOMS).isEmpty()
				&& !request.getParameter(PARAM_DESCRIPTION).isEmpty()) {
		

		String repertoireGitHub = null;
		if (request.getParameter(PARAM_GITHUB) != null
				&& !request.getParameter(PARAM_GITHUB).isEmpty()) {

			repertoireGitHub = request.getParameter(PARAM_GITHUB);
			try {
				GitHub github = GitHub.connectAnonymously();
				github.getRepository(repertoireGitHub);
			} catch (IOException e) {
				repertoireGitHub = "";
			}
		} else {
			repertoireGitHub = "";
		}

		IProjetDAO projetDAO = new ProjetDAOimpl();
		Projet projet = new Projet(noms, description);
		projet.setRepertoireGitHub(repertoireGitHub);
		int idprojet = projetDAO.ajouter(projet);

		HttpSession session = request.getSession();
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");

		System.out.println(idprojet + " " + u.getIdUtilisateur());

		IProjetUtilisateurDAO projetutilisateur = new ProjetUtilisateurDAOimpl();
		projetutilisateur.ajouter(idprojet, u.getIdUtilisateur());

		response.sendRedirect(VUE_ACCEUIL);
	}else{
		request.setAttribute("erreur", "veuillez remplir tout les champs");
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_PROJET)
		.forward(request, response);
	}
		
		
	}

}
