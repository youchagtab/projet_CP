package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.UserStory;

public class UserStoryDAOimpl implements IUserStoryDAO{

	@Override
	public void ajouter(UserStory userStory) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO CP_UserStory (description, difficulte , priorite, id_Projet) VALUES (?,?,?,?) ");
			ps.setString(1, userStory.getDescription());
			ps.setInt(2, userStory.getDifficulte());
			ps.setInt(3, userStory.getPriorite());
			ps.setInt(4, userStory.getIdProjet());
			ps.executeUpdate();
			ps.close();

			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT idUS  FROM CP_UserStory WHERE description = '"+userStory.getDescription()+"'"
					+ "AND difficulte = '"+ userStory.getDifficulte()+"'"
					+ "AND priorite = '"+ userStory.getPriorite()+"'"
					+ "AND id_Projet = '"+userStory.getIdProjet()+"'");
			resultat.next();
			userStory.setIdUS(resultat.getInt("idUS"));
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public UserStory recupererUserStory(int id) {
		Connection conn = SingletonConnection.getConnection();
		UserStory us = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_UserStory WHERE idUS = '"+ id +"'");
			resultat.next();

			us = new UserStory(resultat.getInt("idUS"),
					resultat.getString("description"), 
					resultat.getInt("difficulte"), 
					resultat.getInt("priorite"),
					resultat.getInt("id_Projet"));
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return us;
	}

	@Override
	public List<UserStory> lister(int idProjet) {
		Connection conn = SingletonConnection.getConnection();
		List<UserStory> listUS = new ArrayList<UserStory>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_UserStory WHERE id_Projet = '"+ idProjet +"'");

			while (resultat.next()){

				UserStory us = new UserStory(resultat.getInt("idUS"),
						resultat.getString("description"), 
						resultat.getInt("difficulte"), 
						resultat.getInt("priorite"),
						resultat.getInt("id_Projet"));
				listUS.add(us);
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUS;
	}

	@Override
	public void supprimer(int id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_UserStory WHERE idUS= ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifier(UserStory userStory) {
		Connection conn = SingletonConnection.getConnection();
		try {
			supprimer(userStory.getIdUS());
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO  CP_UserStory (idUS, description, difficulte , priorite, id_Projet) VALUES (?,?,?,?,?) ");
			ps.setInt(1, userStory.getIdUS());
			ps.setString(2, userStory.getDescription());
			ps.setInt(3, userStory.getDifficulte());
			ps.setInt(4, userStory.getPriorite());
			ps.setInt(5, userStory.getIdProjet());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<UserStory> listerParSprint(int idSprint) {
		Connection conn = SingletonConnection.getConnection();
		List<UserStory> listUS = new ArrayList<UserStory>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT  us.idUS,us.description,us.difficulte,us.priorite,us.id_Projet,us.place,us.status FROM CP_Sprint_UserStory s, CP_UserStory us WHERE s.idUS = us.idUS AND s.idSprint ='"+ idSprint +"'");

			while (resultat.next()){

				UserStory us = new UserStory(resultat.getInt("idUS"),
						resultat.getString("description"), 
						resultat.getInt("difficulte"), 
						resultat.getInt("priorite"),
						resultat.getInt("id_Projet"));
				listUS.add(us);
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUS;
	}


    @Override
	public int getTotalDifficultesParSprint(int idSprint){
		
		List<UserStory> userStories = new ArrayList<UserStory>();
		userStories = this.listerParSprint(idSprint);
		
		// diffixcultés totales
		int difficulte_Totale = 0;
		Iterator<UserStory> iter1 = userStories.iterator();

		while (iter1.hasNext()) {
			difficulte_Totale+=iter1.next().getDifficulte();
		   
		}

		return difficulte_Totale;
	}

    
    @Override
	public int getTotalDifficultes(int idProjet){
		
		List<UserStory> userStories = new ArrayList<UserStory>();
		userStories = this.lister(idProjet);
		
		// diffixcultés totales
		int difficulte_Totale = 0;
		Iterator<UserStory> iter1 = userStories.iterator();

		while (iter1.hasNext()) {
			difficulte_Totale+=iter1.next().getDifficulte();
		   
		}

		return difficulte_Totale;
	}


	@Override
	public void ajouterUserStoryToSprint(int idSprint, int idUserStory) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("INSERT INTO CP_Sprint_UserStory(idSprint,idUS) VALUES(?,?)");
			statement.setInt(1, idSprint);
			statement.setInt(2, idUserStory);
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if ( resultat != null ) {
				try {
					/* On commence par fermer le ResultSet */
					resultat.close();
				} catch ( SQLException ignore ) {
				}
			}
			if ( statement != null ) {
				try {
					/* Puis on ferme le Statement */
					statement.close();
				} catch ( SQLException ignore ) {
				}
			}
		}		
	}

	@Override
	public List<UserStory> listerParNotInSprint(int idProjet ,int idSprint) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		List<UserStory> listUS = new ArrayList<UserStory>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_UserStory WHERE idUS not in (SELECT  us.idUS FROM CP_Sprint_UserStory s, CP_UserStory us WHERE s.idUS = us.idUS AND s.idSprint = '"+ idSprint +"' ) AND id_Projet = '"+ idProjet +"'");

			while (resultat.next()){

				UserStory us = new UserStory(resultat.getInt("idUS"),
						resultat.getString("description"), 
						resultat.getInt("difficulte"), 
						resultat.getInt("priorite"),
						resultat.getInt("id_Projet"));
				listUS.add(us);
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUS;
	}

	@Override
	public void supprimer(int idSprint, int idUS) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_Sprint_UserStory WHERE idUS= ? AND idSprint = ?");
			ps.setInt(1, idUS);
			ps.setInt(2, idSprint);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}



}
