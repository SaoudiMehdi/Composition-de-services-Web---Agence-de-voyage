package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarsDAO;
import Work.FlightsForm;
import Work.SettingsForm;

/**
 * Servlet implementation class CarS
 */
@WebServlet("/CarS")
public class CarS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static SettingsForm settings = new SettingsForm();
	public static int Value = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarS() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("cars", CarsDAO.CARS);
		this.getServletContext().getRequestDispatcher("/WEB-INF/car.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = "/WEB-INF/car.jsp";

		if (CarS.Value == 1) {
			myFunctionCar(request);
		}
		CarS.Value = 0;
		doGet(request, response);
	}

	private void myFunctionCar(HttpServletRequest request) {
		// TODO Auto-generated method stub
		CarsDAO.CARS.clear();
		CarsDAO carsForm = new CarsDAO();
		String city = settings.getValeurChamp(request,"City");
		String checkIn = settings.getFormattedDate(settings.getValeurChamp(request,"CheckIn"));
		String checkOut = settings.getFormattedDate(settings.getValeurChamp(request,"CheckOut"));

		carsForm.getCars(city, checkIn, checkOut);


	}

}
