package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entite.Employe;
import Entite.Tache;

public class DAODonnees {
	private DAOAcces dbacces = null;
	private static DAODonnees instance = null;
	
	public static DAODonnees getInstance(){
		if(instance == null){
			instance = new DAODonnees();
		}
		return instance;
	}
	
	private DAODonnees() {
		super();
		dbacces = DAOAcces.getInstance();
	}
	
	public void getConnection(){
		try {
			dbacces.connect();
		} catch (SQLException e) {
			System.out.println("Connection a la base de donnees impossible");
		}
	}
	
	public void close(){
		dbacces.close();
	}
	
	
	public void Insert(Employe e) throws SQLException {		
	
		String requete = "INSERT INTO employe (nom,prenom, etat) VALUES (?,?,'True')";
		PreparedStatement ps = null;
		getConnection();

		
			ps = dbacces.getConnection().prepareStatement(requete);
			try {
				ps.setString(1, e.getNom());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ps.setString(2, e.getNom());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ps.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			try {
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		close();
	}
	
	

}
