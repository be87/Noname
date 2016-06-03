package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	
public void Insert(Tache t) throws SQLException {		
		
		String requete = "INSERT INTO tache (typeDeTache,adresse, datedebut, datefin, listEmploye) VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		getConnection();

		
			ps = dbacces.getConnection().prepareStatement(requete);
			try {
				ps.setString(1, t.getTypeDeTache());
				ps.setString(2, t.getAdresse());//adresse
				ps.setString(3, formater.format(t.getDateDebutReal()));
				ps.setString(4, formater.format(t.getDateFin()));
				List<Employe> lst = new ArrayList<Employe>();
				lst=(t.getLstEmploye());				
				ps.setString(5, lst.get(0).getNom());
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
