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
 * Servlet implementation class SupprimerTache
 */
@WebServlet("/SupprimerTache")
public class SupprimerTache extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ITacheDAO tacheDAO = new TacheDAOimpl();
		Tache tache = new Tache();
		int idTache = Integer.parseInt(request.getParameter("idTache"));
		tache.setIdTache(idTache);
		tacheDAO.supprimer(tache);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
