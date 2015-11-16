package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.GanttPrevisionelDAOimpl;
import dao.IGanttPrevisionelDAO;
import dao.IProjetUtilisateurDAO;
import dao.ProjetUtilisateurDAOimpl;

/**
 * Servlet implementation class GanttPrevisionel
 */
@WebServlet("/GanttPrevisionel")
public class GanttPrevisionel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idProjet = 1;//Integer.parseInt(request.getParameter("idProjet"));
		
		IProjetUtilisateurDAO projetUtilisateurDAO = new ProjetUtilisateurDAOimpl();
		List<Utilisateur> utilisateurs = projetUtilisateurDAO.listerUtilisateursParProjet(idProjet);
		System.out.println("nbr Devs : "+utilisateurs.size());
		request.setAttribute("developpeurs", utilisateurs);
		
		this.getServletContext().getRequestDispatcher("/restreint/affecterTache.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		IGanttPrevisionelDAO ganttDAO = new GanttPrevisionelDAOimpl();
		
		int idProjet = 0;//Integer.parseInt(request.getParameter("idProjet"));
		int idSprint = 4;//Integer.parseInt(request.getParameter("idSprint"));
		int idUtilisateur = 1;//Integer.parseInt(request.getParameter("idUtilisateur"));
		int idTache = 4;//Integer.parseInt(request.getParameter("idTache"));
		int debut = 0;//Integer.parseInt(request.getParameter("debut"));
		int duree = 2;//Integer.parseInt(request.getParameter("duree"));
		
		ganttDAO.ajouter(idSprint, idUtilisateur, idTache, debut, duree);
		response.sendRedirect("Sprint?idSprint="+idSprint+"&idProjet="+idProjet);
	}

}
