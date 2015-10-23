package dao;

import beans.Projet;
import beans.Utilisateur;

public class TestBD {

	public static void main(String[] args) {
		testProjet();
		/*IUtilisateurDAO utilisateur = new UtilisateurDAOimpl();
		Utilisateur u = new Utilisateur("paulseb", "mdp", "paul", "sebastien");
		utilisateur.ajouter(u);
		System.out.println(u.getIdUtilisateur());*/
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
