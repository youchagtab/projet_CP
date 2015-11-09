package Pert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import beans.Tache;

public class Pert {
	private ArrayList<Etat> etats;
	private ArrayList<Arc> arcFictif;
	private ArrayList<Arc> arcReel;
	private Etat etatInital;
	private Etat etatFinale;
	
	public Pert(PertTemporaire pertT,Tache[] tache) {
		
		HashMap<String, Etat> HMEtat = new HashMap<String,Etat>();
		ArrayList<String > pertTSommet = pertT.getSommet();
		this.etats=new ArrayList<Etat>();
		for(int i=0; i<pertTSommet.size();i++){
			Etat e =new Etat(""+i);
			HMEtat.put(pertTSommet.get(i), e);
			this.etats.add(e);
		}
		/*
		System.out.println("Liste d'Etat:");
		for(Etat e: etats){
			System.out.println(e);
		}
	    */
		ArrayList<String[]> pertTArcR = pertT.getArcReel();
		this.arcReel = new ArrayList<Arc>();
		for(int i=0; i<pertTArcR.size();i++){
			Arc a = new Arc(HMEtat.get(pertTArcR.get(i)[0]), HMEtat.get(pertTArcR.get(i)[1]), tache[i], true);
			this.arcReel.add(a);
		}
		/*
		System.out.println("Liste d'Arc reel:");
		for(Arc a: arcReel){
			System.out.println(a);
		}
		*/
		ArrayList<String[]> pertTArcF = pertT.getArcFictif();
		this.arcFictif = new ArrayList<Arc>();
		for(int i=0; i<pertTArcF.size();i++){
			Arc a = new Arc(HMEtat.get(pertTArcF.get(i)[0]), HMEtat.get(pertTArcF.get(i)[1]), null, false);
			this.arcFictif.add(a);
		}
		/*
		System.out.println("Liste d'Arc fictif:");
		for(Arc a: arcFictif){
			System.out.println(a);
		}
		*/
		for(int i=0; i<etats.size();i++){
			boolean init = true;
			boolean terminal = true;
			for(int j=0; j<arcReel.size(); j++){
				if(arcReel.get(j).getDestination().equals(etats.get(i))){
					init = false;
				}
				if(arcReel.get(j).getSource().equals(etats.get(i))){
					terminal = false;
				}
			}
			for(int j=0; j<arcFictif.size(); j++){
				if(arcFictif.get(j).getDestination().equals(etats.get(i))){
					init = false;
				}
				if(arcFictif.get(j).getSource().equals(etats.get(i))){
					terminal = false;
				}
			}
			if(init){
				this.etatInital = etats.get(i);
			}
			if(terminal){
				this.etatFinale = etats.get(i);
			}
		}
		Arc[] bug = new Arc[2];
		while(ExisteUnDoubleArc(bug)){
			Arc a = bug[0];
			Arc b = bug[1];
			if(a.getTache()!=b.getTache() && a.getSource()==b.getSource() && a.getDestination()==b.getDestination()){
						Etat nouvelleEtatB = new Etat(""+etats.size());
						Etat nouvelleEtatA = new Etat(""+(etats.size()+1));
						etats.add(nouvelleEtatA);
						etats.add(nouvelleEtatB);

						Arc nouveauB = new Arc(b.getSource(), nouvelleEtatB, b.getTache(), true);
						Arc nouveauA = new Arc(a.getSource(), nouvelleEtatA, a.getTache(), true);

						Arc fictifBDestination = new Arc(nouvelleEtatB, b.getDestination(), null, false);
						Arc fictifADestination = new Arc(nouvelleEtatA, a.getDestination(), null, false);

						this.arcReel.remove(a);
						this.arcReel.remove(b);

						this.arcReel.add(nouveauA);
						this.arcReel.add(nouveauB);

						this.arcFictif.add(fictifADestination);
						this.arcFictif.add(fictifBDestination);
			}			
		}
		
		this.calculAuPlustot();
		this.calculAuplusTard();
	}

	public ArrayList<Etat> getEtats() {
		return etats;
	}

	public void setEtats(ArrayList<Etat> etats) {
		this.etats = etats;
	}

	public ArrayList<Arc> getArcFictif() {
		return arcFictif;
	}

	public void setArcFictif(ArrayList<Arc> arcFictif) {
		this.arcFictif = arcFictif;
	}

	public ArrayList<Arc> getArcReel() {
		return arcReel;
	}

	public void setArcReel(ArrayList<Arc> arcReel) {
		this.arcReel = arcReel;
	}

	public Etat getEtatInital() {
		return etatInital;
	}

