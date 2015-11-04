package controller;

import java.io.IOException;
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
	
			
		this.getServletContext().getRequestDispatcher(VUE_PROJET).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
