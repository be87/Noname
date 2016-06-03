package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Entite.Employe;
import Entite.Factory;
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
	
	/*
	 * permet d'inserer un employe a la BD
	 */
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
	/*
	 * permet de chercher un employe en fonction de son nom et prenom
	 */
	public Employe chercherEmploye(String nom, String prenom) throws SQLException {		
		
		Employe result = Factory.getEmploye();
		ResultSet resultat = null;
		String requete = "SELECT * FROM employe WHERE nom = ? AND prenom = ?;";
		PreparedStatement ps = null;
		// Statement stmt = null;

		// connexion à la base de données
		getConnection();
		// envoi de la requete
		try {
			ps = dbacces.getConnection().prepareStatement(requete);
			ps.setString(1,nom);
			ps.setString(2, prenom);
			// stmt = dbaccess.getConnection().createStatement();
			resultat = ps.executeQuery();
			// resultat = stmt.executeQuery(requete);
		} catch (SQLException e1) {
			System.out.println("Erreur lors de la création ou de l'exécution da la requete de selection");
		}

		// traitement des résultats
		try {
			if (resultat.next()) {
				result.setId(resultat.getInt("id"));
				result.setPrenom(resultat.getString("prenom"));
				result.setNom(resultat.getString("nom"));
				result.setEtat(Boolean.parseBoolean(resultat.getString("etat")));
			}
		} catch (SQLException e) {
			System.out.println("Erreur lors de la récupération des données du select");
		}

		if (result == null) {
			System.out.println("Aucune donnée récupérée depuis la base de données");
		}

		// fermeture du ResultSet ainsi que de la connexion
		try {
			ps.close();
		} catch (SQLException e1) {
			System.out.println("Erreur lors de la fermeture du statement de selection");
		}
		try {
			resultat.close();
		} catch (SQLException e) {
			System.out.println("Erreur lors de la fermeture du ResultSet");
		}
		close();

		return result;
		
	}
	/*
	 * inserer un tache a initialisation et employe associe a elle
	 */
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
