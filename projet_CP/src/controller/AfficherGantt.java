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

import beans.Projet;
import beans.Tache;
import beans.Utilisateur;
import dao.GanttPrevisionelDAOimpl;
import dao.IGanttPrevisionelDAO;
import dao.IProjetDAO;
import dao.IProjetUtilisateurDAO;
import dao.ISprintDAO;
import dao.ITacheDAO;
import dao.IUtilisateurDAO;
import dao.ProjetDAOimpl;
import dao.ProjetUtilisateurDAOimpl;
import dao.SprintDAOimpl;
import dao.TacheDAOimpl;
import dao.UtilisateurDAOimpl;


@WebServlet("/AfficherGantt")
public class AfficherGantt extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VUE_GANTT = "/restreint/GantTest.jsp";
	
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String PARAM_ID_SPRINT = "idSprint";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int idProjet = Integer.parseInt(request.getParameter(PARAM_ID_PROJET));
		int idSprint= Integer.parseInt(request.getParameter(PARAM_ID_SPRINT));
		
		IProjetDAO projetDAO = new ProjetDAOimpl();
		beans.Projet projet = projetDAO.recupererProjet(idProjet);
		
		ISprintDAO sprintDAO = new SprintDAOimpl();
		beans.Sprint sprint = sprintDAO.recupererSprint(idSprint);
		
		request.setAttribute("sprint", sprint);
		request.setAttribute("projet", projet);
		
		
		IProjetUtilisateurDAO projetUtilisateurDAO = new ProjetUtilisateurDAOimpl(); 
		List<Integer> idCollaborateur = projetUtilisateurDAO.listerIdUtilisateurs(idProjet);
	
		
		IGanttPrevisionelDAO ganttPrevisionelDAO = new GanttPrevisionelDAOimpl();
		boolean exist =ganttPrevisionelDAO.exist(idSprint);
		if(exist){
			
		HashMap<Integer, List<Tache>> ListTachedeIdCollaborateur = new HashMap<Integer, List<Tache>>();
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		
		int maxdate =0;
		for(Integer i:idCollaborateur){
			List<Tache>tachesPartielDuGantt = ganttPrevisionelDAO.recuperer(idSprint,i);
			List<Tache>tachesDuGantt = new ArrayList<Tache>();
			for(Tache t: tachesPartielDuGantt){
				Tache tacheTotale = tacheDAO.recupererTache(t.getIdTache());
				tacheTotale.setDebut(t.getDebut());
				tacheTotale.setDuree(t.getDuree());
				if(maxdate<t.getDebut()+t.getDuree()){
					maxdate = t.getDebut()+t.getDuree();
				}
				tachesDuGantt.add(tacheTotale);
			}
			ListTachedeIdCollaborateur.put(i, tachesDuGantt);
		}
		
		HashMap<Integer, Tache[]> ganttParIdCollaborateur = new HashMap<Integer, Tache[]>();
		for(Integer i:idCollaborateur){
			Tache[] tableau = new Tache[maxdate];
			
			for(int j=0; j<maxdate;j++){
				Tache vide = new Tache("", "", 0, "", 0);
			    vide.setDebut(0);
			    vide.setDuree(1);
				tableau[j]=vide;
			}
			for(Tache t : ListTachedeIdCollaborateur.get(i)){
				for(int j=t.getDebut();j<t.getDebut()+t.getDuree();j++){
					tableau[j]=t;
				}
			}
			ganttParIdCollaborateur.put(i, tableau);
		}
		IUtilisateurDAO utilisateurDAO = new UtilisateurDAOimpl();
		List<Utilisateur> collaborateurs= new ArrayList<Utilisateur>();
		for(Integer i:idCollaborateur){
			Utilisateur c = utilisateurDAO.recupererUtilisateur(i);
			collaborateurs.add(c);
		}
		request.setAttribute("maxdate", maxdate);
		request.setAttribute("collaborateurs", collaborateurs);
		request.setAttribute("GanttParIdCollaborateur", ganttParIdCollaborateur);
		}
		request.setAttribute("Ganttexist", exist);
		this.getServletContext().getRequestDispatcher(VUE_GANTT).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}
}

