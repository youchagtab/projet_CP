package beans;

public class Tache 
{
	protected int		idTache;
	protected String	tag;
	protected String	description;
	protected int		cout;
	protected String	status;
	protected int		idUS;
	protected int       duree;
	protected int       debut;
    protected Utilisateur  developpeur;
    
	public Tache() {}
	
	public Tache(int idTache, String tag, String description, int cout, String status, int idUS) {
		super();
		this.idTache = idTache;
		this.tag = tag;
		this.description = description;
		this.cout = cout;
		this.status = status;
		this.idUS = idUS;
		this.developpeur = null;
	}



	public Tache(String tag, String description, int cout, String status, int idUS) {
		super();
		this.tag = tag;
		this.description = description;
		this.cout = cout;
		this.status = status;
		this.idUS = idUS;
		this.developpeur = null;
	}

	public Tache(int idTache, String description, int idUS) {
		super();
		this.idTache = idTache;
		this.description = description;
		this.idUS = idUS;
		this.developpeur = null;
	}

	

	public Utilisateur getDeveloppeur() {
		return developpeur;
	}

	public void setDevelopeur(Utilisateur developeur) {
		this.developpeur = developeur;
	}

	public int getIdTache() {
		return idTache;
	}
	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getIdUS() {
		return idUS;
	}
	public void setIdUS(int idUS) {
		this.idUS = idUS;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}
	
	
	
	
}
