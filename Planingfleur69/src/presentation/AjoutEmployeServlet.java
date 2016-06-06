package presentation;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.EmployeUtil;

/**
 * Servlet implementation class DispoEmployeServlet
 */
@WebServlet("/AjoutEmployeServlet")
public class AjoutEmployeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutEmployeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AjoutEmployeBean bean = new AjoutEmployeBean("", "", "");
		String nom = "";
		String prenom = "";
		String etat = "";

		if (request.getParameter("NOM") != null) {
			nom = request.getParameter("NOM");
			prenom = request.getParameter("PRENOM");
			
			EmployeUtil eu = EmployeUtil.getInstance();
			try {
				eu.createEmploye(nom, prenom);
				etat = " a été ajouté à la base de données avec succes";
			} catch (SQLException e) {
				etat = " n'a pas été ajouté à la base de données";
			}


			bean = new AjoutEmployeBean(nom, prenom, etat);
		}

		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/vue_ajoutemploye.jsp").forward(request, response);

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
