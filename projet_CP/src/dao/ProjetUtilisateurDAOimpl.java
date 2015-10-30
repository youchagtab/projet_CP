package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ProjetUtilisateurDAOimpl implements IProjetUtilisateurDAO{

	@Override
	public void ajouter(int idProjet, int idUtilisateur) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO CP_Projet_Utilisateur (idProjet, idUtilisateur) VALUES (?,?) ");
			ps.setInt(1,idProjet);
			ps.setInt(2, idUtilisateur);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimer(int idProjet, int idUtilisateur) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_Projet_Utilisateur WHERE idProjet= ? AND idUtilisateur= ?");
			ps.setInt(1,idProjet);
			ps.setInt(2, idUtilisateur);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimerProjet(int idProjet) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_Projet_Utilisateur WHERE idProjet= ? ");
			ps.setInt(1,idProjet);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimerUtilisateur(int idUtilisateur) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_Projet_Utilisateur WHERE idUtilisateur= ?");
			ps.setInt(1, idUtilisateur);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Integer> listerIdUtilisateurs(int idProjet) {
		Connection conn = SingletonConnection.getConnection();
		List<Integer> list = new ArrayList<>();
		try {
		Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Projet_Utilisateur WHERE idProjet= '"+ idProjet);
		IProjetDAO projetDAO = new ProjetDAOimpl();
		while (resultat.next()){
			list.add(resultat.getInt("idProjet"));
		}
		statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Integer> listerIdProjet(int idUtilisateur) {
		Connection conn = SingletonConnection.getConnection();
		List<Integer> list = new ArrayList<>();
		try {
		Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Projet_Utilisateur WHERE idUtilisateur= '"+ idUtilisateur);
		IProjetDAO projetDAO = new ProjetDAOimpl();
		while (resultat.next()){
			list.add(resultat.getInt("idProjet"));
		}
		statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
