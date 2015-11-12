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
 * Servlet implementation class SupprimerUserStorySprint
 */
@WebServlet("/SupprimerUserStorySprint")
public class SupprimerUserStorySprint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		int idSprint = Integer.parseInt(request.getParameter("idSprint"));
		int idProjet = Integer.parseInt(request.getParameter("idProjet"));
		String[] idUserStories = request.getParameterValues("userstories");
		for(String idUserStory : idUserStories)
		{
			System.out.println(Integer.parseInt(idUserStory)+" > "+idSprint);
			userStoryDAO.supprimer(idSprint, Integer.parseInt(idUserStory));
			
		}
		System.out.println(">>> "+idUserStories.length);
		response.sendRedirect("AjouterUserStorySprint?idSprint="+idSprint+"&idProjet="+idProjet);
	}

}
