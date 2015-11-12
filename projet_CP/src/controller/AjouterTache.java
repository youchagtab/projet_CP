package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tache;
import dao.ITacheDAO;
import dao.TacheDAOimpl;

/**
 * Servlet implementation class AjouterTache
 */
@WebServlet("/AjouterTache")
public class AjouterTache extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(request.getParameter("idUserStory"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("cout"));
		System.out.println(request.getParameter("tag"));
		int idUS = Integer.parseInt(request.getParameter("idUserStory"));
		String description = request.getParameter("description");
		int cout = Integer.parseInt(request.getParameter("cout"));
		String tag = request.getParameter("tag");
		ITacheDAO tacheDAO = new TacheDAOimpl();
		Tache tache = new Tache(tag, description, cout, "A_FAIRE", idUS);
		tacheDAO.ajouter(tache);
		int idSprint = Integer.parseInt(request.getParameter("idSprint"));
		int idProjet = Integer.parseInt(request.getParameter("idProjet"));
		
		response.sendRedirect("Sprint?idSprint="+idSprint+"&idProjet="+idProjet);
	}

}
