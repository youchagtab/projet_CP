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
 * Servlet implementation class AjouterUserStory
 */
@WebServlet("/AjouterUserStory")
public class AjouterUserStory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String VUE_AJOUTER_USER_STORY = "/restreint/ajouteruserstory.jsp";
	public static final String VUE_PROJET = "/projet_CP/Projet";
	public static final String PARAM_DESCRITPION = "description";
	public static final String PARAM_DIFFICULTE = "difficulte";
	public static final String PARAM_PRIORITE = "priorite";
	public static final String PARAM_ID_PROJET = "idProjet";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_USER_STORY)
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter(PARAM_DESCRITPION) != null
				&& request.getParameter(PARAM_DIFFICULTE) != null
				&& request.getParameter(PARAM_PRIORITE) != null
				&& !request.getParameter(PARAM_DESCRITPION).isEmpty()
				&& !request.getParameter(PARAM_DIFFICULTE).isEmpty()
				&& !request.getParameter(PARAM_PRIORITE).isEmpty()) {
		

		String description = request.getParameter(PARAM_DESCRITPION);
		int difficulte = Integer.parseInt(request
				.getParameter(PARAM_DIFFICULTE));
		int priorite = Integer.parseInt(request.getParameter(PARAM_PRIORITE));
		int idProjet = Integer.parseInt(request.getParameter(PARAM_ID_PROJET));

		UserStory userStory = new UserStory(description, difficulte, priorite,
				idProjet);

		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		userStoryDAO.ajouter(userStory);
		System.out.println(VUE_PROJET + "?idProjet=" + idProjet);
		request.setAttribute(PARAM_ID_PROJET, idProjet);
		response.sendRedirect(VUE_PROJET + "?idProjet=" + idProjet);
		}else{
			request.setAttribute("erreur", "veuillez remplir tout les champ");
			this.getServletContext().getRequestDispatcher(VUE_AJOUTER_USER_STORY)
			.forward(request, response);
		}
		
	}

}
