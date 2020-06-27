package Work;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mashape.unirest.http.exceptions.UnirestException;

import Beans.Car;
import Beans.Flight;
import Beans.Flight_Hotels_Cars;
import Beans.Hotel;
import DAO.CarsDAO;

public class Flight_Hotel_Car_Form {

	public static ArrayList<Flight_Hotels_Cars> FLIGHTS_HOTELS_CARS_LIST = new ArrayList<Flight_Hotels_Cars>();
	public static int NIGTHS = 1;

	public boolean getFlight_Hotels_Cars(String origine, String destination,String checkIn, String checkOutCar,String adults, String children, String flight_classe,String nights, String rooms, String package_option) {

		HotelsForm form = new HotelsForm();

		ArrayList<Hotel> hotels;
		String city = null;


		try {
			if (HotelsForm.HOTELS_LIST.size() == 0) {
				city = destination.split(" ",2)[0];
				city = city.replaceAll("[ ]", "%20");
				city = city.split(",", 2)[0];
				NIGTHS = Integer.parseInt(nights);
				hotels = form.getHotels(city, checkIn, nights, adults, children, rooms, package_option);
			}

		} catch (UnirestException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		while (HotelsForm.HOTELS_LIST.size() < 3) {
			if (i > 200)
				break;
			try {
				TimeUnit.MILLISECONDS.sleep(10);
				i++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		FlightsForm formFlight = new FlightsForm();
		try {
			Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(origine);
			while (m.find()) {
				origine = m.group(1);
			}
			m = Pattern.compile("\\(([^)]+)\\)").matcher(destination);
			while (m.find()) {
				destination = m.group(1);
			}
			ArrayList<Flight> flights = formFlight.getFlights(origine, destination, checkIn, "", adults, children, flight_classe);
			// ArrayList<Flight> flights = form.getFlights(origine, destination,
			// "2020-07-30", "2020-09-20", "1", "7", "0");
			if(FlightsForm.FLIGHT_LIST.size()==0)return false;

			//CARS
			CarsDAO carsForm = new CarsDAO();
			carsForm.getCars(city, checkIn, checkOutCar);
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		FillInList(HotelsForm.HOTELS_LIST,FlightsForm.FLIGHT_LIST, CarsDAO.CARS);
		return true;
	}

	public void FillInList(ArrayList<Hotel> hotels, ArrayList<Flight> flights, ArrayList<Car> Cars) {
		// TODO Auto-generated method stub
		FLIGHTS_HOTELS_CARS_LIST.clear();
		int max_size = hotels.size();
		if(flights.size()<max_size) max_size = flights.size();
		for(int i=0; i<max_size ; i++) {
			String s = FlightsForm.FLIGHT_LIST.get(i).getPrice();
			String p = HotelsForm.HOTELS_LIST.get(i).getPrice_per_night();
			String c = CarsDAO.CARS.get(i).getPrice_per_duration();
			String p1 = p.split("-",2)[0];
			String p2 = p.split("-",2)[1];
			double v = Double.parseDouble(s.substring(1).replaceAll("[,]", "."));
			double v1 = Double.parseDouble(p1.substring(1).substring(0,p1.substring(1).indexOf(" ")).replaceAll("[,]", "."));
			double v2 = Double.parseDouble(p2.substring(1).substring(1).replaceAll("[,]", "."));
			System.out.println((v1+v2)*NIGTHS/2 + " "+v+" "+Double.parseDouble(c));
			double price_fixed_by_our_agency = (v1+v2)*NIGTHS/2 + v + Double.parseDouble(c);
			FLIGHTS_HOTELS_CARS_LIST.add(i,new Flight_Hotels_Cars(FlightsForm.FLIGHT_LIST.get(i),
					HotelsForm.HOTELS_LIST.get(i),CarsDAO.CARS.get(i),price_fixed_by_our_agency));

		}

	}
}
