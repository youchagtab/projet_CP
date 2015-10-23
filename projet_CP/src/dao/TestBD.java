package dao;

import java.util.List;

import beans.Projet;
import beans.Utilisateur;

public class TestBD {

	public static void main(String[] args) {
		
		IProjetDAO projet = new ProjetDAOimpl();
		List<Projet> pro = projet.lister();
		for(Projet p : pro){
			System.out.println(p.getNoms() + p.getDescription());
		}
		
		
	
/*
		IProjetDAO p = new ProjetDAOimpl();
		String _description = "pas de description pour le moment";
		String _noms = "projet 5";
		Projet proj = new Projet(_noms, _description);
		p.ajouter(proj);
		*/
		
		
	}
		//testProjet();
		/*IUtilisateurDAO utilisateur = new UtilisateurDAOimpl();
		Utilisateur u = new Utilisateur("paulseb", "mdp", "paul", "sebastien");
		utilisateur.ajouter(u);
		System.out.println(u.getIdUtilisateur());
	}*/
	
/*	public static void testProjet(){
		IProjetDAO projetDAO = new ProjetDAOimpl();
		Utilisateur u = new Utilisateur(4,"Olivier","password","Constans","Olivier");
		Projet p = new Projet(u,"test 1","test1");
		projetDAO.ajouter(p);
		System.out.println(p.getIdProjet());
		
		//projetDAO.supprimer(p);
		projetDAO.supprimer(p.getIdProjet());
	}
*/
	

}
