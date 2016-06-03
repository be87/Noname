package metier;

import Entite.Employe;
import Entite.Materiel;

public class MaterielUtil {

	private static MaterielUtil instance = null;

	public static MaterielUtil getInstance() {
		if (instance == null) {
			instance = new MaterielUtil();
		}
		return instance;
	}

	public void modifMateriel(Materiel m, String type) {
		m.setType(type);
	}

	public void deleteMateriel(Materiel m) {
		m = null;
	}

}
