package beans;


public class Commit{
	
	private int id;
	private String numero;
	private String description;
	private int idTache;
	
	public Commit(){}
	
	public Commit(int idTache,String description, String numero){
		this.id =-1;
		this.idTache = idTache;
		this.description = description;
		this.numero = numero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdTache() {
		return idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}
	
	
	
	
}