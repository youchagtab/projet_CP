package beans;

public class Utilisateur 
{
	protected int _idUtilisateur;
	protected String _identifiant;
	protected String _motDePasse;
	protected String _nom;
	protected String _prenom;
	
	
	
	public Utilisateur() {
	}

	public Utilisateur(int idUtilisateur, String identifiant, String motDePasse, String nom, String prenom) 
	{
		this._idUtilisateur = idUtilisateur;
		this._identifiant = identifiant;
		this._motDePasse = motDePasse;
		this._nom = nom;
		this._prenom = prenom;
	}

	public Utilisateur( String identifiant, String motDePasse, String nom, String prenom) 
	{
		this._identifiant = identifiant;
		this._motDePasse = motDePasse;
		this._nom = nom;
		this._prenom = prenom;
	}

	public int getIdUtilisateur() 
	{
		return _idUtilisateur;
	}
	
	public String getIdentifiant() 
	{
		return _identifiant;
	}
	
	public void setIdentifiant(String identifiant) 
	{
		this._identifiant = identifiant;
	}
	
	public String getMotDePasse() 
	{
		return _motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) 
	{
		this._motDePasse = motDePasse;
	}
	
	public String getNom() 
	{
		return _nom;
	}
	
	public void setNom(String nom) 
	{
		this._nom = nom;
	}
	
	public String getPrenom() 
	{
		return _prenom;
	}
	
	public void setPrenom(String prenom) 
	{
		this._prenom = prenom;
	}


}
