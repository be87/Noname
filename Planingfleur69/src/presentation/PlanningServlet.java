package presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MajoriteServlet
 */
@WebServlet("/MajoriteServlet")
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

		if (request.getParameter("DATE1") != null ) {
			try {
				date1 = sdf.parse(request.getParameter("DATE1"));
				date2 = sdf.parse(request.getParameter("DATE2"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			taches = "entre  " + date1 + " et  " + date2;

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