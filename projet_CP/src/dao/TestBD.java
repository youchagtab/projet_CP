package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.Commit;
import beans.Projet;
import beans.Sprint;
import beans.Tache;
import beans.UserStory;
import beans.Utilisateur;

public class TestBD {

	public static void main(String[] args) {
		System.out.println("test bdd");
		testCommit();
	    //testGranttPrevisionelDAO();
		/*test sprint*/
		//testTache();

		//testTacheDAO();
		testAjouterTacheSprint();

		

		/*testUserStoryDAO();
		try{
		IProjetDAO projet = new ProjetDAOimpl();
		Projet p = projet.recupererProjet(2);
		System.out.println(p.getDescription() + p.getNoms());
		p.setDescription("modification de la description 2");
		projet.modifierProjet(p);
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}*/
		
		
		
		
		
		/*---------------------test pour lister les projets-- Done-------*/
		/*IProjetDAO projet = new ProjetDAOimpl();
		List<Projet> pro = projet.listerMotCle("s");
		for(Projet p : pro){
			System.out.println(p.getIdProjet()+ "  " + p.getNoms()+ "  " + p.getDescription());
		}*/
		
		
		
		
	/*-------------test pour ajouter un projet----Done--------------------*/
/*
		IProjetDAO p = new ProjetDAOimpl();
		String _description = "pas de description pour le moment";
		String _noms = "projet 5";
		Projet proj = new Projet(_noms, _description);
		Projet proj1 = new Projet("conception formmel", "dernier delai fin aout");
		p.ajouter(proj);
		p.ajouter(proj1);
	*/	
		
		/*-------------test pour ajouter utilisateur------Done-------------*/
		//testProjet();
				/*IUtilisateurDAO utilisateur = new UtilisateurDAOimpl();
				Utilisateur u = new Utilisateur("paulseb", "mdp", "paul", "sebastien");
				utilisateur.ajouter(u);
				System.out.println(u.getIdUtilisateur());
			}*/
		
		//testUtilisateur();
		//testProjet();
		/*IUtilisateurDAO utilisateur = new UtilisateurDAOimpl();
		Utilisateur u = new Utilisateur("paulseb", "mdp", "paul", "sebastien");
		utilisateur.ajouter(u);
		System.out.println(u.getIdUtilisateur());*/
	}
	public static void testTache()
	{
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		//Tache tache = new Tache(8,"AVION", "AIREPORT", 2, "FAIT", 63);
		//tacheDAO.modifier(tache);
		//Tache tache = tacheDAO.recupererTache(3);
		//System.out.println(tache.getDescription());
		List<Tache> taches = new ArrayList<Tache>();
		taches = tacheDAO.listerDependanceTaches(1);
		System.out.println(taches.size());
		System.out.println(taches.get(2).getDescription());
		
	}
	public static void testSprint()
	{
		ISprintDAO sprintDAO = new SprintDAOimpl();
		//Sprint sprint = sprintDAO.recupererSprint(5);
		//System.out.println("id "+sprint.getIdSprint()+" idProjet "+sprint.getIdProjet()+" numero "+sprint.getNumero());
		List<Sprint> sprints = new ArrayList<Sprint>();
		sprints = sprintDAO.lister(2);
		System.out.println(sprints.size());
		//sprintDAO.ajouter(sprint);
		//sprint.setNumero(6);
		//sprint.setIdSprint(6);
		//sprintDAO.modifier(sprint);
		//sprintDAO.supprimer(sprint);
	}
	
	public static void testUtilisateur(){
		IUtilisateurDAO utilisateurDAO = new UtilisateurDAOimpl();
		Utilisateur u = utilisateurDAO.recupererUtilisateur("Olivier");
		System.out.println(utilisateurDAO.existanceIdentifiant("Olivier"));
		System.out.println(utilisateurDAO.existanceIdentifiant("OlivierR"));
		System.out.println(utilisateurDAO.verificationConnexion("Olivier", "password"));
		System.out.println(utilisateurDAO.verificationConnexion("Olivier", "passrword"));
		u.setNom("ConStanS");
		utilisateurDAO.modifier(u);
		List<Utilisateur> list = utilisateurDAO.lister();
		System.out.println(list);
	}
	
	/*public static void testProjet(){
		IProjetDAO projetDAO = new ProjetDAOimpl();
		Utilisateur u = new Utilisateur(4,"Olivier","password","Constans","Olivier");
		Projet p = new Projet(u,"test 1","test1");
		projetDAO.ajouter(p);
		System.out.println(p.getIdProjet());
		
		//projetDAO.supprimer(p);
		projetDAO.supprimer(p.getIdProjet());
	}*/
	
