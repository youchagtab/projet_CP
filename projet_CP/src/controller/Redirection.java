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
import javax.servlet.http.HttpSession;

import beans.Projet;
import beans.Utilisateur;
import dao.IProjetDAO;
import dao.IProjetUtilisateurDAO;
import dao.IUtilisateurDAO;
import dao.ProjetDAOimpl;
import dao.ProjetUtilisateurDAOimpl;
import dao.UtilisateurDAOimpl;



@WebServlet("/redirection")
public class Redirection extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static final String VUE_AUTEURS= "/restreint/auteurs.jsp";
	public static final String VUE_GROUPES= "/restreint/mesGroupes.jsp";
	public static final String VUE_INFOS= "/restreint/mesInfos.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  page = request.getParameter("page");
		System.out.println(page);
		if(page.equals("groupes")){
			HttpSession session = request.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

			//lister projets
			IProjetDAO metier = new ProjetDAOimpl();
			IProjetUtilisateurDAO projetUtilisateurDAO = new ProjetUtilisateurDAOimpl();
			List<Integer> idP = projetUtilisateurDAO.listerIdProjet(utilisateur.getIdUtilisateur());
			Iterator<Integer> iterator = idP.iterator();
			List<Projet> projets= new ArrayList<Projet>();
			while(iterator.hasNext()){
				projets.add(metier.recupererProjet(iterator.next()));
			}

			//lister tous les collaborateurs
			IUtilisateurDAO utilisateurDAO =new UtilisateurDAOimpl();
			List<List<Utilisateur>> Collabs =new ArrayList<List<Utilisateur>>();
			Iterator<Projet> iter = projets.iterator();
			while(iter.hasNext()){
				List<Utilisateur> collabsIter = new ArrayList<Utilisateur>();
				List<Integer> collaborateursIDs = projetUtilisateurDAO.listerIdUtilisateurs(iter.next().getIdProjet());
				Iterator<Integer> iter1 = collaborateursIDs.iterator();
				while (iter1.hasNext()) {
					beans.Utilisateur util = utilisateurDAO.recupererUtilisateur(iter1.next());
					collabsIter.add(util);
				}
				Collabs.add(collabsIter);
				System.out.println("arrivé ici");
			}

			request.setAttribute("collaborateurs", Collabs);
			request.setAttribute("projets", projets);
			this.getServletContext().getRequestDispatcher(VUE_GROUPES).forward(request, response);


		}else  if(page.equals("auteurs")){
			this.getServletContext().getRequestDispatcher(VUE_AUTEURS).forward(request, response);  		
		}else if(page.equals("infos")){
			this.getServletContext().getRequestDispatcher(VUE_INFOS).forward(request, response); 
		}

	}

}
