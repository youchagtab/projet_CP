package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public void recupererUtilisateur(int id) {/*
		Connection conn = SingletonConnection.getConnection();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Utilisateurs WHERE identifiant = '"+ id +"'" );
			resultat.next();
			Utilisateur u = new Utilisateur(identifiant, motDePasse, nom, prenom)
			utilisateur.setIdUtilisateur(resultat.getInt("idUtilisateur"));
			statement.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}*/

	}

	@Override
	public List<Utilisateur> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerUtilisateurParId(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifier(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public int verificationConnexion(String identifiant, String motDePasse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existanceIdentifiant(String identifiant) {
		// TODO Auto-generated method stub
		return false;
	}

}
