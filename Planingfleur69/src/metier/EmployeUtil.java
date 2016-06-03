package metier;

public class EmployeUtil {

	private static EmployeUtil instance = null;

	public static EmployeUtil getInstance() {
		if (instance == null) {
			instance = new EmployeUtil();
		}
		return instance;
	}
	
	public void modifEmploye(Employe e, String nom, String prenom){
		e.nom = nom;
		e.prenom = prenom;
	}
	
	public void deleteEmploye(Employe e){
		e = null;
	}
	
}
