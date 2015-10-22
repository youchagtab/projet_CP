package dao;

import beans.Utilisateur;

public class TestBD {

	public static void main(String[] args) {
		IUtilisateurDAO utilisateur = new UtilisateurDAOimpl();
		Utilisateur u = new Utilisateur(8, "paulseb", "mdp", "paul", "sebastien");
		utilisateur.ajouter(u);

	}

}
