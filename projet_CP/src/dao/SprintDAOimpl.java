package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import beans.Sprint;

public class SprintDAOimpl implements ISprintDAO {

	@Override
	public void ajouter(Sprint sprint) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("INSERT INTO CP_Sprint(idProjet,numero) VALUES(?,?)");
			statement.setInt(1, sprint.getIdProjet());
			statement.setInt(2, sprint.getNumero());
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
	public void modifier(Sprint sprint) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("UPDATE CP_Sprint SET numero = ? WHERE idSprint = ?");
			statement.setInt(1, sprint.getNumero());
			statement.setInt(2, sprint.getIdSprint());
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
	public void supprimer(Sprint sprint) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		try
		{

			statement = connexion.prepareStatement("DELETE  FROM CP_Sprint WHERE idSprint = ?");
			statement.setInt(1, sprint.getIdSprint());
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
	public Sprint recupererSprint(int idSprint) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		Sprint sprint = null; 
		try
		{

			statement = connexion.prepareStatement("SELECT * FROM CP_Sprint WHERE idSprint = ?");
			statement.setInt(1, idSprint);
			resultat = statement.executeQuery();
			
			resultat.next();
			sprint = new Sprint();
			sprint.setIdSprint(resultat.getInt("idSprint"));
			sprint.setIdProjet(resultat.getInt("idProjet"));
			sprint.setNumero(resultat.getInt("numero"));
			
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
		return sprint;
	}

	@Override
	public List<Sprint> lister(int idProjet) {
		// TODO Auto-generated method stub
		Connection connexion = SingletonConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultat = null;
		List<Sprint> sprints = null;
		Sprint sprint = null;
		try
		{

			statement = connexion.prepareStatement("SELECT * FROM CP_Sprint WHERE idProjet = ?");
			statement.setInt(1, idProjet);
			resultat = statement.executeQuery();

			sprints = new ArrayList<Sprint>();
			while(resultat.next())
			{
				sprint = new Sprint();
				sprint.setIdSprint(resultat.getInt("idSprint"));
				sprint.setIdProjet(resultat.getInt("idProjet"));
				sprint.setNumero(resultat.getInt("numero"));
				sprints.add(sprint);
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
		return sprints;
	}

}
