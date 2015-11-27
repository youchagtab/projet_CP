package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.IUtilisateurDAO;
import dao.UtilisateurDAOimpl;

@WebServlet("/ModifierInfos")
public class ModifierUtilisateur extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String Vue_Accueil = "/projet_CP/acceuil";
	public static final String ATT_SESSION_UTILISATEUR = "utilisateur";
	public static final String PARAM_PRENOM = "prenom";
	public static final String PARAM_IDUTILISATEUR = "idUtilisateur";
	public static final String PARAM_NOM = "nom";
	public static final String PARAM_IDENTIFIANT = "identifiant";
	public static final String PARAM_MOTDEPASSE = "motDePasse";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idUtilisateur = Integer.parseInt(request.getParameter(PARAM_IDUTILISATEUR));
		String prenom = request.getParameter(PARAM_PRENOM);
		String nom = request.getParameter(PARAM_NOM);
		String identifiant = request.getParameter(PARAM_IDENTIFIANT);
	    String motDePasse = request.getParameter(PARAM_MOTDEPASSE);
		Utilisateur utilisateur = new Utilisateur(idUtilisateur, identifiant, motDePasse, nom, prenom);
		IUtilisateurDAO utilisateurDAO = new UtilisateurDAOimpl();
		utilisateurDAO.modifier(utilisateur);
		
		
		HttpSession session = request.getSession();
		Utilisateur utilisateurModifier = utilisateurDAO.recupererUtilisateur(identifiant);
		session.setAttribute(ATT_SESSION_UTILISATEUR, utilisateurModifier);
		response.sendRedirect(Vue_Accueil);
	}
}
