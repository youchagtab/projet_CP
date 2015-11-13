package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tache;
import beans.UserStory;
import dao.IProjetDAO;
import dao.ITacheDAO;
import dao.IUserStoryDAO;
import dao.ProjetDAOimpl;
import dao.TacheDAOimpl;
import dao.UserStoryDAOimpl;

/**
 * Servlet implementation class DependanceEntreTaches
 */
@WebServlet("/DependanceEntreTaches")
public class DependanceEntreTaches extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String PARAM_ID_SPRINT = "idSprint";
	public static final String PARAM_ID_TACHE = "idTache";
	public static final String PARAM_USER_STORY = "idUS";
	public static final String ATT_TACHE = "Taches";
	
	public static final String VUE_DEPENDANCE_TACHES = "/restreint/tachedependances.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String idProjet = request.getParameter(PARAM_ID_PROJET);
		//String idSprint= request.getParameter(PARAM_ID_SPRINT);
		String idTache= request.getParameter(PARAM_ID_TACHE);
		String idUS= request.getParameter(PARAM_USER_STORY);
		
		
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		IProjetDAO projetDAO = new ProjetDAOimpl();
		//beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		beans.UserStory userstory = userStoryDAO.recupererUserStory(Integer.parseInt(idUS));
		ITacheDAO tacheDAO = new TacheDAOimpl();
		beans.Tache tache = tacheDAO.recupererTache(Integer.parseInt(idTache));
		List<Tache> Taches;
		Taches = tacheDAO.listerParUserStory(Integer.parseInt(idUS));
		request.setAttribute(ATT_TACHE, Taches);
		request.setAttribute("userstory", userstory);
		//request.setAttribute("projet", projet);
		
		/*
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
		*/
		
		
		this.getServletContext().getRequestDispatcher(VUE_DEPENDANCE_TACHES).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
