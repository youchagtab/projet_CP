package dao;

import java.util.List;

import beans.Utilisateur;

public interface IProjetUtilisateurDAO {
	
	public void ajouter(int idProjet,int idUtilisateur);
	public void supprimer(int idProjet, int idUtilisateur);
	public void supprimerProjet(int idProjet);
	public void supprimerUtilisateur(int idUtilisateur);

	public List<Integer> listerIdUtilisateurs(int idProjet);
	public List<Integer> listerIdProjet(int idUtilisateur);
	List<Utilisateur> listerUtilisateursParProjet(int idProjet);
	

}
