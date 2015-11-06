package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Sprint;
import beans.Tache;

public class TacheDAOimpl implements ITacheDAO {

	@Override
	public void ajouter(Tache tache) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("INSERT INTO cp_tache(tag,description,cout,status,idUS) VALUES(?,?,?,?,?)");
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

			statement = connexion.prepareStatement("UPDATE cp_tache SET tag = ?,description= ?,cout= ?,status= ?,idUS= ? WHERE idTache = ?");
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

			statement = connexion.prepareStatement("DELETE  FROM cp_tache WHERE idTache = ?");
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

			statement = connexion.prepareStatement("SELECT * FROM cp_tache WHERE idTache = ?");
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
	public List<Tache> listerParProjet(int idProjet) {
		// TODO Auto-generated method stub
		return null;
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

			statement = connexion.prepareStatement("SELECT * FROM cp_tache WHERE idUS = ?");
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
	public List<Tache> listerParSprint(int idSprint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tache> listerDependanceTaches(int idTache) {
		// TODO Auto-generated method stub
		return null;
	}

}
