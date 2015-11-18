package dao;

import java.util.List;

import beans.Tache;

public interface ITacheDAO 
{
	void ajouter(Tache tache);
	void ajouterTacheSprint(int idSprint, int idTache);
	void modifier(Tache tache);
	void supprimer(Tache tache);
	Tache recupererTache(int idTache);
	List<Tache> listerParSprintNotDep(int idSprint, int idTache);
	List<Tache> listerParUserStory(int idUS);
	List<Tache> listerDependanceTaches(int idTache);
	void ajouterTacheToDep (int idTache , int idTacheDep);
	void supprimer(int idTache , int idTacheDep);
}
