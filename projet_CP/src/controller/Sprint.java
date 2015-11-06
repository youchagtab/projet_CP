package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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

public class Sprint extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE_SPRINT = "/restreint/sprint.jsp";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String ATT_PROJET = "projet";
	public static final String ATT_USER_STORIES = "userStories";
	public static final String ATT_SPRINT = "sprint";
	public static final String ATT_TACHE = "taches";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String idProjet = request.getParameter(PARAM_ID_PROJET);
		String idSprint = request.getParameter(ATT_SPRINT);
		
		
		IProjetDAO projetDAO = new ProjetDAOimpl();
		
		
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		
		
		List<UserStory> userStories = userStoryDAO.listerParSprint(Integer.parseInt(idSprint));
		
		
		System.out.println("Size : "+userStories.size());
		request.setAttribute(ATT_PROJET, projet);
		request.setAttribute(ATT_USER_STORIES, userStories);
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		for(int i= 1 ; i< userStories.size(); i++){
			
			List<Tache> taches = tacheDAO.listerParSprint(Integer.parseInt(idSprint));/*a modifier */
			request.setAttribute(ATT_TACHE, taches);
			
			
		}
		
	
		
		
		
		this.getServletContext().getRequestDispatcher(VUE_SPRINT).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
	}
	
	
}
