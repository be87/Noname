package Entite;

public class Materiel {

	int idMateriel;
	String type;
	boolean etat;

	public int getIdMateriel() {
		return idMateriel;
	}

	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Materiel(int idMateriel, String type, boolean etat) {
		super();
		this.idMateriel = idMateriel;
		this.type = type;
		this.etat = etat;
	}

	public Materiel() {
		this.etat = true;
	}

	@Override
	public String toString() {
		return "Materiel [idMateriel=" + idMateriel + ", type=" + type + ", etat=" + etat + "]";
	}

}
