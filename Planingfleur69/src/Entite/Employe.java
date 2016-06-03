package Entite;

public class Employe {

	int idEmploye;
	String nom;
	String prenom;
	boolean etat;

	public int getId() {
		return idEmploye;
	}

	public void setId(int id) {
		this.idEmploye = id;
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
		this.idEmploye = id;
		this.nom = nom;
		this.prenom = prenom;
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Employe [id=" + idEmploye + ", nom=" + nom + ", prenom=" + prenom + ", etat=" + etat + "]";
	}

}
