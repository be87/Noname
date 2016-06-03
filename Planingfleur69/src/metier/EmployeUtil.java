package metier;

import Entite.Employe;

public class EmployeUtil {

	private static EmployeUtil instance = null;

	public static EmployeUtil getInstance() {
		if (instance == null) {
			instance = new EmployeUtil();
		}
		return instance;
	}

	public void modifEmploye(Employe e, String nom, String prenom) {
		e.setNom(nom);
		e.setPrenom(prenom);
	}

	public void deleteEmploye(Employe e) {
		e = null;
	}

}
