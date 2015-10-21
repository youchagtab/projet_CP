package dao;

import java.util.List;

import beans.Projet;
import beans.Utilisateur;


public interface IProjetUtilisateurDAO {
	
	public void ajouter(int idProjet,int idUtilisateur);
	public void supprimer(int idProjet, int idUtilisateur);
	public void supprimerProjet(int idProjet);
	public void supprimerUtilisateur(int idUtilisateur);
	
	public List<Utilisateur> recupererUtilisateurs(int idProjet);
	public List<Projet> recupererProjet(int idUtilisateur);
	

}
