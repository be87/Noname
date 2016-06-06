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
 * Servlet implementation class DispoEmployeServlet
 */
@WebServlet("/DispoEmployeServlet")
public class DispoEmployeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispoEmployeServlet() {
        super();
       
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DispoEmployeBean bean = new DispoEmployeBean("", "", "","");
		String nom = "";
		String prenom = "";
		Date date = new Date();
		String dispo;

		if (request.getParameter("NOM") != null ) {
			try {
				nom = request.getParameter("NOM");
				prenom = request.getParameter("PRENOM");
				date = sdf.parse(request.getParameter("DATE"));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}

			dispo = " OK  " ;

			bean = new DispoEmployeBean(nom, prenom, date.toString(), dispo);
		}

		request.setAttribute("bean", bean);
		request.getRequestDispatcher("/vue_dispoemploye.jsp").forward(request, response);

	}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
