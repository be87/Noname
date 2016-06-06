package presentation;

public class DispoEmployeBean {

	String nom;
	String prenom;
	String date;
	String dispo;

	public DispoEmployeBean(String nom, String prenom, String date, String dispo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.dispo = dispo;
	}

	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
