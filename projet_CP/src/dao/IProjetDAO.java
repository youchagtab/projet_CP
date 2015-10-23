package dao;

import java.util.List;

import beans.Projet;


public interface IProjetDAO {

	public void ajouter(Projet projet);
	public void supprimer(Projet projet);
	public void supprimer(int idprojet);
	
    public Projet recupererProjet(int idProjet);
    public Projet recupererProjet(String nomsProjet);
    public List<Projet> lister();
    
    
    public void modifierProjet(Projet p);
      
}
