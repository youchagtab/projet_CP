package dao;

import java.util.List;

import beans.Projet;
import beans.Utilisateur;

public class TestBD {

	public static void main(String[] args) {
		
		try{
		IProjetDAO projet = new ProjetDAOimpl();
		Projet p = projet.recupererProjet(2);
		System.out.println(p.getDescription() + p.getNoms());
		p.setDescription("modification de la description 2");
		projet.modifierProjet(p);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		/*---------------------test pour lister les projets-- Done-------*/
		/*IProjetDAO projet = new ProjetDAOimpl();
		List<Projet> pro = projet.lister();
		for(Projet p : pro){
			System.out.println(p.getNoms() + p.getDescription());
		}*/
		
		
		
		
	/*-------------test pour ajouter un projet----Done--------------------*/
/*
		IProjetDAO p = new ProjetDAOimpl();
		String _description = "pas de description pour le moment";
		String _noms = "projet 5";
		Projet proj = new Projet(_noms, _description);
		p.ajouter(proj);
		*/
		
		/*-------------test pour ajouter utilisateur------Done-------------*/
		//testProjet();
				/*IUtilisateurDAO utilisateur = new UtilisateurDAOimpl();
				Utilisateur u = new Utilisateur("paulseb", "mdp", "paul", "sebastien");
				utilisateur.ajouter(u);
				System.out.println(u.getIdUtilisateur());
			}*/
		
		testUtilisateur();
		//testProjet();
		/*IUtilisateurDAO utilisateur = new UtilisateurDAOimpl();
		Utilisateur u = new Utilisateur("paulseb", "mdp", "paul", "sebastien");
		utilisateur.ajouter(u);
		System.out.println(u.getIdUtilisateur());*/
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
	
	public static void testProjet(){
		IProjetDAO projetDAO = new ProjetDAOimpl();
		Utilisateur u = new Utilisateur(4,"Olivier","password","Constans","Olivier");
		Projet p = new Projet(u,"test 1","test1");
		projetDAO.ajouter(p);
		System.out.println(p.getIdProjet());
		
		//projetDAO.supprimer(p);
		projetDAO.supprimer(p.getIdProjet());
	}

}
