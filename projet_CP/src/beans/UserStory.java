package beans;

import java.io.Serializable;

public class UserStory implements Serializable
{
	protected int idUS;
	protected String description;
	protected int difficulte;
	protected int priorite;
	protected int idProjet;
	
	
	
	public UserStory() {
	}

	public UserStory(String description, int difficulte, int priorite,
			int idProjet) {
		super();
		this.description = description;
		this.difficulte = difficulte;
		this.priorite = priorite;
		this.idProjet = idProjet;
	}

	public UserStory(int idUS, String description, int difficulte,
			int priorite, int idProjet) {
		super();
		this.idUS = idUS;
		this.description = description;
		this.difficulte = difficulte;
		this.priorite = priorite;
		this.idProjet = idProjet;
	}

	public void serIdUS(int id){
		idUS = id;
	}
	public int getIdUS() 
	{
		return idUS;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public int getDifficulte() 
	{
		return difficulte;
	}
	
	public void setDifficulte(int difficulte) 
	{
		this.difficulte = difficulte;
	}
	
	public int getPriorite() 
	{
		return priorite;
	}
	
	public void setPriorite(int priorite) 
	{
		this.priorite = priorite;
	}
	
	public int getIdProjet() 
	{
		return idProjet;
	}
	
	public void setIdProjet(int idProjet) 
	{
		this.idProjet = idProjet;
	}
	
	
	
}
