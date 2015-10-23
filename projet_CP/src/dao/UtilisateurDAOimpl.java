package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;






import beans.Utilisateur;

public class UtilisateurDAOimpl implements IUtilisateurDAO {

	@Override
	public void ajouter(Utilisateur utilisateur) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO CP_Utilisateurs (identifiant , motDePasse, nom , prenom) VALUES (?,?,?,?) ");
			ps.setString(1, utilisateur.getIdentifiant());
			ps.setString(2, utilisateur.getMotDePasse());
			ps.setString(3, utilisateur.getNom());
			ps.setString(4, utilisateur.getPrenom());
			ps.executeUpdate();
			ps.close();

			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT idUtilisateur  FROM CP_Utilisateurs WHERE identifiant = '"+utilisateur.getIdentifiant()+"'" );
			resultat.next();
			utilisateur.setIdUtilisateur(resultat.getInt("idUtilisateur"));
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Utilisateur recupererUtilisateur(int id) {
		Connection conn = SingletonConnection.getConnection();
		Utilisateur u = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Utilisateurs WHERE idUtilisateur = '"+ id +"'" );
			resultat.next();

			u = new Utilisateur(resultat.getInt("idUtilisateur"),
					resultat.getString("identifiant"), 
					resultat.getString("motDePasse"), 
					resultat.getString("nom"),
					resultat.getString("prenom"));
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Utilisateur recupererUtilisateur(String identifiant) {
		Connection conn = SingletonConnection.getConnection();
		Utilisateur u = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Utilisateurs WHERE identifiant = '"+ identifiant +"'" );
			resultat.next();

			u = new Utilisateur(resultat.getInt("idUtilisateur"),
					resultat.getString("identifiant"), 
					resultat.getString("motDePasse"), 
					resultat.getString("nom"),
					resultat.getString("prenom"));
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Utilisateur> lister() {
		Connection conn = SingletonConnection.getConnection();
		List<Utilisateur> res = new ArrayList<Utilisateur>();
		try{
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Utilisateurs");
			while(resultat.next()){;

			res.add( new Utilisateur(resultat.getInt("idUtilisateur"),
					resultat.getString("identifiant"), 
					resultat.getString("motDePasse"), 
					resultat.getString("nom"),
					resultat.getString("prenom")));
			
		
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void supprimer(Utilisateur utilisateur) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_Utilisateurs WHERE idUtilisateur= ?");
			ps.setInt(1, utilisateur.getIdUtilisateur());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerUtilisateur(int id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_Utilisateurs WHERE idUtilisateur= ? ");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifier(Utilisateur utilisateur) {
		Connection conn = SingletonConnection.getConnection();
		try {
			supprimer(utilisateur);
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO CP_Utilisateurs (idUtilisateur, identifiant , motDePasse, nom , prenom) VALUES (?,?,?,?,?) ");
			ps.setInt(1, utilisateur.getIdUtilisateur());
			ps.setString(2, utilisateur.getIdentifiant());
			ps.setString(3, utilisateur.getMotDePasse());
			ps.setString(4, utilisateur.getNom());
			ps.setString(5, utilisateur.getPrenom());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verificationConnexion(String identifiant, String motDePasse) {
		Connection conn = SingletonConnection.getConnection();
		try {Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Utilisateurs WHERE identifiant = '"+ identifiant +"' "
				+ "AND motDePasse ='"+motDePasse +"'");
		if(resultat.next()){
			return true;
		}
		statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean existanceIdentifiant(String identifiant) {
		Connection conn = SingletonConnection.getConnection();
		try {Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Utilisateurs WHERE identifiant = '"+ identifiant +"'" );
		if(resultat.next()){
			return true;
		}
		statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
