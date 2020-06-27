package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Beans.Flight;
import Work.FlightsForm;
import Work.SettingsForm;

/**
 * Servlet implementation class FlightS
 */
@WebServlet("/FlightS")
public class FlightS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static SettingsForm settings = new SettingsForm();
	public static int Value = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlightS() {
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
		request.setAttribute("flights", FlightsForm.FLIGHT_LIST);

		this.getServletContext().getRequestDispatcher("/WEB-INF/flight.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (FlightS.Value == 1) {
			myFunctionFlight(request);
		}
		FlightS.Value = 0;
		doGet(request, response);
	}

	private void myFunctionFlight(HttpServletRequest request) {
		FlightsForm form = new FlightsForm();
		String from = settings.getValeurChamp(request,"From");
		String to = settings.getValeurChamp(request,"To");
		String date = settings.getFormattedDate(settings.getValeurChamp(request,"date"));
		String adults = settings.getValeurChamp(request,"adults");
		String children = settings.getValeurChamp(request,"child");
		String classe = settings.getValeurChamp(request,"Classe");
		String return_date = "";
		if(settings.getValeurChamp(request,"Returndate")!= null && !settings.getValeurChamp(request,"Returndate").isEmpty()) {
			return_date = settings.getValeurChamp(request,"Returndate");
		}
		try {


			Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(from);
			while (m.find()) {
				from = m.group(1);
			}
			m = Pattern.compile("\\(([^)]+)\\)").matcher(to);
			while (m.find()) {
				to = m.group(1);
			}
			FlightsForm.FLIGHT_LIST.clear();
			ArrayList<Flight> flights = form.getFlights(from, to, date, return_date, adults, children, classe);

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
