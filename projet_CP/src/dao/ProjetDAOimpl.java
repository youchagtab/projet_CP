package dao;

import java.util.ArrayList;
import java.util.List;

import beans.Projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ProjetDAOimpl implements IProjetDAO{

	@Override
	public int ajouter(Projet projet) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO CP_Projet (noms, description,repertoireGitHub) VALUES (?,?,?) ");
			ps.setString(1, projet.getNoms());
			ps.setString(2, projet.getDescription());
			ps.setString(3, projet.getRepertoireGitHub());
			ps.executeUpdate();
			ResultSet genreatedId= ps.getGeneratedKeys();
			if( genreatedId.next()){
				projet.setIdProjet(genreatedId.getInt(1));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return projet.getIdProjet();
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
			PreparedStatement ps = conn.prepareStatement(
					"select * from CP_Projet where idProjet = ?");
			ps.setInt(1, idProjet);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				p = new Projet();
				p.setIdProjet(rs.getInt("idProjet"));
				p.setNoms(rs.getString("noms"));
				p.setDescription(rs.getString("description"));
				p.setRepertoireGitHub(rs.getString("repertoireGitHub"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (p == null)
			throw new RuntimeException("projet:" + idProjet + " est introuvable");

		return p;
		
	}
	
	@Override
    public Projet recupererProjet(String nomsProjet){
		Projet p = null;
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select * from CP_Projet where idProjet = ?");
			ps.setString(1, nomsProjet);
			ResultSet rs = ps.executeQuery();
			IProjetUtilisateurDAO projetUtilisateurDAO = new ProjetUtilisateurDAOimpl();
			if(rs.next()){
				p = new Projet();
				p.setIdProjet(rs.getInt("idProjet"));
				p.setNoms(rs.getString("noms"));
				p.setRepertoireGitHub(rs.getString("repertoireGitHub"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (p == null)
			throw new RuntimeException("projet:" + nomsProjet + " est introuvable");
		
		return p;
	}

	@Override
	public List<Projet> lister() {
		List<Projet> projet = new ArrayList<Projet>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * FROM CP_Projet");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Projet p = new Projet();
				p.setIdProjet(rs.getInt("idProjet"));
				p.setNoms(rs.getString("noms"));
				p.setDescription(rs.getString("description"));
				p.setRepertoireGitHub(rs.getString("repertoireGitHub"));
				projet.add(p);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return projet;
	}

	
	@Override
	public void modifierProjet(Projet p) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update CP_Projet set noms = ?, description = ?, eepertoireGitHUb = ? WHERE  idProjet = ? ");
			ps.setString(1, p.getNoms());
			ps.setString(2, p.getDescription());
			ps.setInt(3, p.getIdProjet());
			ps.setString(4,p.getRepertoireGitHub());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Projet> listerMotCle(String mc) {
		List<Projet> projet = new ArrayList<Projet>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * FROM CP_Projet WHERE description like ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Projet p = new Projet();
				p.setIdProjet(rs.getInt("idProjet"));
				p.setNoms(rs.getString("noms"));
				p.setDescription(rs.getString("description"));	
				p.setRepertoireGitHub(rs.getString("repertoireGitHUb"));
				projet.add(p);
			}
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return projet;
	}
	
}
