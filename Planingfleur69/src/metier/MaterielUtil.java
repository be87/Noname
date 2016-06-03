package metier;

import Entite.Materiel;

public class MaterielUtil {

	private static MaterielUtil instance = null;

	public static MaterielUtil getInstance() {
		if (instance == null) {
			instance = new MaterielUtil();
		}
		return instance;
	}
	/*
	 * modofoer le type d'un materiel
	 */
	public void modifMateriel(Materiel m, String type) {
		m.setType(type);
	}
	/*
	 * supprimer un materiel
	 */
	public void deleteMateriel(Materiel m) {
		m = null;
	}

}
