package controller;

import java.util.ArrayList;
import java.util.List;

import beans.Projet;


public class AcceuilModel {
	
	private String motCle;
	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	List<Projet> projets = new ArrayList<Projet>();

	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	
	
	
}
