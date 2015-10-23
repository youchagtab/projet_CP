package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IUtilisateurDAO;
import dao.UtilisateurDAOimpl;
import beans.Utilisateur;

/**
 * Servlet implementation class inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_NOM = "nom";
	public static final String PARAM_PRENOM = "prenom";
	public static final String PARAM_IDENTIFIANT = "identifiant";
	public static final String PARAM_MOT_DE_PASSE = "motDePasse";
	public static final String PARAM_CONFIRMATION = "confirmation";
	public static final String ATT_SESSION_UTILISATEUR = "utilisateur";
	public static final String ATT_ERREUR = "erreur";
	public static final String VUE_INSCRIPTION = "/inscription.jsp";
	public static final String VUE_ACCUEIL = "accueil.jsp";
	
	IUtilisateurDAO utilisateurDAO = new UtilisateurDAOimpl();
	
	
       
   
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String nom = request.getParameter(PARAM_NOM);
		String prenom = request.getParameter(PARAM_PRENOM);
		String identifiant = request.getParameter(PARAM_IDENTIFIANT);
		String motDePasse = request.getParameter(PARAM_MOT_DE_PASSE);
		String confirmation = request.getParameter(PARAM_CONFIRMATION);
		
		
		Utilisateur  utilisateur =new Utilisateur(identifiant, motDePasse, nom, prenom);
		
		if(utilisateurDAO.existanceIdentifiant(identifiant)){
			
			String erreur = "L'identifiant existant déjà dans la base de données !";
			request.setAttribute(ATT_ERREUR, erreur);
			this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(request, response);
			
		} else if(motDePasse!=confirmation){
			
			String erreur = "Mot de passe différent  !";
			request.setAttribute(ATT_ERREUR, erreur);
			this.getServletContext().getRequestDispatcher(VUE_INSCRIPTION).forward(request, response);
			
		} else {
			utilisateurDAO.ajouter(utilisateur);
			session.setAttribute(ATT_SESSION_UTILISATEUR, utilisateur);
			this.getServletContext().getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
