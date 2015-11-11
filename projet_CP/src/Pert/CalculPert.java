package Pert;

import java.lang.reflect.Array;
import java.util.*;

import beans.Tache;



public class CalculPert {



	public static PertTemporaire  calculPert(String[][] Dependance,String[] Tache){
		/**
		 *F. S TERBOUL
		 *D. W ERTHEIMER
		 *Comment construire un graphe PERT minimal
		 *Revue française d’automatique, d’informatique et de recherche
		 *opérationnelle. Recherche opérationnelle, tome 15, n o 1 (1981),
		 *p. 85-98.
		 **/


		HashMap<String, ArrayList<String>> P = calculP(Dependance, Tache);
		HashMap<String, ArrayList<String>> Q = calculQ(Dependance, Tache);

		// 1.
		ArrayList<String> Il = determinationCi(Tache, P);
		// 2.
		ArrayList<String> Jm = determinationDi(Tache, Q);
		//3.
		ArrayList<ArrayList<String>> V = calculV(P, Il, Jm);
		ArrayList<ArrayList<String>> W = calculW(Q, Il, Jm);
		ArrayList<ArrayList<String>> _V = calcul_V(P, Il, Jm);

		//4.
		String T[] = calculT(P, Il, Jm, V, W, _V);
		//4.5
		ArrayList<String> Sommet= calculSommets(Jm, Il, T);
		ArrayList<String[]>ArcReel = calculArcReel(P, Q, Jm, Il, Tache, T);
		ArrayList<String[]>ArcFictif = calculArcFictif(P, Q, Jm, Il, W, Tache, T);
		
		return new PertTemporaire(Sommet,ArcReel,ArcFictif,Tache);
	}

	public static boolean in(String[] tab,String s){
		for(int i =0; i<tab.length;i++){
			if(s.equals(tab[i])){
				return true;
			}
		}
		return false;
	}

	public static HashMap<String, ArrayList<String>> calculP(String[][] Dependance,String[] Tache){
		HashMap<String, ArrayList<String>> P = new HashMap<>(Tache.length);
		for(int i=0; i<Tache.length;i++){
			ArrayList<String> pi = new ArrayList<String>();
			for(int j=0; j<Dependance.length;j++){
				if(Tache[i]==Dependance[j][0]){
					pi.add(Dependance[j][1] );
				}
			}
			P.put(Tache[i],pi);
		}
		/*System.out.println("P(i):");
		 for(int i=0; i<Tache.length; i++){
		 System.out.println(Tache[i]+ ":"+ P.get(Tache[i]));
	 }
	 System.out.println("");*/
		return P;
	}

	public static HashMap<String, ArrayList<String>> calculQ(String[][] Dependance,String[] Tache){
		HashMap<String, ArrayList<String>> Q = new HashMap<>(Tache.length);
		for(int i=0; i<Tache.length;i++){
			ArrayList<String> qi= new ArrayList<String>();
			for(int j=0; j<Dependance.length;j++){
				if(Tache[i]==Dependance[j][1]){
					qi.add(Dependance[j][0]);
				}
			}
			Q.put(Tache[i],qi);
		}
		/*
		 System.out.println("Q(i):");
		 for(int i=0; i<Tache.length; i++){
			 System.out.println(Tache[i]+ ":"+ Q.get(Tache[i]));
		 }
		 System.out.println("");
		 */
		return Q;
	}

	public static ArrayList<String> determinationCi(String[] Tache, HashMap<String, ArrayList<String>> P){
		ArrayList<String> Il = new ArrayList<String>();
		int[] coloration = new int[Tache.length];
		for(int i=0; i < Tache.length; i++){ coloration[i]=0; }

		for(int l=0; l < Tache.length; l++){
			if(coloration[l]==0){
				Il.add(Tache[l]);
				for(int j=0; j<Tache.length; j++){
					if(P.get(Tache[l]).equals(P.get(Tache[j]))){
						coloration[j]=1;
					}
				}
			}
		}
		/*
		 for(int l=0; l<Il.size(); l++){
			 System.out.println("I"+l+ ":"+ Il.get(l));
		 }
		 System.out.println("");
		 */
		return Il;
	}


