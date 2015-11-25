package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Sprint;
import beans.UserStory;
import dao.IProjetDAO;
import dao.ISprintDAO;
import dao.IUserStoryDAO;
import dao.ProjetDAOimpl;
import dao.SprintDAOimpl;
import dao.UserStoryDAOimpl;

/**
 * Servlet implementation class Projet
 */
@WebServlet("/Projet")
public class Projet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_PROJET = "/restreint/projet.jsp";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String ATT_PROJET = "projet";
	public static final String ATT_USER_STORIES = "userStories";
	public static final String TOTAL_DIFFICULTeS = "totalDifficultes";
	public static final String LIST_POINTS_DIFFICULTeS = "listPointsDifficultes";
	public static final String DERNIER_POINT = "dernierPoint";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Redirect Projet Afficher");


		String idProjet = request.getParameter(PARAM_ID_PROJET);
		IProjetDAO projetDAO = new ProjetDAOimpl();
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		List<UserStory> userStories = userStoryDAO.lister(Integer.parseInt(idProjet));
		System.out.println("Size : "+userStories.size());

		request.setAttribute(ATT_PROJET, projet);
		request.setAttribute(ATT_USER_STORIES, userStories);



		ISprintDAO sprintDAO = new SprintDAOimpl();
		List<Sprint> sprints = sprintDAO.lister(Integer.parseInt(idProjet));
		request.setAttribute("sprints", sprints);
		request.setAttribute("numero", sprints.size()+1);
		//request.setAttribute("numero", "1");

		//downchart graphic

		/*
		 * tri de la liste de sprints par numero
		 */
		Comparator<Sprint> NUMERO_COMPARATOR = new Comparator<Sprint>() {

			@Override
			public int compare(Sprint o1, Sprint o2) {
				Sprint p=(Sprint) o1;
				Sprint q=(Sprint) o2;
				if(p.getNumero() > q.getNumero()){    
					return 1;
				}
				else return -1;	
			}

		};

		Collections.sort(sprints, NUMERO_COMPARATOR);


		/*
		 * Creation de l liste des points difficultés restantes du burn down chart
		 */

		int totalDiffucultes=userStoryDAO.getTotalDifficultes(Integer.parseInt(idProjet));

		List<Integer> pointsDifficulte=new ArrayList<Integer>();
		pointsDifficulte.add(totalDiffucultes);

		int totalDiffSprints=0;

		Iterator<Sprint> iter3 = sprints.iterator();
		while (iter3.hasNext()) {
			int diff= userStoryDAO.getTotalDifficultesParSprint(iter3.next().getIdSprint());
			if(diff != 0){
				totalDiffSprints+=diff;
				totalDiffucultes=totalDiffucultes-diff;
				pointsDifficulte.add(totalDiffucultes);
			} 
		}
		
		int totalDifficultRestantes=pointsDifficulte.get(pointsDifficulte.size()-1);

		double dernierPoint=(double)((pointsDifficulte.size()-1)* totalDifficultRestantes) / totalDiffSprints;
		
		request.setAttribute(DERNIER_POINT,dernierPoint);
		request.setAttribute(TOTAL_DIFFICULTeS, totalDiffucultes);
		request.setAttribute(LIST_POINTS_DIFFICULTeS, pointsDifficulte);


		this.getServletContext().getRequestDispatcher(VUE_PROJET).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
