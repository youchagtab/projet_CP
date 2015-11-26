package dao;

import java.util.List;

import beans.Commit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class CommitDAOImpl implements ICommitDAO {
	
	static Connection connection = SingletonConnection.getConnection();
	
	@Override
	public void ajouter(Commit commit) {
		
		try {
	
			PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO CP_Commit (numero, idTache, description) VALUES (?,?, ?)");
			ps.setString(1, commit.getNumero());
			ps.setInt(2, commit.getIdTache());
			ps.setString(3, commit.getDescription());

			ps.executeUpdate();
			ResultSet genreatedId= ps.getGeneratedKeys();
			if( genreatedId.next()){
				commit.setId(genreatedId.getInt(1));
			}

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modifier(Commit commit) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE CP_Commit SET numero = ?, idTache = ?, description= ? WHERE idCommit = ?");
			ps.setString(1, commit.getNumero());
			ps.setInt(2, commit.getIdTache());
			ps.setString(3, commit.getDescription());
			ps.setInt(4, commit.getId());
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM CP_Commit WHERE idCommit= ? ");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Commit recuperer(int id) {
		Commit c = null;
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM CP_Commmit WHERE idCommit = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				c = new Commit();
				c.setId(rs.getInt("idCommit"));
				c.setNumero(rs.getString("numero"));
				c.setDescription(rs.getString("description"));
				c.setIdTache(rs.getInt("idTache"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (c == null)
			throw new RuntimeException("commit:" + id + " est introuvable");

		return c;
	}

	@Override
	public List<Commit> recupererListCommit(int idTache) {
		List<Commit> listCommit = new ArrayList<Commit>();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM CP_Commit WHERE idTache = ?");
			ps.setInt(1, idTache);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Commit c = new Commit();
				c.setId(rs.getInt("idCommit"));
				c.setNumero(rs.getString("numero"));
				c.setDescription(rs.getString("description"));
				c.setIdTache(rs.getInt("idTache"));
				listCommit.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCommit;
	}


	
	
	
}