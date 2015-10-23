package dao;

import java.util.List;

import beans.Projet;
import beans.Utilisateur;

public class TestBD {

	public static void main(String[] args) {
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
