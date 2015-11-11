package Pert;

import beans.Tache;

import com.mxgraph.canvas.mxHtmlCanvas;
import com.mxgraph.layout.*;
import com.mxgraph.layout.hierarchical.model.mxGraphHierarchyNode;
import com.mxgraph.swing.*;
import com.mxgraph.view.mxEdgeStyle;

import java.awt.*;
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
			// Tache
		 
		    
			Tache tA = new Tache("A","", 10, "", -1);
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
			String I = "I";

			HashMap<String, Tache> Relation = new HashMap<>();
			//Table de Dependance 
			String dependance[][] = {{D,A},{D,B},{D,C},{E,A},{E,C},{F,B},{F,C},{G,D},{G,E},{H,D},{H,E},{I,F}};
			String tache[]={A,B,C,D,E,F,G,H,I};
			PertTemporaire pt = CalculPert.calculPert(dependance,tache);
			
			Tache[] taches= {tA,tB,tC,tD,tE,tF,tG,tH,tI};
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

	    }
}
