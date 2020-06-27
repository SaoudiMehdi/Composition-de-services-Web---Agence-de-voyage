package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashape.unirest.http.exceptions.UnirestException;

import Beans.Hotel;
import DAO.CarsDAO;
import Work.Flight_Hotel_Car_Form;
import Work.FlightsForm;
import Work.HotelsForm;
import Work.SettingsForm;

/**
 * Servlet implementation class PackageS
 */
@WebServlet("/PackageS")
public class PackageS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static SettingsForm settings = new SettingsForm();
	public static int Value = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PackageS() {
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
		request.setAttribute("flights_hotels_cars", Flight_Hotel_Car_Form.FLIGHTS_HOTELS_CARS_LIST);
		request.setAttribute("nigths", Flight_Hotel_Car_Form.NIGTHS);
		request.setAttribute("cars", CarsDAO.CARS);

		this.getServletContext().getRequestDispatcher("/WEB-INF/packages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (PackageS.Value == 1) {
			myFunctionPackage(request);
		}
		PackageS.Value = 0;
		doGet(request, response);

	}

	private void myFunctionPackage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Flight_Hotel_Car_Form form = new Flight_Hotel_Car_Form();
		HotelsForm.HOTELS_LIST.clear();
		FlightsForm.FLIGHT_LIST.clear();
		CarsDAO.CARS.clear();

		String origine = settings.getValeurChamp(request, "Fromm");
		String destination = settings.getValeurChamp(request, "Too");
		String checkIn = settings.getFormattedDate(settings.getValeurChamp(request, "CheckIn"));
		String checkOutCar = settings.getFormattedDate(settings.getValeurChamp(request, "CheckOutCar"));
		String adults = settings.getValeurChamp(request, "Adults");
		String children = settings.getValeurChamp(request, "Children");
		String flight_classe = settings.getValeurChamp(request, "FlightClass");
		String nigths = settings.getValeurChamp(request, "Nights");
		String rooms = settings.getValeurChamp(request, "Room");
		String package_option = "recommended";

		if(settings.getValeurChamp(request,"SelectPackageOption")!= null
				&& !settings.getValeurChamp(request,"SelectPackageOption").isEmpty()) {
			package_option = settings.getValeurChamp(request,"SelectPackageOption").toLowerCase();
		}

		form.getFlight_Hotels_Cars(origine, destination, checkIn, checkOutCar, adults, children, flight_classe, nigths,
				rooms, package_option);

	}

}
