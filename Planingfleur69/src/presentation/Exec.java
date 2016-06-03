package presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import Entite.Employe;
import Entite.Factory;
import Entite.Materiel;
import Entite.Tache;
import metier.EmployeUtil;
import metier.MaterielUtil;
import metier.PlanningUtil;

public class Exec {

	public static void main(String[] args) throws ParseException {
		
		EmployeUtil eu = EmployeUtil.getInstance();
		MaterielUtil mu = MaterielUtil.getInstance();
		PlanningUtil pu = PlanningUtil.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Employe e = Factory.getEmploye();
		Materiel m = Factory.getMateriel();
		Tache t = pu.addTache(e, "debrouissailler", "Allee des noisetiers", sdf.parse("2016-06-03"), 1);
		
		eu.modifEmploye(e, "Wallace", "William");
		mu.modifMateriel(m, "scie cirulaire");
		
		e.setId(1);
		m.setIdMateriel(1);
		
		
		System.out.println(e);
		System.out.println(m);
		System.out.println(t);
		
		
		

	}

}
