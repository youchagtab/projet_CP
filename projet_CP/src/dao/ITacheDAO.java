package dao;

import java.util.List;

import beans.Tache;

public interface ITacheDAO 
{
	void ajouter(Tache tache);
	void modifier(Tache tache);
	void supprimer(Tache tache);
	Tache recupererSprint(int idSprint);
	List<Tache> listerParProjet(int idProjet);
	List<Tache> listerParSprint(int idSprint);
	List<Tache> listerDependanceTaches(int idTache);
	
}
