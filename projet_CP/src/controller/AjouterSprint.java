package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.impl.cookie.IgnoreSpecProvider;

import beans.Sprint;
import dao.ISprintDAO;
import dao.SprintDAOimpl;


@WebServlet("/AjouterSprint")
public class AjouterSprint extends HttpServlet {

	
    
	public static final String VUE_PROJET = "/projet_CP/Projet";
	public static final String PARAM_NUMERO = "numero";
	public static final String PARAM_ID_PROJET = "idProjet";
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int numero = Integer.parseInt(request.getParameter(PARAM_NUMERO));
		int idProjet = Integer.parseInt(request.getParameter(PARAM_ID_PROJET));
		Sprint sprint = new Sprint(idProjet, numero);
		
		ISprintDAO sprintDao = new SprintDAOimpl();
		sprintDao.ajouter(sprint);
		response.sendRedirect(VUE_PROJET+"?idProjet="+idProjet);
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	
}
