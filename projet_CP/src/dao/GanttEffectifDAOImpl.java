package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Tache;

public class GanttEffectifDAOImpl implements IGanttEffectifDAO {

	@Override
	public void ajouter(int idSprint, int idUtilisateur,
			int idTache, int debut, int duree) {
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		try
		{
			statement = connexion.prepareStatement("INSERT INTO CP_GanttEffectif(idSprint, idUtilisateur, idTache, debut, duree)  VALUES(?,?,?,?,?)");
			statement.setInt(1, idSprint);
			statement.setInt(2, idUtilisateur);
			statement.setInt(3, idTache);
			statement.setInt(4, debut);
			statement.setInt(5, duree);
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifier(int idSprint, int idUtilisateur,
			int idTache, int debut, int duree) {
		
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		try
		{

			statement = connexion.prepareStatement("UPDATE CP_GanttEffectif SET debut= ?, duree= ? WHERE idSprint= ? AND idUtilisateur = ? AND idTache = ?");
			statement.setInt(1, debut);
			statement.setInt(2, duree);
			statement.setInt(3, idSprint);
			statement.setInt(4, idUtilisateur);
			statement.setInt(5, idTache);
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimer(int idSprint, int idUtilisateur,
			int idTache) {
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		try
		{

			statement = connexion.prepareStatement("DELETE  FROM CP_GanttEffectif WHERE idSprint= ? AND idUtilisateur = ? AND idTache = ?");
			statement.setInt(1, idSprint);
			statement.setInt(2, idUtilisateur);
			statement.setInt(3, idTache);
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public void supprimer(int idSprint,int idTache) {
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		try
		{

			statement = connexion.prepareStatement("DELETE  FROM CP_GanttEffectif WHERE idSprint= ? AND idTache = ?");
			statement.setInt(1, idSprint);
			statement.setInt(2, idTache);
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Tache> recuperer(int idSprint, int idUtilisateur) {
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		Tache tache = null; 
		List<Tache> taches = new ArrayList<Tache>();
		try
		{

			statement = connexion.prepareStatement("SELECT * FROM CP_GanttEffectif WHERE idSprint= ? AND idUtilisateur = ?");
			statement.setInt(1, idSprint);
			statement.setInt(2, idUtilisateur);
			resultat = statement.executeQuery();
			
			while(resultat.next()){
				Tache t = new Tache();
				t.setDebut(resultat.getInt("debut"));
				t.setDuree(resultat.getInt("duree"));
				t.setIdTache(resultat.getInt("idTache"));
				
				taches.add(t);
			}
			return taches;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean exist(int idSprint) {
		Connection connexion = SingletonConnection.getConnection();
		ResultSet resultat = null;
		try
		{

			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM CP_GanttEffectif WHERE idSprint= ?");
			statement.setInt(1, idSprint);
			resultat = statement.executeQuery();
			
			if(resultat.next()){
				return true;
			}
			return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