	public void setEtatInital(Etat etatInital) {
		this.etatInital = etatInital;
	}

	public Etat getEtatFinale() {
		return etatFinale;
	}

	public void setEtatFinale(Etat etatFinale) {
		this.etatFinale = etatFinale;
	}
	
	public String toString(){
		String res = new String(" ");
		
		res =res.concat("Liste d'Etat:\n");
		for(Etat e: etats){
			res=res.concat(e.toString()+"\n");
		}
	    res=res.concat("Liste d'Arc reel:\n");
		for(Arc a: arcReel){
			res=res.concat(a.toString()+"\n");
		}
		res=res.concat("Liste d'Arc fictif:\n");
		for(Arc a: arcFictif){
			res=res.concat(a.toString()+"\n");
		}
		res=res.concat("init:" + etatInital);
		res=res.concat("final:" + etatFinale);
		return res;
	}
	
	private boolean ExisteUnDoubleArc(Arc[] bug){
		//private ArrayList<Arc> arcReel;
		for(Arc a: arcReel){
			for(Arc b: arcReel){
				if(a.getTache()!=b.getTache() && a.getSource()==b.getSource() && a.getDestination()==b.getDestination()){
					bug[0]=a;
					bug[1]=b;
					return true;
				}
			}
		}
		return false;
	}
	
	private void calculAuPlustot(){
		Etat init =this.getEtatInital();
		init.setAuPlusTot(0);
		for(int i=0; i<this.getArcReel().size();i++){
			Arc arc=this.getArcReel().get(i);
			if(arc.getSource().equals(init)){
				calculAuPlusTot(arc.getDestination(),arc);
			}
		}
		for(int i=0; i<this.getArcFictif().size();i++){
			Arc arc=this.getArcFictif().get(i);
			if(arc.getSource().equals(init)){
				calculAuPlusTot(arc.getDestination(),arc);
			}
		}
	}
	
	private void calculAuPlusTot(Etat e, Arc a){
		if(a.isReel()){
			if(a.getSource().getAuPlusTot()+a.getTache().getCout()>e.getAuPlusTot()){
				e.setAuPlusTot(a.getSource().getAuPlusTot()+a.getTache().getCout());
			}
		}else{
			if(a.getSource().getAuPlusTot()>e.getAuPlusTot()){
				e.setAuPlusTot(a.getSource().getAuPlusTot());
			}
		}
		for(int i=0; i<this.getArcReel().size();i++){
			Arc arc=this.getArcReel().get(i);
			if(arc.getSource().equals(e)){
				calculAuPlusTot(arc.getDestination(),arc);
			}
		}
		for(int i=0; i<this.getArcFictif().size();i++){
			Arc arc=this.getArcFictif().get(i);
			if(arc.getSource().equals(e)){
				calculAuPlusTot(arc.getDestination(),arc);
			}
		}
		
	}
	
	private void calculAuplusTard(){
		Etat etatf = this.getEtatFinale();
		etatf.setAuPlusTard(etatf.getAuPlusTot());
		for(int i=0; i<this.getArcReel().size();i++){
			Arc arc=this.getArcReel().get(i);
			if(arc.getDestination().equals(etatf)){
				calculAuPlusTard(arc.getSource(),arc);
			}
		}
		for(int i=0; i<this.getArcFictif().size();i++){
			Arc arc=this.getArcFictif().get(i);
			if(arc.getDestination().equals(etatf)){
				calculAuPlusTard(arc.getSource(),arc);
			}
		}
	}
	
	private void calculAuPlusTard(Etat e, Arc a){
		if(a.isReel()){
			if(a.getDestination().getAuPlusTard()-a.getTache().getCout()<e.getAuPlusTard() || e.getAuPlusTard()==-1){
				e.setAuPlusTard(a.getDestination().getAuPlusTard()-a.getTache().getCout());
			}
		}else{
			if(a.getDestination().getAuPlusTard()<e.getAuPlusTard() || e.getAuPlusTard()==-1){
			e.setAuPlusTard(a.getDestination().getAuPlusTard());
		}
		}
		for(int i=0; i<this.getArcReel().size();i++){
			Arc arc=this.getArcReel().get(i);
			if(arc.getDestination().equals(e)){
				calculAuPlusTard(arc.getSource(),arc);
			}
		}
		for(int i=0; i<this.getArcFictif().size();i++){
			Arc arc=this.getArcFictif().get(i);
			if(arc.getDestination().equals(e)){
				calculAuPlusTard(arc.getSource(),arc);
			}
		}
		
	}
}