	public static ArrayList<String> determinationDi(String[] Tache, HashMap<String, ArrayList<String>> Q){
		ArrayList<String> Jm = new ArrayList<String>();
		int[] coloration = new int[Tache.length];
		for(int i=0; i < Tache.length; i++){ coloration[i]=0; }
		for(int m=0; m < Tache.length; m++){
			if(coloration[m]==0){
				Jm.add(Tache[m]);
				for(int j=0; j<Tache.length; j++){
					if(Q.get(Tache[m]).equals(Q.get(Tache[j]))){
						coloration[j]=1;
					}
				}
			}
		}
		/*	
		for(int m=0; m<Jm.size(); m++){
			System.out.println("J"+m+ ":"+ Jm.get(m));
		}
		 */
		return Jm;
	}
	public static ArrayList< ArrayList<String>> calculV (HashMap<String, ArrayList<String>> P, ArrayList<String> Il, ArrayList<String> Jm){
		ArrayList<ArrayList<String>> V = new ArrayList<ArrayList<String>>();
		for(int l=0; l<Il.size();l++){
			ArrayList<String> vil = new ArrayList<String>();
			for(int m=0; m<Jm.size(); m++){
				if(P.get(Il.get(l)).contains(Jm.get(m))){
					vil.add(Jm.get(m));
				}
			}
			V.add(vil);
		}
		/*
		for(int l=0; l<Il.size(); l++){
			System.out.println("V"+l+ ":"+ V.get(l));
		}
		System.out.println("");*/
		return V;
	}

	public static ArrayList< ArrayList<String>> calculW (HashMap<String, ArrayList<String>> Q, ArrayList<String> Il, ArrayList<String> Jm){
		ArrayList<ArrayList<String>> W = new ArrayList<ArrayList<String>>();
		for(int m=0; m<Jm.size();m++){
			ArrayList<String> wjm = new ArrayList<String>();
			for(int l=0; l<Il.size(); l++){
				if(Q.get(Jm.get(m)).contains(Il.get(l))){
					wjm.add(Il.get(l));
				}
			}
			W.add(wjm);
		}
		/*
	    for(int m=0; m<Jm.size(); m++){
			System.out.println("W"+m+ ":"+ W.get(m));
	    }
	    System.out.println("");*/
		return W;
	}

	public static ArrayList< ArrayList<String>> calcul_V (HashMap<String, ArrayList<String>> P, ArrayList<String> Il, ArrayList<String> Jm){
		ArrayList<ArrayList<String>> _V = new ArrayList<ArrayList<String>>();
		for(int l=0; l<Il.size();l++){
			ArrayList<String> _vil = new ArrayList<String>();
			for(int m=0; m<Jm.size(); m++){
				if(P.get(Il.get(l)).contains(Jm.get(m))){
					_vil.add(Jm.get(m));
					ArrayList<String> Pjm = P.get(Jm.get(m));
					for(int k=0;k<Pjm.size();k++){
						_vil.add(Pjm.get(k));
					}
				}
			}
			_V.add(_vil);
		}
		/*
	for(int l=0; l<Il.size(); l++){
		System.out.println("_V"+l+ ":"+ _V.get(l));
	}
	System.out.println("");*/
		return _V;
	}

	public static String[] calculT (HashMap<String, ArrayList<String>> P, ArrayList<String> Il, ArrayList<String> Jm,ArrayList< ArrayList<String>> V, ArrayList< ArrayList<String>> W,ArrayList< ArrayList<String>> _V ){
		String T[] = new String[6];
		for(int m=0; m<Jm.size();m++){
			if(!W.get(m).isEmpty()){
				if(W.get(m).size()!=1){
					ArrayList<String> F =(ArrayList<String>) _V.get(Il.lastIndexOf(W.get(m).get(0))).clone();
					for(int i=1;i<W.get(m).size();i++){
						ArrayList<String> _Vs = _V.get(Il.lastIndexOf(W.get(m).get(i)));
						for(int k=0; k < F.size();k++){
							if(!_Vs.contains(F.get(k))){
								F.remove(F.get(k));
							}
						}
					}

					for(int i=0;i<W.get(m).size();i++){
						ArrayList<String> Vi = V.get(Il.lastIndexOf(W.get(m).get(i)));
						boolean ViinF = true;
						for(int k=0; k<Vi.size();k++){
							if(!F.contains(Vi.get(k))){
								ViinF = false;
							}
						}
						if(ViinF && !in(T,W.get(m).get(i))){
							T[m]=W.get(m).get(i);
							i = W.get(m).size();
						}
					}
				}else{
					T[m]= W.get(m).get(0);
				}
			} 
		}
		/*
		for(int i=0; i<T.length;i++){
			System.out.println("T["+i+"] ="+T[i]);
		}
		System.out.println("");*/
		return T;
	}
	
