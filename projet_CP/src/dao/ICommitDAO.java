package dao;

import java.util.List;

import beans.Commit;

public interface ICommitDAO 
{
	public void ajouter(Commit commit);
	public void modifier(Commit commit);

	public void supprimer(int id);
	
	public Commit recuperer(int id);
	public List<Commit> recupererListCommit(int idTache);
	
}