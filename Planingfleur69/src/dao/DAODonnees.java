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
				ps.setString(2, e.getPrenom());
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
		String requete = "SELECT * FROM employe WHERE nom =? AND prenom =? ;";
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
				
				result.setPrenom(resultat.getString("prenom"));
				result.setNom(resultat.getString("nom"));
				result.setEtat(Boolean.parseBoolean(resultat.getString("etat").toLowerCase()));
				result.setId(resultat.getInt("idemploye"));
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
	
	
private Employe chercherEmployeId(String str) throws SQLException {		
		
		Employe result = Factory.getEmploye();
		ResultSet resultat = null;
		String requete = "SELECT * FROM employe WHERE idemploye =? ;";
		PreparedStatement ps = null;
		// Statement stmt = null;

		// connexion à la base de données
		getConnection();
		// envoi de la requete
		try {
			ps = dbacces.getConnection().prepareStatement(requete);
			ps.setInt(1,Integer.parseInt(str));
			// stmt = dbaccess.getConnection().createStatement();
			resultat = ps.executeQuery();
			// resultat = stmt.executeQuery(requete);
		} catch (SQLException e1) {
			System.out.println("Erreur lors de la création ou de l'exécution da la requete de selection");
		}

		// traitement des résultats
		try {
			if (resultat.next()) {
				
				result.setPrenom(resultat.getString("prenom"));
				result.setNom(resultat.getString("nom"));
				result.setEtat(Boolean.parseBoolean(resultat.getString("etat").toLowerCase()));
				result.setId(resultat.getInt("idemploye"));
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
				Integer integ = lst.get(0).getId();
				ps.setString(5, (integ.toString()));
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

public void updateLSTEmployee(Tache t) throws SQLException{
	
	List<Employe> lstEmp = t.getLstEmploye();
	String lista = "";
	Integer i=0;
	for (Employe employe : lstEmp) {
		Integer idtemp = employe.getId();
		System.out.println(idtemp);
		lista =lista + idtemp.toString();
		if(i <(lstEmp.size()-1)){
		lista =lista +";";
		i+=1;
		}
	}
	System.out.println(lista);
	
	String requete = "UPDATE tache SET listEmploye = ? WHERE idTache = ?; ";
	PreparedStatement ps = null;

	getConnection();
	
		ps = dbacces.getConnection().prepareStatement(requete);
		try {
			ps.setString(1, lista);
			Integer inttmp2 = t.getIdTache();
			ps.setString(2, inttmp2.toString());//adresse
			ps.executeUpdate();
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


public Tache chercherTache(String nomdeTache) throws SQLException {		
	
	Tache result = Factory.getTache();
	ResultSet resultat = null;
	String requete = "SELECT * FROM tache WHERE typeDeTache =? ;";
	PreparedStatement ps = null;
	// Statement stmt = null;

	// connexion à la base de données
	getConnection();
	// envoi de la requete
	try {
		ps = dbacces.getConnection().prepareStatement(requete);
		ps.setString(1,nomdeTache);
		// stmt = dbaccess.getConnection().createStatement();
		resultat = ps.executeQuery();
		// resultat = stmt.executeQuery(requete);
	} catch (SQLException e1) {
		System.out.println("Erreur lors de la création ou de l'exécution da la requete de selection");
	}

	// traitement des résultats
	try {
		if (resultat.next()) {
			
			result.setIdTache(resultat.getInt("idTache"));
			result.setTypeDeTache(resultat.getString("typeDeTache"));
			result.setAdresse(resultat.getString("adresse"));
			result.setDateDebutReal(resultat.getDate("datedebut"));
			result.setDateFin(resultat.getDate("datefin"));
			result.setLstMatos(null);
			
			String [] lista = resultat.getString("listEmploye").split(";");
			List<Employe> lst = new ArrayList<Employe>();
			for (String str : lista) {
				System.out.println(str);
				Employe emp = Factory.getEmploye();
				emp = chercherEmployeId(str);
				lst.add(emp);
			}
			result.setLstEmploye(lst);
			
			
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
	

	

}
