package dao;

import java.util.List;

import beans.Tache;

public interface ITacheDAO 
{
	void ajouter(Tache tache);
	void modifier(Tache tache);
	void supprimer(Tache tache);
	Tache recupererTache(int idTache);
	List<Tache> listerParSprint(int idSprint);
	List<Tache> listerParUserStory(int idUS);
	List<Tache> listerDependanceTaches(int idTache);
	
}
