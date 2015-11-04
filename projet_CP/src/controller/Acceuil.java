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
import dao.ProjetDAOimpl;
import dao.ProjetUtilisateurDAOimpl;


@WebServlet("/acceuil")
public class Acceuil extends HttpServlet {
	private IProjetDAO metier;
	private IProjetUtilisateurDAO projetUtilisateurDAO;

	@Override
	public void init() throws ServletException {
		metier = new ProjetDAOimpl();
		projetUtilisateurDAO = new ProjetUtilisateurDAOimpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		if (session.getAttribute("utilisateur") == null){
			System.out.println("pas connecte");
		}
		AcceuilModel model = new AcceuilModel();
		request.setAttribute("model", model);
		
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		String action = request.getParameter("action");
		
		//delete
		if (action != null && action.equals("delete")) {
			int reference = Integer.parseInt(request.getParameter("ref"));
			int idUtilisateur= Integer.parseInt(request.getParameter("refUtil"));
			
			// String ref = request.getParameter("ref")
			projetUtilisateurDAO.supprimer(reference, idUtilisateur);
			List<Integer> idP = projetUtilisateurDAO.listerIdProjet(u.getIdUtilisateur());
			Iterator<Integer> iterator = idP.iterator();
			List<Projet> p = new ArrayList<Projet>();
			while(iterator.hasNext()){
				p.add(metier.recupererProjet(iterator.next()));
				
			}
			model.setProjets(p);
			//model.setProjets(metier.lister());
		} 
		
		
		//lister projets
		List<Integer> idP = projetUtilisateurDAO.listerIdProjet(u.getIdUtilisateur());
		Iterator<Integer> iterator = idP.iterator();
		List<Projet> p = new ArrayList<Projet>();
		while(iterator.hasNext())
		{
			p.add(metier.recupererProjet(iterator.next()));
		}
		model.setProjets(p);
		request.getRequestDispatcher("/restreint/acceuil.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
	/*	HttpSession session = request.getSession();
		if (session.getAttribute("utilisateur") == null){
			System.out.println("pas connecte");
		}
		Utilisateur u = (Utilisateur) session.getAttribute("utilisateur");
		System.out.println(u.getNom());
		
		AcceuilModel model = new AcceuilModel();
		request.setAttribute("model", model);
		String action = request.getParameter("action");

		if (action != null) {
			if (action.equals("chercher")) {
				/*model.setMotCle(request.getParameter("motCle"));
				List<Projet> p = metier.listerMotCle(model.getMotCle());
				model.setProjets(p);
				
				
				List<Integer> idP = projetUtilisateurDAO.listerIdProjet(u.getIdUtilisateur());
				Iterator<Integer> iterator = idP.iterator();
				List<Projet> p = new ArrayList<Projet>();
				while(iterator.hasNext()){
					p.add(metier.recupererProjet(iterator.next()));
					
				}
				model.setProjets(p);

			} else if (action.equals("delete")) {
				int reference = Integer.parseInt(request.getParameter("ref"));
				int idUtilisateur= Integer.parseInt(request.getParameter("refUtil"));
				
				// String ref = request.getParameter("ref")
				projetUtilisateurDAO.supprimer(reference, idUtilisateur);
				List<Integer> idP = projetUtilisateurDAO.listerIdProjet(u.getIdUtilisateur());
				Iterator<Integer> iterator = idP.iterator();
				List<Projet> p = new ArrayList<Projet>();
				while(iterator.hasNext()){
					p.add(metier.recupererProjet(iterator.next()));
					
				}
				model.setProjets(p);
				//model.setProjets(metier.lister());
			} 
			
		}
		request.getRequestDispatcher("/restreint/acceuil.jsp").forward(request, response);
	*/
	}
}
