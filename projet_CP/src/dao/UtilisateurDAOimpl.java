package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import beans.Utilisateur;

public class UtilisateurDAOimpl implements IUtilisateurDAO {

	@Override
	public void ajouter(Utilisateur utilisateur) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into CP_Utilisateurs (idUtilisateur , identifiant , motDePasse, nom , prenom) values (?,?,?,?) ");
			ps.setInt(1, utilisateur.getIdUtilisateur());
			ps.setString(2, utilisateur.getIdentifiant());
			ps.setString(3, utilisateur.getMotDePasse());
			ps.setString(4, utilisateur.getNom());
			ps.setString(5, utilisateur.getPrenom());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void recupererUtilisateur(int id) {
		// TODO Auto-generated method stub

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
