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
import dao.ISprintDAO;
import dao.ITacheDAO;
import dao.IUserStoryDAO;
import dao.ProjetDAOimpl;
import dao.SprintDAOimpl;
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
	public static final String ATT_TACHES = "taches";
	public static final String ATT_TACHES_DEP = "tachesDep";
	public static final String ATT_TACHE = "tache";
	
	public static final String VUE_DEPENDANCE_TACHES = "/restreint/tachedependances.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
		String idSprint= request.getParameter(PARAM_ID_SPRINT);
		String idTache= request.getParameter(PARAM_ID_TACHE);
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		ISprintDAO sprintDAO = new SprintDAOimpl();
		
	    beans.Sprint sprint = sprintDAO.recupererSprint(Integer.parseInt(idSprint));
		
		
		
		beans.Tache tache = tacheDAO.recupererTache(Integer.parseInt(idTache));
		System.out.println("tache:" +idTache);
		List<Tache> taches;
		List<Tache> tachesDep;
		taches = tacheDAO.listerParSprintNotDep(Integer.parseInt(idSprint),Integer.parseInt(idTache));
		tachesDep = tacheDAO.listerDependanceTaches(Integer.parseInt(idTache));
		request.setAttribute(ATT_TACHES, taches);
		request.setAttribute(ATT_TACHES_DEP, tachesDep);
		
		request.setAttribute("sprint", sprint);
		request.setAttribute(ATT_TACHE, tache);
		System.out.println("tache:" + tache.getDescription());
		/*
		String idProjet = request.getParameter("PARAM_ID_PROJET");
		IProjetDAO projetDAO = new ProjetDAOimpl();
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		request.setAttribute("projet ", projet);
		*/
		
		
		
		this.getServletContext().getRequestDispatcher(VUE_DEPENDANCE_TACHES).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ITacheDAO tacheDAO =new TacheDAOimpl();
		int idSprint = Integer.parseInt(request.getParameter("idSprint"));
		int idTache = Integer.parseInt(request.getParameter("idTache"));
		if(request.getParameterValues("tachescheckbox")!= null){
		String[] taches = request.getParameterValues("tachescheckbox");
		for(String t : taches)
		{
		
			
			tacheDAO.ajouterTacheToDep(idTache, Integer.parseInt(t));
			
			
		}
		}
		response.sendRedirect("DependanceEntreTaches?idSprint="+idSprint+"&idTache="+idTache);

	}

}
