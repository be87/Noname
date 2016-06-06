package presentation;

public class AjoutEmployeBean {

	String nom;
	String prenom;
	String etat;

	public AjoutEmployeBean() {
	}

	public AjoutEmployeBean(String nom, String prenom, String etat) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.etat = etat;
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

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "AjoutEmployeBean [nom=" + nom + ", prenom=" + prenom + ", etat=" + etat + "]";
	}

}
