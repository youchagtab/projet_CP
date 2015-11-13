package beans;

public class Sprint 
{
	protected int idSprint;
	protected int idProjet;
	protected int numero;
	
	
	public Sprint() 
	{
	}

	public Sprint(int idSprint, int idProjet, int numero) 
	{
		this.idSprint = idSprint;
		this.idProjet = idProjet;
		this.numero = numero;
	}	
	
	public Sprint(int idProjet, int numero) 
	{
		this.idProjet = idProjet;
		this.numero = numero;
	}
	
	public int getIdSprint() {
		return idSprint;
	}
	public void setIdSprint(int idSprint) {
		this.idSprint = idSprint;
	}
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
