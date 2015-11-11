package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xalan.xsltc.compiler.sym;

import beans.Tache;
import beans.UserStory;
import dao.IProjetDAO;
import dao.ISprintDAO;
import dao.ITacheDAO;
import dao.IUserStoryDAO;
import dao.ProjetDAOimpl;
import dao.SprintDAOimpl;
import dao.TacheDAOimpl;
import dao.UserStoryDAOimpl;
@WebServlet("/Sprint")
public class Sprint extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE_SPRINT = "/restreint/sprint.jsp";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String ATT_PROJET = "projet";
	public static final String ATT_USER_STORIES = "userStories";
	public static final String ATT_SPRINT = "idSprint";
	public static final String ATT_TACHE = "taches";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String idProjet = request.getParameter(PARAM_ID_PROJET);
		String idSprint = request.getParameter(ATT_SPRINT);
		
		
		IProjetDAO projetDAO = new ProjetDAOimpl();
		
		
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		
		System.out.println(idSprint);
		List<UserStory> userStories = userStoryDAO.listerParSprint(Integer.parseInt(idSprint));
		System.out.println(userStories.size());
		
		System.out.println("Size : "+userStories.size());
		request.setAttribute(ATT_PROJET, projet);
		request.setAttribute(ATT_USER_STORIES, userStories);
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		List<List<Tache>> taches = new ArrayList<List<Tache>>();
	
		for(int i= 1 ; i< userStories.size(); i++){
			
			List<Tache> tmpTaches = tacheDAO.listerParUserStory(userStories.get(i).getIdUS());
			taches.add(tmpTaches);
			/*test*/
		}
		ISprintDAO sprintDAO = new SprintDAOimpl();
		beans.Sprint sprint = sprintDAO.recupererSprint(Integer.parseInt(idSprint));
		request.setAttribute(ATT_TACHE, taches);
		request.setAttribute("sprint",sprint);
		
		
			
		
		
		
		this.getServletContext().getRequestDispatcher(VUE_SPRINT).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
	}
	
	
}
