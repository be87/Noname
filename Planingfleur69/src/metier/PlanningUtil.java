package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entite.Employe;
import Entite.Factory;
import Entite.Materiel;
import Entite.Tache;

public class PlanningUtil {
	private static PlanningUtil instance = null;
	
	public static PlanningUtil getInstance(){
		if(instance==null){
			instance= new PlanningUtil();
		}
		return instance;		
	}
	
	private PlanningUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public void addTache(Employe e,String typeDeTache, String adresse, Date dateDebut, Integer duree){
		
		List<Employe> lstEmployee = new ArrayList<Employe>();
		List<Materiel> lstMateriel = new ArrayList<Materiel>();
		lstEmployee.add(e);
		
		Tache ts = Factory.getTache();
		ts.setDateDebutReal(dateDebut);
		ts.setLstEmploye(lstEmployee);
		ts.setTypeDeTache(typeDeTache);
		ts.setDureejour(duree);
		ts.setTypeDeTache(typeDeTache);
		ts.setLstMatos(lstMateriel);
		
	}
	
	public void modifTachetype(Tache t,String str){
		t.setTypeDeTache(str);
	}
	
	public void modifTachedatedebut(Tache t,Date dt){
		t.setDateDebutReal(dt);
	}
	
	public void modifTacheduree(Tache t,Integer jour){
		t.setDureejour(jour);
	}
	public void deleteTache(Tache t){
		t=null;
	}
	
	


}
