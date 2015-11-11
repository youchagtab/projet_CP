package Pert;

import java.util.ArrayList;

public class PertTemporaire{
	private String[] taches;
	private ArrayList<String> Sommet;
	private ArrayList<String[]>ArcFictif;
	private ArrayList<String[]>ArcReel;
	
	public PertTemporaire(ArrayList<String> s, ArrayList<String[]>ArcR, ArrayList<String[]>ArcF, String[] taches) {
		if(taches.length != ArcR.size()){
			System.out.println("Error:"+ taches.length +"!="+ ArcR.size());
		}else{
		this.Sommet =s;
		this.ArcFictif = ArcF;
		this.taches = taches;
		this.ArcReel = ArcR;
		}
	}

	public String[] getTaches() {
		return taches;
	}

	public void setTaches(String[] taches) {
		this.taches = taches;
	}

	public ArrayList<String> getSommet() {
		return Sommet;
	}

	public void setSommet(ArrayList<String> sommet) {
		Sommet = sommet;
	}

	public ArrayList<String[]> getArcFictif() {
		return ArcFictif;
	}

	public void setArcFictif(ArrayList<String[]> arcFictif) {
		ArcFictif = arcFictif;
	}

	public ArrayList<String[]> getArcReel() {
		return ArcReel;
	}

	public void setArcReel(ArrayList<String[]> arcReel) {
		ArcReel = arcReel;
	}

}
