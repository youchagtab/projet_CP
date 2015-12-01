package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Tache;


import beans.UserStory;
import beans.Utilisateur;


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
			statement.setDouble(3, tache.getCout());
			statement.setString(4, tache.getStatus());
			statement.setInt(5, tache.getIdUS());
			statement.executeUpdate();
			
			ResultSet genreatedId= statement.getGeneratedKeys();
			if( genreatedId.next()){
				tache.setIdTache(genreatedId.getInt(1));
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
	}

	@Override
	public void modifier(Tache tache) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{
			System.out.println("SQL IN");
			statement = connexion.prepareStatement("UPDATE CP_Tache SET tag = ?,description= ?,cout= ?,status= ?,idUS= ? WHERE idTache = ?");
			statement.setString(1, tache.getTag());
			statement.setString(2, tache.getDescription());
			statement.setDouble(3, tache.getCout());
			statement.setString(4, tache.getStatus());
			statement.setInt(5, tache.getIdUS());
			statement.setInt(6, tache.getIdTache());
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("SQl ERREUR");
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
	public List<Tache> listerParSprintNotDep(int idSprint,int idTache) {
		Connection conn = SingletonConnection.getConnection();
		List<Tache> taches = new ArrayList<>();
		//Tache tache ;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT * FROM CP_Sprint_Tache sp, CP_Tache t WHERE sp.idTache = t.idTache AND idSprint = '"+ idSprint +"' AND t.idTache NOT IN (Select dependance From CP_DependanceTache WHERE tache = '"+ idTache +"') AND sp.idTache != '"+ idTache +"'");
			
			while (resultat.next()){
				
					
			    Tache tache = new Tache();
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
			ResultSet resultat = statement.executeQuery( "SELECT  td.idTache, td.tag, td.description, td.cout, td.status, td.idUS FROM CP_DependanceTache t, CP_Tache td WHERE t.dependance = td.idTache AND t.tache = '"+ idTache +"'");
			
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

	@Override
	public void ajouterTacheToDep(int idTache, int idTacheDep) {
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("INSERT INTO CP_DependanceTache VALUES(?,?)");
			statement.setInt(1, idTache);
			statement.setInt(2, idTacheDep);
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
	public void supprimer(int idTache, int idTacheDep) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM CP_DependanceTache WHERE tache= ? AND dependance = ?");
			ps.setInt(1, idTache);
			ps.setInt(2, idTacheDep);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void ajouterTacheSprint(int idSprint, int idTache) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO CP_Sprint_Tache (idSprint, idTache) VALUES (?,?) ");
			ps.setInt(1,idSprint);
			ps.setInt(2, idTache);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	
	@Override
	public List<Tache> listerTache(int idSprint,String status){
		Connection conn = SingletonConnection.getConnection();
		List<Tache> taches = null;
		Tache tache = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery( "SELECT  t.idTache, t.tag, t.description, t.cout, t.status, t.idUS, st.idUtilisateur FROM CP_Tache t, CP_Sprint_Tache st WHERE t.idTache = st.idTache AND t.status='"+status+"' AND st.idSprint = '"+ idSprint +"'");
			
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
				IUtilisateurDAO	utilisateurDAO = new UtilisateurDAOimpl();
				
				if(resultat.getInt("idUtilisateur")!=0){
				Utilisateur d = utilisateurDAO.recupererUtilisateur(resultat.getInt("idUtilisateur"));
				tache.setDevelopeur(d);
				}
				
				taches.add(tache);
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taches;
		
	}

	@Override
	public List<Tache> listerTache(int idSprint) {

		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		List<Tache> taches = null;
		Tache tache = null;
		try
		{

			statement = connexion.prepareStatement("SELECT * FROM CP_Sprint_Tache sp, CP_Tache t WHERE sp.idTache = t.idTache AND sp.idSprint = ?");
			statement.setInt(1, idSprint);
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
	public void setUtilisateurKanaban(int idUtilisateur, int idSprint, int idTache) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{
			System.out.println("SQL IN");
			statement = connexion.prepareStatement("UPDATE CP_Sprint_Tache SET idUtilisateur = ? WHERE idSprint = ? AND idTache = ?");
			statement.setInt(1, idUtilisateur);
			statement.setInt(2, idSprint);
			statement.setInt(3, idTache);
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("SQl ERREUR");
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

}
