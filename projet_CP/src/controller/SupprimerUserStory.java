package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUserStoryDAO;
import dao.UserStoryDAOimpl;

/**
 * Servlet implementation class SupprimerUserStory
 */
@WebServlet("/SupprimerUserStory")
public class SupprimerUserStory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String PARAM_ID_USER_STORY = "idUserStory";
	public static final String VUE_PROJET = "/projet_CP/Projet";
	public static final String PARAM_ID_PROJET = "idProjet";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		int idUserStory = Integer.parseInt(request.getParameter(PARAM_ID_USER_STORY));
		userStoryDAO.supprimer(idUserStory);
		int idProjet = Integer.parseInt(request.getParameter(PARAM_ID_PROJET));
		response.sendRedirect(VUE_PROJET+"?idProjet="+idProjet);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
