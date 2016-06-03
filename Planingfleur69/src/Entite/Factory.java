package Entite;

public class Factory {

	public static Employe getEmploye() {
		Employe e = new Employe();
		return e;

	}

	public static Materiel getMateriel() {
		Materiel m = new Materiel();
		return m;

	}

	public static Tache getTache() {
		Tache t = new Tache();
		return t;

	}
}