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
		//_backlog = new Backlog();
	}
	
	public Projet(List<Utilisateur> utilisateurs, String noms, String description){
		_utilisateurs = utilisateurs;
		_noms = noms;
		_description = description;
		//_backlog = new Backlog();
	}
	
	
	public int get_idProjet() {
		return _idProjet;
	}
	public void set_idProjet(int _idProjet) {
		this._idProjet = _idProjet;
	}
	public List<Utilisateur> get_utilisateurs() {
		return _utilisateurs;
	}
	public void set_utilisateurs(List<Utilisateur> _utilisateurs) {
		this._utilisateurs = _utilisateurs;
	}
	public String get_noms() {
		return _noms;
	}
	public void set_noms(String _noms) {
		this._noms = _noms;
	}
	public String get_description() {
		return _description;
	}
	public void set_description(String _description) {
		this._description = _description;
	}
	public Backlog get_backlog() {
		return _backlog;
	}
	public void set_backlog(Backlog _backlog) {
		this._backlog = _backlog;
	}
	

}