	public static ArrayList<String>calculSommets(ArrayList<String> Jm,ArrayList<String> Il, String[] T){
		ArrayList<String> Sommet= new ArrayList<String>();
		for(int m=0; m<Jm.size();m++){
			Sommet.add(Jm.get(m)+Jm.get(m));
		}
		for(int l=0;l<Il.size();l++){
			if(!in(T,Il.get(l))){
				Sommet.add(Il.get(l)+Il.get(l)+"+1");
			}
		}
		//System.out.println("Sommet:"+Sommet);
		return Sommet;
	}
	public static ArrayList<String[]> calculArcReel(HashMap<String, ArrayList<String>> P, HashMap<String, ArrayList<String>> Q,ArrayList<String> Jm,ArrayList<String> Il,String[] Tache, String[] T){
			ArrayList<String[]>ArcReel = new ArrayList<String[]>();
			for(int i=0; i<Tache.length;i++){
				int l = -1;
				int m = -1;
				for(int mm=0; mm<Jm.size();mm++){
					if(Q.get(Tache[i]).equals(Q.get(Jm.get(mm)))){
						m = mm;
					}
				}
				for(int ll=0; ll<Il.size();ll++){
					if(P.get(Tache[i]).equals(P.get(Il.get(ll)))){
						l = ll;
					}
				}

				if(!in(T,Il.get(l))){
					String[] arc = {Il.get(l)+Il.get(l)+"+1",Jm.get(m)+Jm.get(m)};
					ArcReel.add(arc);
				}else{
					int k =-1;
					for(int r =0; r<T.length;r++){
						if(Il.get(l).equals(T[r])){
							k =r;
						}
					}
					String[] arc = {Jm.get(k)+Jm.get(k),Jm.get(m)+Jm.get(m)};
					ArcReel.add(arc); 
				}
			}
			/*
			System.out.println("Arc reel:");
			for(int i=0;i<ArcReel.size();i++){
				System.out.println("{"+ArcReel.get(i)[0]+","+ArcReel.get(i)[1]+"}");
			}*/
			return ArcReel;
	}
	public static ArrayList<String[]> calculArcFictif(HashMap<String, ArrayList<String>> P, HashMap<String, ArrayList<String>> Q,ArrayList<String> Jm,ArrayList<String> Il,ArrayList< ArrayList<String>> W,String[] Tache, String[] T){
	ArrayList<String[]>ArcFictif = new ArrayList<String[]>();
	for(int m=0; m<Jm.size();m++){
		for(int l=0; l<W.get(m).size();l++){
			if(!in(T,W.get(m).get(l))){
				String[] arc = {Jm.get(m)+Jm.get(m),W.get(m).get(l)+W.get(m).get(l)+"+1"};
				ArcFictif.add(arc);
			}else{
				int k =-1;
				for(int r =0; r<T.length;r++){
					if(W.get(m).get(l).equals(T[r])){
						k =r;
					}
				}
				if(k!=m){
					String[] arc = {Jm.get(m)+Jm.get(m),Jm.get(k)+Jm.get(k)};
					ArcFictif.add(arc);
				}
			}

		}
	}
	/*
	System.out.println("Arc fictif:");
	for(int i=0;i<ArcFictif.size();i++){
		System.out.println("{"+ArcFictif.get(i)[0]+","+ArcFictif.get(i)[1]+"}");
	}*/
	return ArcFictif;
	}
}




