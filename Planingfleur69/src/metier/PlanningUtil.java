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
	/*
	 * creer une tache et l'ajoute a un employee c'est juste initialisation inserer a la BD
	 */
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
	/*
	 * modifier le type de tache
	 */
	public void modifTachetype(Tache t,String str){
		t.setTypeDeTache(str);
	}
	/*
	 * modifier la date de debut de tache
	 */
	public void modifTachedatedebut(Tache t,Date dt){
		t.setDateDebutReal(dt);
	}
	/*
	 * modifier la date de fin de tache
	 */
	
	public void modifFinTache(Tache t,Date dateFinReal){
		t.setDateFin(dateFinReal);
	}
	/*
	 * supprimer une tache
	 */
	public void deleteTache(Tache t){
		t=null;
	}
	
	/*
	 * associer un materiel a la BD et inserer a la BD
	 */
	public void associerMatos(Tache t, Materiel m){
		List<Materiel> lsMatos = new ArrayList<Materiel>();
		lsMatos.addAll(t.getLstMatos());
		lsMatos.add(m);
		t.setLstMatos(lsMatos);
	}
	/*
	 * associer un employer a une tache et inserer a la BD
	 */
	public void associerEmploye(Tache t, Employe e){
		List<Employe> lsEmp = new ArrayList<Employe>();
		lsEmp.addAll(t.getLstEmploye());
		lsEmp.add(e);
		t.setLstEmploye(lsEmp);
	}
	
	
	
	


}
