package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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



}
