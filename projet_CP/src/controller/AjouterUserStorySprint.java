package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserStory;
import dao.IProjetDAO;
import dao.ISprintDAO;
import dao.IUserStoryDAO;
import dao.ProjetDAOimpl;
import dao.SprintDAOimpl;
import dao.UserStoryDAOimpl;

@WebServlet("/AjouterUserStorySprint")
public class AjouterUserStorySprint extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public static final String VUE_AJOUTER_USER_STORY_SPRINT = "/restreint/ajouteruserstorysprint.jsp";
	public static final String ATT_USER_STORIES = "userStories";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String PARAM_ID_SPRINT = "idSprint";
	public static final String VUE_PROJET = "/restreint/projet.jsp";


	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idProjet = request.getParameter(PARAM_ID_PROJET);
		IProjetDAO projetDAO = new ProjetDAOimpl();
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		List<UserStory> userStories;
		
		userStories = userStoryDAO.lister(Integer.parseInt(idProjet));
		System.out.println("Size : "+userStories.size());
		
		request.setAttribute("projet", projet);
		request.setAttribute(ATT_USER_STORIES, userStories);
		
		
		
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_USER_STORY_SPRINT).forward(request, response);

		

	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idSprint = request.getParameter(PARAM_ID_SPRINT);
		ISprintDAO sprintDAO= new SprintDAOimpl();
		beans.Sprint sprint ;
		
		
		String[] res = request.getParameterValues("userstories");
		
			for (int i = 0; i < res.length; ++i){ 
			
				
			} 
			
			this.getServletContext().getRequestDispatcher(VUE_PROJET).forward(request, response);
		
		
	}
}
