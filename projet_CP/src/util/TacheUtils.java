package util;

import java.util.ArrayList;
import java.util.List;

import beans.Tache;
import dao.ITacheDAO;
import dao.TacheDAOimpl;

public class TacheUtils 
{
	public static String tacheListToString(List<Tache> listTaches)
	{
		StringBuilder stringListTache = new StringBuilder();
		int i = 0;
		for(Tache tache : listTaches)
		{
			stringListTache.append(tache.getTag());
			stringListTache.append(",");
			stringListTache.append(tache.getCout());
			i++;
			if(i<listTaches.size())
			{
				stringListTache.append(",");
			}
		}
		System.out.println("StringListTache : "+stringListTache.toString());
		return stringListTache.toString();
	}
	
	public static String tacheListDependanceToString(List<Tache> listTaches)
	{
		StringBuilder stringDependance = new StringBuilder();
		List<List<String>> listDependance = new ArrayList<List<String>>();
		ITacheDAO tacheDAO = new TacheDAOimpl();
	 	for(Tache tache : listTaches)
	 	{
	 		List<Tache> tachesEnDep = tacheDAO.listerDependanceTaches(tache.getIdTache());//tacheDAO.listerDependanceTaches(tache.getIdTache());
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
		 	stringDependance.append(tache.get(0));
		 	stringDependance.append(",");
		 	stringDependance.append(tache.get(1));
			l++;
			if(l<listDependance.size())
			{
				stringDependance.append(",");
			}
	 	}	
		System.out.println("String Dependance : "+stringDependance);
		return stringDependance.toString();
	}
	
	public static List<Tache> stringTachesToListTaches(String stringTaches)
	{
		//tagTaghe,4,SOL-2,20,A-Brique,1,A-Planche,1,MUR-1,2,tag 9000 ,1
		String listStringTaches[] = stringTaches.split(",");
		List<Tache> listTaches = new ArrayList<>();
		for(int i =0; i< listStringTaches.length;i+=2)
		{
			Tache tache = new Tache(listStringTaches[0], "", Integer.parseInt(listStringTaches[1]), "", -1);
			listTaches.add(tache);
		}
		
		return listTaches;
	}
	
	public static String[][] stringTachesDependanceToListDependance(String stringTaches)
	{
		//A-Brique,MUR-1,A-Brique,MUR,A-Planche,A-Planche,A-Planche,tagTaghe,A-Planche,SOL-2
		System.out.println(stringTaches);
		String listTag[] = stringTaches.split(",");
	 	int lignes = listTag.length/2;
	 	String dependance[][] = new String[lignes][2];
	 	int l = 0;
	 	for(int i = 0;i<lignes;i+=2)
	 	{
	 		dependance[l][0] = listTag[i];
			dependance[l][1] = listTag[++i];
			l++;
	 	}
		
		return dependance;
	}
}
