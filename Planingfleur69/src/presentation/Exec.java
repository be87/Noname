package presentation;

import Entite.Employe;
import Entite.Factory;
import Entite.Materiel;
import Entite.Tache;
import metier.EmployeUtil;
import metier.MaterielUtil;

public class Exec {

	public static void main(String[] args) {
		
		Employe e = Factory.getEmploye();
		Materiel m = Factory.getMateriel();
		Tache t = Factory.getTache();
		
		EmployeUtil eu = EmployeUtil.getInstance();
		MaterielUtil mu = MaterielUtil.getInstance();
		//PlanningUtil pu = PlanningUtil.getInstance();
		
		eu.modifEmploye(e, "Wallace", "William");
		mu.modifMateriel(m, "scie cirulaire");
		
		System.out.println(e);
		System.out.println(m);
		
		
		

	}

}
