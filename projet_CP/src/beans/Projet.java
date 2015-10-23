package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Projet implements Serializable {
	
	protected int _idProjet;
	protected List<Utilisateur> _utilisateurs;
	protected String _noms;
	protected String _description;
	protected Backlog _backlog;
	
	public Projet(){		
	}
	
	public Projet(Utilisateur utilisateur, String noms, String description){
		_utilisateurs = new ArrayList<>();
		_utilisateurs.add(utilisateur);
		_noms = noms;
		_description = description;
		_idProjet = -1;
		//_backlog = new Backlog();
	}
	
	public Projet(List<Utilisateur> utilisateurs, String noms, String description){
		_utilisateurs = utilisateurs;
		_noms = noms;
		_description = description;
		//_backlog = new Backlog();
	}
	
	
	public Projet(String _noms, String _description) {
		
		this._noms = _noms;
		this._description = _description;
	}

	public int getIdProjet() {
		return _idProjet;
	}
	public void setIdProjet(int idProjet) {
		_idProjet = idProjet;
	}
	
	public List<Utilisateur> geUutilisateurs() {
		return _utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this._utilisateurs = utilisateurs;
	}
	public String getNoms() {
		return _noms;
	}
	public void setNoms(String noms) {
		this._noms = noms;
	}
	public String getDescription() {
		return _description;
	}
	public void setDescription(String description) {
		this._description = description;
	}
	public Backlog getBacklog() {
		return _backlog;
	}
	public void setBacklog(Backlog backlog) {
		this._backlog = backlog;
	}
	

}
