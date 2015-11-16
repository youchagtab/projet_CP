package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.IProjetDAO;
import dao.IProjetUtilisateurDAO;
import dao.IUtilisateurDAO;
import dao.ProjetDAOimpl;
import dao.ProjetUtilisateurDAOimpl;
import dao.UtilisateurDAOimpl;


@WebServlet("/SupprimerCollaborateurs")
public class supprimerCollaborateur extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String IDs_COLLABORATEURS_A_SUPPRIMER= "ajoutCollaborateurs";


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] collaborateursSelect = request.getParameterValues(IDs_COLLABORATEURS_A_SUPPRIMER);
		String idProjet = request.getParameter(PARAM_ID_PROJET);


		//recuperation collabs existants
		IProjetUtilisateurDAO projetUtilisateur = new ProjetUtilisateurDAOimpl();

		
	
        if( collaborateursSelect!=null){
			for(int j=0; j<collaborateursSelect.length;j++){
				int idCollaborateur = Integer.parseInt(collaborateursSelect[j]);
				System.out.println(idCollaborateur);
				projetUtilisateur.supprimer(Integer.parseInt(idProjet), idCollaborateur);
			} 
		} else{
			System.out.println("pas de choix faits pour retirer");
		}

        response.sendRedirect("AjouterCollaborateurs?idProjet="+idProjet);


	}



}
