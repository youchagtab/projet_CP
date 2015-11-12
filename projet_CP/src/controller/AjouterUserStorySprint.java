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
import dao.ITacheDAO;
import dao.IUserStoryDAO;
import dao.ProjetDAOimpl;
import dao.SprintDAOimpl;
import dao.TacheDAOimpl;
import dao.UserStoryDAOimpl;

@WebServlet("/AjouterUserStorySprint")
public class AjouterUserStorySprint extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public static final String VUE_AJOUTER_USER_STORY_SPRINT = "/restreint/ajouteruserstorysprint.jsp";
	public static final String ATT_USER_STORIES = "userStories";
	public static final String ATT_USER_STORIES_SPRINT = "userStoriesSprint";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String PARAM_ID_SPRINT = "idSprint";
	public static final String PARAM_ID_TACHE = "idTache";
	public static final String VUE_PROJET = "/restreint/projet.jsp";


	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idProjet = request.getParameter(PARAM_ID_PROJET);
		String idSprint= request.getParameter(PARAM_ID_SPRINT);
		IProjetDAO projetDAO = new ProjetDAOimpl();
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		List<UserStory> userStories;
		List<UserStory> userStoriesSprint;

		userStories = userStoryDAO.listerParNotInSprint(Integer.parseInt(idProjet),Integer.parseInt(idSprint));
		userStoriesSprint = userStoryDAO.listerParSprint(Integer.parseInt(idSprint));
		//listeruser story qui n'existe pas dans sprint params (idProjet + listeUSSprint)
		System.out.println("Size : "+userStories.size());
		
		request.setAttribute("projet", projet);
		request.setAttribute(ATT_USER_STORIES, userStories);
		request.setAttribute(ATT_USER_STORIES_SPRINT, userStoriesSprint);
		
		
		
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_USER_STORY_SPRINT).forward(request, response);

		

	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		int idSprint = Integer.parseInt(request.getParameter("idSprint"));
		int idProjet = Integer.parseInt(request.getParameter("idProjet"));
		String[] idUserStories = request.getParameterValues("userstories");
		for(String idUserStory : idUserStories)
		{
			System.out.println(Integer.parseInt(idUserStory)+" > "+idSprint);
			userStoryDAO.ajouterUserStoryToSprint(idSprint, Integer.parseInt(idUserStory));
			
		}
		System.out.println(">>> "+idUserStories.length);
		response.sendRedirect("AjouterUserStorySprint?idSprint="+idSprint+"&idProjet="+idProjet);
	}
}
