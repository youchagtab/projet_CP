package dao;

import java.util.List;

import beans.Utilisateur;

public interface IUtilisateurDAO 
{
	public void ajouter(Utilisateur utilisateur);
	public void recupererUtilisateur(int id);
	public List<Utilisateur> lister();
	public void supprimer(Utilisateur utilisateur);
	public void supprimerUtilisateurParId(int id);
	public void modifier(Utilisateur utilisateur);
	public int verificationConnexion(String identifiant, String motDePasse);
	public boolean existanceIdentifiant(String identifiant);
	
}
