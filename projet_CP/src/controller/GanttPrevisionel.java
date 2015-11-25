package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tache;
import beans.Utilisateur;
import dao.GanttPrevisionelDAOimpl;
import dao.IGanttPrevisionelDAO;
import dao.IProjetUtilisateurDAO;
import dao.ITacheDAO;
import dao.ProjetUtilisateurDAOimpl;
import dao.TacheDAOimpl;

/**
 * Servlet implementation class GanttPrevisionel
 */
@WebServlet("/AffectationTache")
public class GanttPrevisionel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idProjet = Integer.parseInt(request.getParameter("idProjet"));
		int idTache = Integer.parseInt(request.getParameter("idTache"));
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		Tache tache = tacheDAO.recupererTache(idTache);
		
		IProjetUtilisateurDAO projetUtilisateurDAO = new ProjetUtilisateurDAOimpl();
		List<Utilisateur> utilisateurs = projetUtilisateurDAO.listerUtilisateursParProjet(idProjet);
		
		request.setAttribute("developpeurs", utilisateurs);
		request.setAttribute("tache", tache);
		this.getServletContext().getRequestDispatcher("/restreint/affecterTache.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		IGanttPrevisionelDAO ganttDAO = new GanttPrevisionelDAOimpl();
		
		int idProjet = Integer.parseInt(request.getParameter("idProjet"));
		int idSprint = Integer.parseInt(request.getParameter("idSprint"));
		int idUtilisateur =Integer.parseInt(request.getParameter("idUtilisateur"));
		int idTache = Integer.parseInt(request.getParameter("idTache"));
		if(request.getParameter("debut") != null && request.getParameter("duree")!=null && !request.getParameter("debut").isEmpty() && !request.getParameter("duree").isEmpty()){
		int debut = Integer.parseInt(request.getParameter("debut"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		
		System.out.println("idSprint : "+idSprint
				+ "idUtilisateur : "+idUtilisateur
				+ "idTache : "+idTache
				+ "debut : "+debut
				+ "duree : "+duree);
		
		ganttDAO.ajouter(idSprint, idUtilisateur, idTache, debut, duree);
		}
		response.sendRedirect("Sprint?idSprint="+idSprint+"&idProjet="+idProjet);
	}

}
