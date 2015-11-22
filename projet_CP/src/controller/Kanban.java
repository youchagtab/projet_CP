package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.xalan.xsltc.compiler.sym;

import beans.Tache;
import beans.UserStory;
import beans.Utilisateur;
import dao.GanttPrevisionelDAOimpl;
import dao.IGanttPrevisionelDAO;
import dao.IProjetDAO;
import dao.IProjetUtilisateurDAO;
import dao.ISprintDAO;
import dao.ITacheDAO;
import dao.IUserStoryDAO;
import dao.IUtilisateurDAO;
import dao.ProjetDAOimpl;
import dao.ProjetUtilisateurDAOimpl;
import dao.SprintDAOimpl;
import dao.TacheDAOimpl;
import dao.UserStoryDAOimpl;
import dao.UtilisateurDAOimpl;


@WebServlet("/Kanban")
public class Kanban extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static final String VUE_SPRINT = "/restreint/sprint.jsp";
	public static final String PARAM_ID_TACHE = "idTache";
	public static final String PARAM_ID_SPRINT = "idSprint";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String PARAM_STATUS = "status";
	public static final String ATT_SESSION_UTILISATEUR = "utilisateur";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idTache = Integer.parseInt(request.getParameter(PARAM_ID_TACHE));
		int idSprint = Integer.parseInt(request.getParameter(PARAM_ID_SPRINT));
		int idProjet = Integer.parseInt(request.getParameter(PARAM_ID_PROJET));
		String status = request.getParameter(PARAM_STATUS);
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		
		//Set Utilisateur
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_SESSION_UTILISATEUR);
		tacheDAO.setUtilisateurKanaban(utilisateur.getIdUtilisateur(), idSprint, idTache);
		
		Tache t = tacheDAO.recupererTache(idTache);
		System.out.println("STATUSSS ! : "+status);
		t.setStatus(status);
		t.setDevelopeur(utilisateur);
		tacheDAO.modifier(t);
		
		
		response.sendRedirect("Sprint?idSprint="+idSprint+"&idProjet="+idProjet);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
	}
}
