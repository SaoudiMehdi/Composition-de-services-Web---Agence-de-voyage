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
import Work.FlightsForm;
import Work.HotelsForm;
import Work.SettingsForm;

/**
 * Servlet implementation class HotelS
 */
@WebServlet("/HotelS")
public class HotelS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static SettingsForm settings = new SettingsForm();
	public static int Value = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HotelS() {
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
		request.setAttribute("hotel", HotelsForm.HOTELS_LIST);
		this.getServletContext().getRequestDispatcher("/WEB-INF/hotel.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (HotelS.Value == 1) {
			myFunctionHotels(request);
		}
		HotelS.Value = 0;
		doGet(request, response);
	}

	/*
	 * IT SHOULD BE IN doPost Function
	 */
	private void myFunctionHotels(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String City = settings.getValeurChamp(request, "City");
		String CheckIn = settings.getFormattedDate(settings.getValeurChamp(request, "CheckIn"));
		String Nights = settings.getValeurChamp(request, "Nights");
		String adults = settings.getValeurChamp(request, "adults");
		String child = settings.getValeurChamp(request, "child");
		String Room = settings.getValeurChamp(request, "Room");
		String hotel_option = "recommended";
		HotelsForm form = new HotelsForm();

		if(settings.getValeurChamp(request,"SelectHotelOption")!= null && !settings.getValeurChamp(request,"SelectHotelOption").isEmpty()) {
			hotel_option = settings.getValeurChamp(request,"SelectHotelOption").toLowerCase();
		}
		ArrayList<Hotel> hotels;
		try {
			HotelsForm.HOTELS_LIST.clear();
			City = City.split(" ",2)[0];
			City = City.replaceAll("[ ]", "%20");
			City = City.split(",", 2)[0];
			hotels = form.getHotels(City.toLowerCase(), CheckIn, Nights, adults, child, Room, hotel_option);

		} catch (UnirestException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		while (HotelsForm.HOTELS_LIST.size() < 3) {
			if (i > 300)
				break;
			try {
				TimeUnit.MILLISECONDS.sleep(10);
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
