package Pert;

import beans.Tache;

public class Arc {
	private Etat source;
	private Etat destination;
	private Tache tache;
	private boolean reel;
	
	public Arc(Etat s,Etat d, Tache t,boolean reel) {
		source =s;
		destination = d;
		tache =t;
		this.reel =reel;
	}

	public boolean isReel() {
		return reel;
	}

	public void setReel(boolean reel) {
		this.reel = reel;
	}

	public Etat getSource() {
		return source;
	}

	public void setSource(Etat source) {
		this.source = source;
	}

	public Etat getDestination() {
		return destination;
	}

	public void setDestination(Etat destination) {
		this.destination = destination;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	@Override
	public String toString() {
		String res=  "";
		if(reel){
				res = res.concat(""+ tache.getTag() +","+ tache.getCout());
		}else{
			 res = res.concat(" ");
		}
		return res;
	}
	
	public String toStringDEBUG() {
		String res=  "Arc [source=" + source.getNoms() + ", destination=" + destination.getNoms();
		if(reel){
				res = res.concat(", tache=" + tache.getTag() +","+ tache.getCout()+ "]");
		}else{
			 res = res.concat("]");
		}
		return res;
	}
}
