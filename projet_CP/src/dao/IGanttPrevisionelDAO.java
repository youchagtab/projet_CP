package dao;

import java.util.List;

import beans.Tache;

public interface IGanttPrevisionelDAO {

	public void ajouter(int idSprint, int idUtilisateur, int idTache, int debut, int duree);
	public void modifier(int idSprint, int idUtilisateur, int idTache, int debut, int duree);
	
	public void supprimer(int idSprint, int idUtilisateur, int idTache);
	
	public List<Tache> recuperer(int idSprint, int idUtilisateur);
	    
}
