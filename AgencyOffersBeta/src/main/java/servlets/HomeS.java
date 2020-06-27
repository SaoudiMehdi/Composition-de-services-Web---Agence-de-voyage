package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Car;

import DAO.CarsDAO;
import Work.SettingsForm;
import org.hibernate.Session;
import utility.HibernateUtil;


/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class HomeS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static SettingsForm settings = new SettingsForm();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		HotelS.Value = 1;
		FlightS.Value = 1;
		PackageS.Value = 1;
		CarS.Value = 1;

		CarsDAO mydao = new CarsDAO();
		mydao.getCars("Paris","2020-08-08","2020-08-08");

		System.out.println("hello");
		if(CarsDAO.CARS.size()>0){
			System.out.println(CarsDAO.CARS.get(0).getBrand());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/Home.jsp";
		this.getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	
	

}
