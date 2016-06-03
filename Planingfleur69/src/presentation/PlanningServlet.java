package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entite.Employe;
import Entite.Factory;
import Entite.Tache;
import metier.EmployeUtil;
import metier.PlanningUtil;

/**
 * Servlet implementation class MajoriteServlet
 */
@WebServlet("/PlanningServlet")
public class PlanningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlanningServlet() {
		super();
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlanningBean bean = new PlanningBean("", "", "");
		Date date1 = new Date();
		Date date2 = new Date();
		String taches;

		/**
		 * Recuperation des deux dates limites du planning
		 */
		
		if (request.getParameter("DATE1") != null) {
			try {
				date1 = sdf.parse(request.getParameter("DATE1"));
				date2 = sdf.parse(request.getParameter("DATE2"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			/**
			 * Creation employé et tache, puis liste de taches dont la date est à tester
			 */

			EmployeUtil eu = EmployeUtil.getInstance();
			PlanningUtil pu = PlanningUtil.getInstance();
			Employe e = Factory.getEmploye();
			eu.modifEmploye(e, "Wallace", "Rasheed");

			Tache t;
			try {
				t = pu.addTache(e, "debroussaillage", "dtc", sdf.parse("2015-06-03"), sdf.parse("2015-06-04"));
			} catch (ParseException e1) {
				t = null;
			} catch (SQLException e1) {
				t = null;
			}

			pu.associerEmploye(t, e);

			ArrayList<Tache> lstTache = new ArrayList<Tache>();
			lstTache.add(t);
			String toPrint = "";
			
			/**
			 * On parcours la liste des taches et on ne prends que celles dont la date de début est 
			 * apres la date1 et dont la date de fin est avant la date2
			 */

			for (Tache T : lstTache) {
				if (date1.before(T.getDateDebutReal()) == true && date2.after(T.getDateFin()) == true) {
					toPrint += "<b>Tache : </b>" + T.getTypeDeTache() + ",<b> Début : </b>" + T.getDateDebutReal()
							+ "<br/>";
				}
			}
			
			/**
			 * taches représente le resultat à afficher 
			 */

			taches = "entre le " + date1 + " et le " + date2 + "<br/><br/>" + toPrint;

			bean = new PlanningBean(date1.toString(), date2.toString(), taches);
		}
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/vue_planning.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}