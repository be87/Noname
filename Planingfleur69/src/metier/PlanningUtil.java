package metier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entite.Employe;
import Entite.Factory;
import Entite.Materiel;
import Entite.Tache;
import dao.DAODonnees;

public class PlanningUtil {
	private static PlanningUtil instance = null;
	
	public static PlanningUtil getInstance(){
		if(instance==null){
			instance= new PlanningUtil();
		}
		return instance;		
	}
	
	private PlanningUtil() {
	}
	
	public Tache addTache(Employe e, String typeDeTache, String adresse, Date dateDebut, Date dateFinReal) throws SQLException{
		
		List<Employe> lstEmployee = new ArrayList<Employe>();
		List<Materiel> lstMateriel = new ArrayList<Materiel>();
		lstEmployee.add(e);
		
		Tache ts = Factory.getTache();
		ts.setDateDebutReal(dateDebut);
		ts.setLstEmploye(lstEmployee);
		ts.setTypeDeTache(typeDeTache);
		ts.setAdresse(adresse);
		ts.setDateFin(dateFinReal);
		ts.setTypeDeTache(typeDeTache);
		ts.setLstMatos(lstMateriel);
		DAODonnees DAOD = DAODonnees.getInstance();
		DAOD.Insert(ts);
		return ts;
		
	}
	
	public void modifTachetype(Tache t,String str){
		t.setTypeDeTache(str);
	}
	
	public void modifTachedatedebut(Tache t,Date dt){
		t.setDateDebutReal(dt);
	}
	
	public void modifFinTache(Tache t,Date dateFinReal){
		t.setDateFin(dateFinReal);
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
