package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Projet;
import dao.IProjetDAO;
import dao.ProjetDAOimpl;

/**
 * Servlet implementation class AjouterProjet
 */
@WebServlet("/AjouterProjet")
public class AjouterProjet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE_AJOUTER_PROJET = "/restreint/ajouterprojet.jsp";
	public static final String VUE_ACCEUIL = "/projet_CP/acceuil";
	public static final String PARAM_NOMS = "noms";
	public static final String PARAM_DESCRIPTION = "description";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.getServletContext().getRequestDispatcher(VUE_AJOUTER_PROJET).forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String noms = request.getParameter(PARAM_NOMS);
		String description = request.getParameter(PARAM_DESCRIPTION);
		
		IProjetDAO projetDAO = new ProjetDAOimpl();
		Projet projet = new Projet(noms, description);
		projetDAO.ajouter(projet);
		
		response.sendRedirect(VUE_ACCEUIL);
	}

}
