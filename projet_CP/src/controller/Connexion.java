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

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_IDENTIFIANT = "identifiant";
	public static final String PARAM_MDP = "motdepasse";
	public static final String ATT_SESSION_UTILISATEUR = "utilisateur";
	public static final String ATT_ERREUR = "erreur";
	public static final String VUE_Connexion = "/connexion.jsp";//tgfdg
	public static final String Vue_Accueil = "/acceuil";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		String identifiant = request.getParameter(PARAM_IDENTIFIANT);
		String motDePasse = request.getParameter(PARAM_MDP);
		
		IUtilisateurDAO utilisateurDAO = new UtilisateurDAOimpl();
		System.out.println("id = "+identifiant+" mdp = "+motDePasse);

		if(utilisateurDAO.verificationConnexion(identifiant, motDePasse))
		{
			Utilisateur utilisateur = utilisateurDAO.recupererUtilisateur(identifiant);
			session.setAttribute(ATT_SESSION_UTILISATEUR, utilisateur);
			this.getServletContext().getRequestDispatcher(Vue_Accueil).forward(request, response);
			
		}
		else
		{
			String erreur = "L'identifiant ou le mot de passe est incorrecte !";
			request.setAttribute(ATT_ERREUR, erreur);
			this.getServletContext().getRequestDispatcher(VUE_Connexion).forward(request, response);
		}
	}

}
