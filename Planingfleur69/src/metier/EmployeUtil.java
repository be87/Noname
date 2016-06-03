package metier;

import java.sql.SQLException;

import Entite.Employe;
import Entite.Factory;
import dao.DAODonnees;

public class EmployeUtil {

	private static EmployeUtil instance = null;

	public static EmployeUtil getInstance() {
		if (instance == null) {
			instance = new EmployeUtil();
		}
		return instance;
	}

	public void createEmploye(String nom, String prenom) throws SQLException {
		Employe emp = Factory.getEmploye();
		emp.setNom(nom);
		emp.setPrenom(prenom);
		DAODonnees daod = DAODonnees.getInstance();
		daod.Insert(emp);
	}

	public Employe rechercheEmployee(String nom, String prenom) throws SQLException {
		Employe emp = Factory.getEmploye();
		DAODonnees daod = DAODonnees.getInstance();
		emp = daod.chercherEmploye(nom, prenom);
		return emp;

	}

	public void modifEmploye(Employe e, String nom, String prenom) {
		e.setNom(nom);
		e.setPrenom(prenom);
	}

	public void deleteEmploye(Employe e) {
		e = null;
	}

}
