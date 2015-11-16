package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ITacheDAO;
import dao.TacheDAOimpl;
@WebServlet("/SupprimerDependanceEntreTaches")
public class SupprimerDependanceEntreTaches extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		

		ITacheDAO tacheDAO =new TacheDAOimpl();
		int idSprint = Integer.parseInt(request.getParameter("idSprint"));
		int idTache = Integer.parseInt(request.getParameter("idTache"));
		
		String[] taches = request.getParameterValues("tachescheckbox");
		for(String t : taches)
		{
		
			
			tacheDAO.supprimer(idTache, Integer.parseInt(t));
			
		}
		response.sendRedirect("DependanceEntreTaches?idSprint="+idSprint+"&idTache="+idTache);
		
	}
	
}
