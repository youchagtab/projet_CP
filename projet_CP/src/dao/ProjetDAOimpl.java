package dao;

import java.util.List;

import beans.Projet;
import beans.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProjetDAOimpl implements IProjetDAO{

	@Override
	public void ajouter(Projet projet) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO CP_Projet (noms, description) VALUES (?,?) ");
			ps.setString(1, projet.getNoms());
			ps.setString(2, projet.getDescription());
			ps.executeUpdate();
			ps.close();
			
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT idProjet  FROM CP_Projet WHERE noms='"+projet.getNoms()+"'" );
			resultat.next();
			projet.setIdProjet(resultat.getInt("idProjet"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer(Projet projet) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_Projet WHERE idProjet= ? AND noms= ? AND description= ? ");
			ps.setInt(1, projet.getIdProjet());
			ps.setString(2, projet.getNoms());
			ps.setString(3, projet.getDescription());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void supprimer(int idprojet) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_Projet WHERE idProjet= ? ");
			ps.setInt(1, idprojet);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Projet recupererProjet(int idProjet) {		
		
		Projet p = null;
		Connection conn = SingletonConnection.getConnection();
	try {
		
		Statement statement = conn.createStatement();
		ResultSet resultat = statement.executeQuery( "SELECT idProjet  FROM CP_Projet WHERE idProjet='"+idProjet+"'" );
		//IProjetUtilisateurDAO pu = new .... ;
		List<Utilisateur> utilisateurs = null;//....getUtilsateur(idProject);
		p = new Projet(utilisateurs, resultat.getString("noms"), resultat.getString("description"));
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return p;
		
	}
	
	@Override
    public Projet recupererProjet(String nomsProjet){
		return null;
	}

	@Override
	public List<Projet> lister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recupererDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifierDescription(String Description) {
		// TODO Auto-generated method stub
		
	}
	

}
