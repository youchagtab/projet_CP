package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserStory;
import dao.IUserStoryDAO;
import dao.UserStoryDAOimpl;

/**
 * Servlet implementation class ModifierUserStory
 */
@WebServlet("/ModifierUserStory")
public class ModifierUserStory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String VUE_MODIFIER_USER_STORY = "/restreint/modifieruserstory.jsp";
	public static final String PARAM_ID_USER_STORY = "idUserStory";
	public static final String ATT_USER_STORY = "userStory";
	public static final String VUE_PROJET = "/projet_CP/Projet";
	public static final String PARAM_DESCRITPION = "description";
	public static final String PARAM_DIFFICULTE = "difficulte";
	public static final String PARAM_PRIORITE = "priorite";
	public static final String PARAM_ID_PROJET = "idProjet";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		int iduserStory = Integer.parseInt(request.getParameter(PARAM_ID_USER_STORY));
		UserStory userStory = userStoryDAO.recupererUserStory(iduserStory);
		request.setAttribute(ATT_USER_STORY, userStory);
		this.getServletContext().getRequestDispatcher(VUE_MODIFIER_USER_STORY).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String description = request.getParameter(PARAM_DESCRITPION);
		int difficulte = Integer.parseInt(request.getParameter(PARAM_DIFFICULTE));
		int priorite = Integer.parseInt(request.getParameter(PARAM_PRIORITE));
		int idProjet = Integer.parseInt(request.getParameter(PARAM_ID_PROJET));
		int idUS = Integer.parseInt(request.getParameter(PARAM_ID_USER_STORY));
		
		UserStory userStory = new UserStory(idUS, description, difficulte, priorite, idProjet);
		
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		userStoryDAO.modifier(userStory);
		System.out.println(VUE_PROJET+"?idProjet="+idProjet);
		request.setAttribute(PARAM_ID_PROJET, idProjet);
		response.sendRedirect(VUE_PROJET+"?idProjet="+idProjet);
	}

}
