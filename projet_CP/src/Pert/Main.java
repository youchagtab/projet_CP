package Pert;

import beans.Tache;
import dao.ITacheDAO;
import dao.TacheDAOimpl;
import java.util.List;
import com.mxgraph.canvas.mxHtmlCanvas;
import com.mxgraph.layout.*;
import com.mxgraph.layout.hierarchical.model.mxGraphHierarchyNode;
import com.mxgraph.swing.*;
import com.mxgraph.view.mxEdgeStyle;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import org.jgrapht.*;

import org.jgrapht.ext.*;
import org.jgrapht.graph.*;

public class Main extends JApplet{
	
	private static final long serialVersionUID = 2202072534703043194L;
    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);

    private JGraphXAdapter<Etat,Arc> jgxAdapter;
    
	public static void main(String [] args)
	{
		
		
		Main applet = new Main();
        applet.init();
        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("Diagramme de Pert");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    
	}
	 public void init()
	    {
		 	//Bdd::Tache
		 	int idSprint = 13;
		 	ITacheDAO tacheDAO = new TacheDAOimpl();
		 	List<Tache> listTaches = tacheDAO.listerTache(idSprint);
		 	
		 	//Bdd::Dependance
		 	List<List<String>> listDependance = new ArrayList<List<String>>();
		 	for(Tache tache : listTaches)
		 	{
		 		List<Tache> tachesEnDep = tacheDAO.listerDependanceTaches(tache.getIdTache());
		 		for(Tache tachedep : tachesEnDep)
		 		{
		 			System.out.println("-A-"+tache.getTag()+"<--"+tachedep.getTag()+"--");
					 List<String> listCouple = new ArrayList<String>();
					 listCouple.add(String.valueOf(tache.getTag()));
					 listCouple.add(String.valueOf(tachedep.getTag()));
					 listDependance.add(listCouple);
		 		}
		 	}
		 	System.out.println("Size of dependance : "+listDependance.size());
		 	int lignes = listDependance.size();
		 	String dependance[][] = new String[lignes][2];
		 	int l = 0;
		 	for(List<String> tache : listDependance)
		 	{
		 		System.out.println("-B-"+tache.get(0)+"<--"+tache.get(1)+"--");
		 		dependance[l][0] = tache.get(0);
				dependance[l][1] = tache.get(1);
				l++;
		 	}
		 	
		 	String[] tache = new String[listTaches.size()];
		 	Tache[] taches = new Tache[listTaches.size()];
		 	int index = 0;
		 	for(Tache tacheTmp : listTaches)
		 	{
		 		tache[index] = tacheTmp.getTag();
		 		taches[index] = tacheTmp;
		 		index++;
		 	}
		 	
			// Tache
			/*Tache tA = new Tache("A","", 10, "", -1);
			Tache tB = new Tache("B","", 10, "", -1);
			Tache tC = new Tache("C","", 10, "", -1);
			Tache tD = new Tache("D","", 10, "", -1);
			Tache tE = new Tache("E","", 10, "", -1);
			Tache tF = new Tache("F","", 10, "", -1);
			Tache tG = new Tache("G","", 10, "", -1);
			Tache tH = new Tache("H","", 10, "", -1);
			Tache tI = new Tache("I","", 10, "", -1);
			
			String A = "A";
			String B = "B";
			String C = "C";
			String D = "D";
			String E = "E";
			String F = "F";
			String G = "G";
			String H = "H";
			String I = "I";*/

			HashMap<String, Tache> Relation = new HashMap<>();
			//Table de Dependance 
			//String dependance[][] = {{D,A},{D,B},{D,C},{E,A},{E,C},{F,B},{F,C},{G,D},{G,E},{H,D},{H,E},{I,F}};
			//String tache[]={A,B,C,D,E,F,G,H,I};
			PertTemporaire pt = CalculPert.calculPert(dependance,tache);
			
			//Tache[] taches= {tA,tB,tC,tD,tE,tF,tG,tH,tI};
			Pert pert = new Pert(pt, taches);
			
	    	// create a JGraphT graph
			
	    	ListenableGraph<Etat, Arc> g =
	    			new ListenableDirectedGraph<Etat, Arc>(
	    					Arc.class );

	    	// create a visualization using JGraph, via an adapter
	    	jgxAdapter = new JGraphXAdapter<Etat, Arc>(g);

	    	getContentPane().add(new mxGraphComponent(jgxAdapter));
	    	resize(DEFAULT_SIZE);


	 
	    	for(Etat e : pert.getEtats()){
	    		g.addVertex(e);
	    	}	
	    	
	    	for(Arc a: pert.getArcFictif()){
	    		g.addEdge(a.getSource(), a.getDestination(), a);
	    	}
	    	
	    	for(Arc a: pert.getArcReel()){
	    		g.addEdge(a.getSource(), a.getDestination(), a);
	    	}
	    	
	    	mxCompactTreeLayout layout = new mxCompactTreeLayout(jgxAdapter);
	    
	    	layout.setNodeDistance(40);
	    	layout.setLevelDistance(40);
	    	
	    	layout.execute(jgxAdapter.getDefaultParent());
	    	


	    	try{
	            SwingUtilities.invokeAndWait(new Runnable(){
	              public void run(){

	              }
	            });             
	          }
	          catch(Exception e){
	            System.out.println(e);
	          }

	    }
}
