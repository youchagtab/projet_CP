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

import org.apache.xalan.xsltc.compiler.sym;

import beans.Tache;
import beans.UserStory;
import beans.Utilisateur;
import dao.GanttPrevisionelDAOimpl;
import dao.IGanttPrevisionelDAO;
import dao.IProjetDAO;
import dao.IProjetUtilisateurDAO;
import dao.ISprintDAO;
import dao.ITacheDAO;
import dao.IUserStoryDAO;
import dao.IUtilisateurDAO;
import dao.ProjetDAOimpl;
import dao.ProjetUtilisateurDAOimpl;
import dao.SprintDAOimpl;
import dao.TacheDAOimpl;
import dao.UserStoryDAOimpl;
import dao.UtilisateurDAOimpl;
@WebServlet("/Sprint")
public class Sprint extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String VUE_SPRINT = "/restreint/sprint.jsp";
	public static final String PARAM_ID_PROJET = "idProjet";
	public static final String ATT_PROJET = "projet";
	public static final String ATT_USER_STORIES = "userStories";
	public static final String ATT_SPRINT = "idSprint";
	public static final String ATT_TACHE = "taches";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String idProjet = request.getParameter(PARAM_ID_PROJET);
		String idSprint = request.getParameter(ATT_SPRINT);
		
		
		IProjetDAO projetDAO = new ProjetDAOimpl();
		
		
		beans.Projet projet = projetDAO.recupererProjet(Integer.parseInt(idProjet));
		IUserStoryDAO userStoryDAO = new UserStoryDAOimpl();
		
		System.out.println(idSprint);
		List<UserStory> userStories = userStoryDAO.listerParSprint(Integer.parseInt(idSprint));
		System.out.println(userStories.size());
		
		System.out.println("Size : "+userStories.size());
		request.setAttribute(ATT_PROJET, projet);
		request.setAttribute(ATT_USER_STORIES, userStories);
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		List<List<Tache>> taches = new ArrayList<List<Tache>>();
	
		for(int i= 0 ; i< userStories.size(); i++){
			
			List<Tache> tmpTaches = tacheDAO.listerParUserStory(userStories.get(i).getIdUS());
			taches.add(tmpTaches);
			/*test*/
		}
		ISprintDAO sprintDAO = new SprintDAOimpl();
		beans.Sprint sprint = sprintDAO.recupererSprint(Integer.parseInt(idSprint));
		request.setAttribute(ATT_TACHE, taches);
		request.setAttribute("sprint",sprint);
		
		
		
		request.setAttribute("sprint", sprint);
		request.setAttribute("projet", projet);
		
		List<Tache> aFaire = tacheDAO.listerTache(Integer.parseInt(idSprint), "A_FAIRE");
		List<Tache> enCours = tacheDAO.listerTache(Integer.parseInt(idSprint), "EN_COURS");
		List<Tache> fait= tacheDAO.listerTache(Integer.parseInt(idSprint), "FAIT");
		/*List<Tache> tachesKanabn = new ArrayList<Tache>();
		tachesKanabn.addAll(aFaire);
		tachesKanabn.addAll(enCours);
		tachesKanabn.addAll(fait);*/
		
		int taillemax =0;
		if(aFaire.size() > taillemax)
			taillemax = aFaire.size();
		if(enCours.size() > taillemax)
			taillemax = enCours.size();
		if(fait.size()>taillemax)
			taillemax= fait.size();
			
		request.setAttribute("tacheAFaire", tacheDAO.listerTache(Integer.parseInt(idSprint), "A_FAIRE"));
		
		request.setAttribute("tacheEnCours", tacheDAO.listerTache(Integer.parseInt(idSprint), "EN_COURS"));
		request.setAttribute("tacheFinis", tacheDAO.listerTache(Integer.parseInt(idSprint), "FAIT"));
		//System.out.println("SIZE OF KANBAN"+tachesKanabn.size());
		//request.setAttribute("tachesKanabn", tachesKanabn);
		request.setAttribute("tailleListeLongue", taillemax);
		
		IProjetUtilisateurDAO projetUtilisateurDAO = new ProjetUtilisateurDAOimpl(); 
		List<Integer> idCollaborateur = projetUtilisateurDAO.listerIdUtilisateurs(Integer.parseInt(idProjet));
	
		
		IGanttPrevisionelDAO ganttPrevisionelDAO = new GanttPrevisionelDAOimpl();
		boolean exist =ganttPrevisionelDAO.exist(Integer.parseInt(idSprint));
		if(exist){
			
		HashMap<Integer, List<Tache>> ListTachedeIdCollaborateur = new HashMap<Integer, List<Tache>>();
		
		int maxdate =0;
		for(Integer i:idCollaborateur){
			List<Tache>tachesPartielDuGantt = ganttPrevisionelDAO.recuperer(Integer.parseInt(idSprint),i);
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
			
		
		
		
		this.getServletContext().getRequestDispatcher(VUE_SPRINT).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
	}
	
	
}
