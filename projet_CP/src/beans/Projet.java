package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Projet implements Serializable {
	
	protected int _idProjet;
	protected String _noms;
	protected String _description;
	protected Backlog _backlog;
	protected String _repertoireGitHub;
	
	public Projet(){		
	}
	
	public Projet(String noms, String description){
		_noms = noms;
		_description = description;
		_idProjet = -1;
		_repertoireGitHub = "";
		//_backlog = new Backlog();
	}
		

	public int getIdProjet() {
		return _idProjet;
	}
	public void setIdProjet(int idProjet) {
		_idProjet = idProjet;
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

	public String getRepertoireGitHub() {
		return _repertoireGitHub;
	}

	public void setRepertoireGitHub(String repertoireGitHub) {
		this._repertoireGitHub = repertoireGitHub;
	}
	
	public boolean estGitHub(){
		return !_repertoireGitHub.isEmpty();
	}
}
