package dao;

import java.util.List;

import beans.Utilisateur;

public interface IUtilisateurDAO 
{
	public void ajouter(Utilisateur utilisateur);
	
	public Utilisateur recupererUtilisateur(int id);
	public Utilisateur recupererUtilisateur(String identifiant);
	
	public List<Utilisateur> lister();
	
	public void supprimer(Utilisateur utilisateur);
	public void supprimerUtilisateur(int id);
	
	public void modifier(Utilisateur utilisateur);
	public boolean verificationConnexion(String identifiant, String motDePasse);
	public boolean existanceIdentifiant(String identifiant);
	
}
