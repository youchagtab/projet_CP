package beans;

public class Tache 
{
	protected int		idTache;
	protected String	tag;
	protected String	description;
	protected int		cout;
	protected String	status;
	protected int		idUS;
	

	public Tache() {}
	
	public Tache(int idTache, String tag, String description, int cout, String status, int idUS) {
		super();
		this.idTache = idTache;
		this.tag = tag;
		this.description = description;
		this.cout = cout;
		this.status = status;
		this.idUS = idUS;
	}



	public Tache(String tag, String description, int cout, String status, int idUS) {
		super();
		this.tag = tag;
		this.description = description;
		this.cout = cout;
		this.status = status;
		this.idUS = idUS;
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
	
	
	
	
}
