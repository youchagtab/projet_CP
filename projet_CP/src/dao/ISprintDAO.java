package dao;

import java.util.List;

import beans.Sprint;

public interface ISprintDAO 
{
	void ajouter(Sprint sprint);
	void modifier(Sprint sprint);
	void supprimer(Sprint sprint);
	Sprint recupererSprint(int idSprint);
	List<Sprint> lister(int idProjet);
}
