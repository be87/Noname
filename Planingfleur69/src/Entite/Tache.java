package Entite;

import java.util.Date;
import java.util.List;

public class Tache {
	
		int idTache;
		String typeDeTache;
		Date dateDebutReal;
		int dureejour;
		List<Materiel> lstMatos;
		List<Employe> lstEmploye;
		public int getIdTache() {
			return idTache;
		}
		public void setIdTache(int idTache) {
			this.idTache = idTache;
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
		public int getDureejour() {
			return dureejour;
		}
		public void setDureejour(int dureejour) {
			this.dureejour = dureejour;
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
		public Tache(int idTache, String typeDeTache, Date dateDebutReal, int dureejour, List<Materiel> lstMatos,
				List<Employe> lstEmploye) {
			super();
			this.idTache = idTache;
			this.typeDeTache = typeDeTache;
			this.dateDebutReal = dateDebutReal;
			this.dureejour = dureejour;
			this.lstMatos = lstMatos;
			this.lstEmploye = lstEmploye;
		}
		@Override
		public String toString() {
			return "Tache [idTache=" + idTache + ", typeDeTache=" + typeDeTache + ", dateDebutReal=" + dateDebutReal
					+ ", dureejour=" + dureejour + ", lstMatos=" + lstMatos + ", lstEmploye=" + lstEmploye + "]";
		}
		
		

}