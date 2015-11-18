package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GanttPrevisionelDAOimpl;
import dao.IGanttPrevisionelDAO;

/**
 * Servlet implementation class SupprimerAffectation
 */
@WebServlet("/SupprimerAffectation")
public class SupprimerAffectation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idProjet = Integer.parseInt(request.getParameter("idProjet"));
		int idSprint = Integer.parseInt(request.getParameter("idSprint"));
		int idTache = Integer.parseInt(request.getParameter("idTache"));
		
		IGanttPrevisionelDAO ganttPrevisionelDAO = new GanttPrevisionelDAOimpl();
		ganttPrevisionelDAO.supprimer(idSprint, idTache);
		
		response.sendRedirect("Sprint?idSprint="+idSprint+"&idProjet="+idProjet);
	}

}
