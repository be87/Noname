package Entite;

public class Employe {

	int id;
	String nom;
	String prenom;
	boolean etat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Employe(int id, String nom, String prenom, boolean etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", etat=" + etat + "]";
	}

}
