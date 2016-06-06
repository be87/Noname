package presentation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Entite.Employe;
import Entite.Factory;
import Entite.Materiel;
import Entite.Tache;
import dao.DAODonnees;
import metier.EmployeUtil;
import metier.MaterielUtil;
import metier.PlanningUtil;

public class Exec {

	public static void main(String[] args) throws ParseException, SQLException {
		
//		EmployeUtil eu = EmployeUtil.getInstance();
//		MaterielUtil mu = MaterielUtil.getInstance();
//		PlanningUtil pu = PlanningUtil.getInstance();
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		Employe e = Factory.getEmploye();
//		Employe e1 = Factory.getEmploye();
//		Materiel m = Factory.getMateriel();
//		Materiel m1 = Factory.getMateriel();
//		Tache t = pu.addTache(e, "debrouissailler","Allee des noisetiers", sdf.parse("2016-06-03"), sdf.parse("2016-06-04"));
//		
//		eu.modifEmploye(e, "Wallace", "William");
//		eu.modifEmploye(e1, "Rabbit", "Roger");
//		mu.modifMateriel(m, "scie cirulaire");
//		mu.modifMateriel(m1, "rotofil");
//		
//		t.setIdTache(1);
//		e.setId(1);
//		m.setIdMateriel(1);		
//		
//		System.out.println(e);
//		System.out.println(m);
//		System.out.println(t);
//		
//		pu.associerMatos(t, m);
//		pu.associerMatos(t, m1);
//		
//		System.out.println(t.getLstMatos());
//		
//		pu.associerEmploye(t, e1);
//		
//		System.out.println(t.getLstEmploye());
		EmployeUtil eu = EmployeUtil.getInstance();
//		eu.createEmploye("Bez", "Baz");
		
		Employe e = Factory.getEmploye();
//		
		e = eu.rechercheEmployee("Benzema", "Karim");
		System.out.println(e);
		DAODonnees dao = DAODonnees.getInstance();
		
//		System.out.println(e);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
		Date dt1 = sdf.parse("2015-05-02");
		Date dt2 = sdf.parse("2015-06-08");
//		
		PlanningUtil pu = PlanningUtil.getInstance();
		PlanningUtil pu1 = PlanningUtil.getInstance();
		
		Tache t = Factory.getTache();
		t=dao.chercherTache("rhone");
		
		
//		
		
		pu.associerEmploye(t, e);
		

	}

}
