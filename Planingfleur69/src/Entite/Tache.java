package Entite;

import java.util.Date;
import java.util.List;

public class Tache {

	int idTache;
	String typeDeTache;
	Date dateDebutReal;
	Date dateFinReal;
	String adresse;
	List<Materiel> lstMatos;
	List<Employe> lstEmploye;

	public int getIdTache() {
		return idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTypeDeTache() {
		return typeDeTache;
	}

	public void setTypeDeTache(String typeDeTache) {
		this.typeDeTache = typeDeTache;
	}

	public Date getDateDebutReal() {
		return dateDebutReal;
	}

	public void setDateDebutReal(Date dateDebutReal) {
		this.dateDebutReal = dateDebutReal;
	}

	public Date getDateFin() {
		return dateFinReal;
	}

	public void setDateFin(Date dateFinReal) {
		this.dateFinReal = dateFinReal;
	}

	public List<Materiel> getLstMatos() {
		return lstMatos;
	}

	public void setLstMatos(List<Materiel> lstMatos) {
		this.lstMatos = lstMatos;
	}

	public List<Employe> getLstEmploye() {
		return lstEmploye;
	}

	public void setLstEmploye(List<Employe> lstEmploye) {
		this.lstEmploye = lstEmploye;
	}

	public Tache() {
	}

	public Tache(int idTache, String typeDeTache, String adresse, Date dateDebutReal, Date dateFinReal,
			List<Materiel> lstMatos, List<Employe> lstEmploye) {
		super();
		this.idTache = idTache;
		this.typeDeTache = typeDeTache;
		this.adresse = adresse;
		this.dateDebutReal = dateDebutReal;
		this.dateFinReal = dateFinReal;
		this.lstMatos = lstMatos;
		this.lstEmploye = lstEmploye;
	}

	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", typeDeTache=" + typeDeTache + ", dateDebutReal=" + dateDebutReal
				+ ", dateFinReal=" + dateFinReal + ", adresse=" + adresse + ", lstMatos=" + lstMatos + ", lstEmploye="
				+ lstEmploye + "]";
	}

}