	public static void testUserStoryDAO(){
		IUserStoryDAO USDAO = new UserStoryDAOimpl();
		//UserStory us = new UserStory("Test main UserStoryDAO",1,1,1);
		//USDAO.ajouter(us);
		List<UserStory>listUS =USDAO.listerParSprint(3);
		Iterator<UserStory> it = listUS.iterator();
		while(it.hasNext()){
			UserStory UStmp = it.next();
			System.out.println("ID:"+UStmp.getIdUS()+""
					         + "Description:"+UStmp.getDescription()+","
					         + " Difficulte:"+ UStmp.getDifficulte()+","
					         + " Priorite:"+ UStmp.getDifficulte()+","
					         + "IDProjet:"+UStmp.getIdProjet());
		}
		//us.setDescription("Vive les tests");
		//USDAO.modifier(us);
		
		
	}
	
	public static void testGranttPrevisionelDAO(){
		IGanttPrevisionelDAO GanttPrevisionelDAO = new GanttPrevisionelDAOimpl();
		int idSprint = 4;

		//GanttPrevisionelDAO.ajouter(idSprint, 4, 1, 4, 10);
		//GanttPrevisionelDAO.ajouter(idSprint, 4, 2, 14, 10);
		//GanttPrevisionelDAO.ajouter(idSprint, 4, 3, 0, 2);
		//GanttPrevisionelDAO.ajouter(idSprint, 4, 4, 2, 1);
		//GanttPrevisionelDAO.modifier(idSprint, 4, 4, 2, 2);
		//GanttPrevisionelDAO.supprimer(idSprint, 4, 2);
		List<Tache> taches = GanttPrevisionelDAO.recuperer(idSprint, 4);
		Iterator<Tache> it = taches.iterator();
		while(it.hasNext()){
			Tache t = it.next();
			System.out.println("ID:"+t.getIdTache()+""
					+ "Debut:"+t.getDebut()+","
					+ " Duree:"+ t.getDuree()+"\n");
		}
	}
	
	
	public static void testAjouterTacheSprint(){
		
		ITacheDAO tacheDAO = new TacheDAOimpl();
		tacheDAO.ajouterTacheSprint(13, 15);
		
	}
	
	public static void testTacheDAO(){
		
		
		
		ITacheDAO tache = new TacheDAOimpl();
		List<Tache>listTache =tache.listerParSprintNotDep(13,2);
		for(Tache t : listTache){
			System.out.println(t.getIdTache()+ "  " + t.getCout()+ "  " + t.getDescription() + " "+t.getIdUS());
		}
		
	}
	
	

	/*
	public static void supp(int idU, int idP){
		IProjetUtilisateurDAO projetUtilsateurDAO = new ProjetUtilisateurDAOimpl();
		IProjetDAO projetDAO = new ProjetDAOimpl();
		
		projetUtilsateurDAO.supprimer(idP, idU);
		List<Integer> list_idU = projetUtilsateurDAO.listerIdUtilisateurs(idP);
		if(list_idU.isEmpty())
			projetDAO.supprimer(idP);
	}*/
	
	public static void testListerTacheParStatus(){
		ITacheDAO tacheDAO = new TacheDAOimpl();
		List<Tache> aFaire = tacheDAO.listerTache(13, "A_FAIRE");
		List<Tache> enCours = tacheDAO.listerTache(13, "EN_COURS");
		List<Tache> finis = tacheDAO.listerTache(13, "FAIT");
		
		for(Tache t: aFaire){
			System.out.println("idTache:"+ t.getIdTache()+", Tag"+t.getTag()+", Status:"+t.getStatus());
			if(t.getDeveloppeur()!=null)
			System.out.println("Dev:" +t.getDeveloppeur());
		}
		
	}
	
	public static void testCommit(){
		Commit c1 = new Commit(0, "Test 1", "80002ere5");
		Commit c2 = new Commit(0, "Test 2", "80002ere5");
		
		ICommitDAO commitDAO = new CommitDAOImpl();
		commitDAO.ajouter(c1);
		commitDAO.ajouter(c2);
		//c1.setDescription("Modification 1");
		//commitDAO.modifier(c1);
		
		List<Commit> l = commitDAO.recupererListCommit(0);
		
		for(Commit c: l){
			System.out.println("Commit, id: "+c.getId()+", description: "+c.getDescription()+",numero: "+c.getNumero());
		}
		commitDAO.supprimer(c1.getId());
	}
}
