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
	/*
	 * Creer un employe et mettre a la BD
	 */
	public void createEmploye(String nom, String prenom) throws SQLException {
		Employe emp = Factory.getEmploye();
		emp.setNom(nom);
		emp.setPrenom(prenom);
		DAODonnees daod = DAODonnees.getInstance();
		daod.Insert(emp);
	}
	/*
	 * rendre un employe en le cherchant a la BD
	 */
	public Employe rechercheEmployee(String nom, String prenom) throws SQLException {
		Employe emp = Factory.getEmploye();
		DAODonnees daod = DAODonnees.getInstance();
		emp = daod.chercherEmploye(nom, prenom);
		return emp;

	}
	/*
	 * modifier le nom et le prenom d'un employe
	 */
	public void modifEmploye(Employe e, String nom, String prenom) {
		e.setNom(nom);
		e.setPrenom(prenom);
	}
	/*
	 * permet de supprimer un employee
	 */
	public void deleteEmploye(Employe e) {
		e = null;
	}

}
