package Pert;

public class Etat {
	private String noms;
	private float auPlusTot;
	private float auPlusTard;
	
	public Etat(String noms) {
		this.noms=noms;
		this.auPlusTot = -1;
		this.auPlusTard = -1;
	}

	public String getNoms() {
		return noms;
	}

	public void setNoms(String noms) {
		this.noms = noms;
	}

	public float getAuPlusTot() {
		return auPlusTot;
	}

	public void setAuPlusTot(float d) {
		this.auPlusTot = d;
	}

	public float getAuPlusTard() {
		return auPlusTard;
	}

	public void setAuPlusTard(float auPlusTard) {
		this.auPlusTard = auPlusTard;
	}

	@Override
	public String toString() {
		return "" + noms + "\n" + auPlusTot
				+ "," + auPlusTard;
	}

	public String toStringDEBUG() {
		return "Etat [noms=" + noms + ", auPlusTot=" + auPlusTot
				+ ", auPlusTard=" + auPlusTard + "]";
	}
}
