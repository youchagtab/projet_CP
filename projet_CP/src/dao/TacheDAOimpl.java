package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Sprint;
import beans.Tache;
import beans.UserStory;

public class TacheDAOimpl implements ITacheDAO {

	@Override
	public void ajouter(Tache tache) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("INSERT INTO CP_Tache(tag,description,cout,status,idUS) VALUES(?,?,?,?,?)");
			statement.setString(1, tache.getTag());
			statement.setString(2, tache.getDescription());
			statement.setInt(3, tache.getCout());
			statement.setString(4, tache.getStatus());
			statement.setInt(5, tache.getIdUS());
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
	public void modifier(Tache tache) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("UPDATE CP_Tache SET tag = ?,description= ?,cout= ?,status= ?,idUS= ? WHERE idTache = ?");
			statement.setString(1, tache.getTag());
			statement.setString(2, tache.getDescription());
			statement.setInt(3, tache.getCout());
			statement.setString(4, tache.getStatus());
			statement.setInt(5, tache.getIdUS());
			statement.setInt(6, tache.getIdTache());
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
	public void supprimer(Tache tache) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("DELETE  FROM CP_Tache WHERE idTache = ?");
			statement.setInt(1, tache.getIdTache());
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
	public Tache recupererTache(int idTache) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		Tache tache = null; 
		try
		{

			statement = connexion.prepareStatement("SELECT * FROM CP_Tache WHERE idTache = ?");
			statement.setInt(1, idTache);
			resultat = statement.executeQuery();
			
			resultat.next();
			tache = new Tache();
			tache.setIdTache(resultat.getInt("idTache"));
			tache.setTag(resultat.getString("tag"));
			tache.setDescription(resultat.getString("description"));
			tache.setCout(resultat.getInt("cout"));
			tache.setStatus(resultat.getString("status"));
			tache.setIdUS(resultat.getInt("idUS"));
			
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
		return tache;
	}

	@Override
	public List<Tache> listerParSprint(int idSprint) {
		Connection conn = SingletonConnection.getConnection();
		List<Tache> taches =null;
		Tache tache = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT  t.idTache, t.tag, t.description, t.cout, t.status, t.idUS FROM CP_Sprint_Tache s, CP_Tache t WHERE s.idTache = t.idTache AND s.idSprint ='"+ idSprint +"'");
			
			while (resultat.next()){
				
				tache = new Tache();
				tache.setIdTache(resultat.getInt("idTache"));
				tache.setTag(resultat.getString("tag"));
				tache.setDescription(resultat.getString("description"));
				tache.setCout(resultat.getInt("cout"));
				tache.setStatus(resultat.getString("status"));
				tache.setIdUS(resultat.getInt("idUS"));
				taches.add(tache);
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taches;
	}

	@Override
	public List<Tache> listerParUserStory(int idUS) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		List<Tache> taches = null;
		Tache tache = null;
		try
		{

			statement = connexion.prepareStatement("SELECT * FROM CP_Tache WHERE idUS = ?");
			statement.setInt(1, idUS);
			resultat = statement.executeQuery();

			taches = new ArrayList<Tache>();
			while(resultat.next())
			{
				tache = new Tache();
				tache.setIdTache(resultat.getInt("idTache"));
				tache.setTag(resultat.getString("tag"));
				tache.setDescription(resultat.getString("description"));
				tache.setCout(resultat.getInt("cout"));
				tache.setStatus(resultat.getString("status"));
				tache.setIdUS(resultat.getInt("idUS"));
				taches.add(tache);
			}
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
		return taches;
	}

	@Override
	public List<Tache> listerDependanceTaches(int idTache) {
		// TODO Auto-generated method stub
		Connection conn = SingletonConnection.getConnection();
		List<Tache> taches = null;
		Tache tache = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT  td.idTache, td.tag, td.description, td.cout, td.status, td.idUS FROM cp_dependancetache t, cp_tache td WHERE t.dependance = td.idTache AND t.tache = '"+ idTache +"'");
			
			taches = new ArrayList<Tache>();
			while(resultat.next())
			{
				tache = new Tache();
				tache.setIdTache(resultat.getInt("idTache"));
				tache.setTag(resultat.getString("tag"));
				tache.setDescription(resultat.getString("description"));
				tache.setCout(resultat.getInt("cout"));
				tache.setStatus(resultat.getString("status"));
				tache.setIdUS(resultat.getInt("idUS"));
				taches.add(tache);
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taches;
	}

}
