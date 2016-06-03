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
	
	public Tache addTache(Employe e,String typeDeTache, String adresse, Date dateDebut, Integer duree){
		
		List<Employe> lstEmploye = new ArrayList<Employe>();
		List<Materiel> lstMateriel = new ArrayList<Materiel>();
		lstEmploye.add(e);
		
		Tache ts = Factory.getTache();
		ts.setDateDebutReal(dateDebut);
		ts.setLstEmploye(lstEmploye);
		ts.setTypeDeTache(typeDeTache);
		ts.setDureejour(duree);
		ts.setTypeDeTache(typeDeTache);
		ts.setLstMatos(lstMateriel);
		return ts;
		
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
	public void associerMatos(Tache t, Materiel m){
		List<Materiel> lsMatos = new ArrayList<Materiel>();
		lsMatos.addAll(t.getLstMatos());
		lsMatos.add(m);
		t.setLstMatos(lsMatos);
	}
	
	public void associerEmploye(Tache t, Employe e){
		List<Employe> lsEmp = new ArrayList<Employe>();
		lsEmp.addAll(t.getLstEmploye());
		lsEmp.add(e);
		t.setLstEmploye(lsEmp);
	}
	
	
	
	


}
