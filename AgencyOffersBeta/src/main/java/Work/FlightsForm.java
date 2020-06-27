package Work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Beans.Flight;

public class FlightsForm {

	public static String API_KEY = "21a75fc268mshde5069c6650e78fp17df39jsn165d334c01db";
	public static ArrayList<Flight> FLIGHT_LIST = new ArrayList<Flight>();

	/*
	 * PAY ATTENTION YOU DIDN'T USE ROOMS ATTRIBUTE YET
	 */
	public ArrayList<Flight> getFlights(String origine, String destination, String departure_date, String return_date,
										String adults_number, String children_age, String flight_class)
			throws UnirestException, InterruptedException {
		System.out.println("origine: "+origine+" destination: "+destination);
		String search_id = getSearchId(origine, destination, departure_date, return_date, adults_number, children_age,
				flight_class);
		ApiKeySwitcher api_switch = new ApiKeySwitcher();
		// api_switch.SwitchAPI();

		System.out.println(search_id);

		// creating request information
		String url;
		String api;

		url = "https://tripadvisor1.p.rapidapi.com/flights/poll?currency=USD&n=30&ns=NON_STOP%252CONE_STOP&so=PRICE&o=0&sid="
				+ search_id;
		api = "tripadvisor1.p.rapidapi.com";
		if (!API_KEY.isEmpty()) {
			HttpResponse<JsonNode> response;
			try {
				response = Unirest.get(url).header("x-rapidapi-host", api).header("x-rapidapi-key", FlightsForm.API_KEY)
						.asJson();
				if (response.getBody().getArray().length() > 5) {
					api_switch.SwitchAPI();
					response = Unirest.get(url).header("x-rapidapi-host", api)
							.header("x-rapidapi-key", FlightsForm.API_KEY).asJson();

				} else {
					boolean two_ways = true;
					if (return_date == null || return_date.isEmpty()) {
						two_ways = false;
					}
					FillingFlightInfo(response, destination, two_ways, origine, departure_date, return_date,
							adults_number, children_age, flight_class);

				}
			} catch (UnirestException e) {
				// TODO Auto-generated catch block

			}
		}

		return FLIGHT_LIST;
	}

	public String getSearchId(String origine, String destination, String departure_date, String return_date,
							  String adults_number, String children_age, String flight_class) {
		// TODO Auto-generated method stub
		ApiKeySwitcher api_switch = new ApiKeySwitcher();
		// api_switch.SwitchAPI();
		// API_KEY = "4ae6120e67mshe23371b4ad2e806p1f2a9bjsnedfd935a0104";

		HttpResponse<JsonNode> response;
		String search_id = null;
		// String url =
		// "https://tripadvisor1.p.rapidapi.com/flights/create-session?dd2=2020-09-05&currency=USD&o2=RAK&d2=CDG&ta=1&tc=7&c=0&d1=RAK&o1=CDG&dd1=2020-08-16";
		String url;
		if (return_date != null) {
			url = "https://tripadvisor1.p.rapidapi.com/flights/create-session?dd2=" + return_date + "&currency=USD&o2="
					+ destination + "&d2=" + origine + "&ta=" + adults_number + "&tc=" + children_age + "&c=0&d1="
					+ destination + "&o1=" + origine + "&dd1=" + departure_date;
		} else {
			url = "https://tripadvisor1.p.rapidapi.com/flights/create-session?currency=USD&ta=" + adults_number + "&tc="
					+ children_age + "&c="+flight_class+"&d1=" + destination + "&o1=" + origine + "&dd1=" + departure_date;
		}
		System.out.println(url);
		// url =
		// "https://tripadvisor1.p.rapidapi.com/flights/create-session?currency=USD&ta=1&c=0&d1=CDG&o1=RAK&dd1=2020-07-30";
		String api = "tripadvisor1.p.rapidapi.com";

		try {
			response = Unirest.get(url).header("x-rapidapi-host", api).header("x-rapidapi-key", API_KEY).asJson();
			if (response.getBody().getArray().getJSONObject(0).has("message")) {
				api_switch.SwitchAPI();
				response = Unirest.get(url).header("x-rapidapi-host", api).header("x-rapidapi-key", API_KEY).asJson();
			}
			// JSONObject data = response.getBody().getArray().getJSONObject(0);

			search_id = response.getBody().getArray().getJSONObject(0).getJSONObject("search_params").getString("sid");

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return search_id;
	}

	private void FillingFlightInfo(HttpResponse<JsonNode> response, String destination, boolean two_ways,
								   String origine, String departure_date, String return_date, String adults_number, String children_age,
								   String flight_class) {
		// TODO Auto-generated method stub

		JSONObject data = response.getBody().getArray().getJSONObject(0);

		if (data.has("itineraries")) {
			JSONArray itineraries = data.getJSONArray("itineraries");
			int itineraries_length = itineraries.length();
			for (int i = 0; i < itineraries_length; i++) {
				JSONArray itinerarie = itineraries.getJSONObject(i).getJSONArray("f");
				JSONArray price_provider = itineraries.getJSONObject(i).getJSONArray("l");
				HashMap<String, String> flight_data = new HashMap<String, String>();
				boolean one_stop = false;

				flight_data = getFlightData(data, itinerarie, price_provider, two_ways);
				int flight_data_size = flight_data.size();
				String flight_departure_hour = flight_data.get("exact_departure_date_0");
				flight_departure_hour = flight_departure_hour.split("T", 2)[1];
				if(flight_departure_hour.indexOf('-')>=0) flight_departure_hour = flight_departure_hour.substring(0, flight_departure_hour.indexOf('-'));
				if(flight_departure_hour.indexOf('+')>=0) flight_departure_hour = flight_departure_hour.substring(0, flight_departure_hour.indexOf('+'));
				String flight_arrived_hour = flight_data.get("exact_arriving_date_0");
				flight_arrived_hour = flight_arrived_hour.split("T", 2)[1];
				if(flight_arrived_hour.indexOf('+')>=0) flight_arrived_hour = flight_arrived_hour.substring(0, flight_arrived_hour.indexOf('+'));
				if(flight_arrived_hour.indexOf('-')>=0) flight_arrived_hour = flight_arrived_hour.substring(0, flight_arrived_hour.indexOf('-'));
				String logo_company = flight_data.get("logo_company_0");
				String company_name = flight_data.get("company_name_0");
				String stops_number = flight_data.get("stops_number");
				String flight_duration = getFlightDuration(flight_departure_hour, flight_arrived_hour);
				System.out.println("flight d : "+flight_duration);
				// count children
				int children_number = 0;
				if (children_age != null && !children_age.isEmpty()) {
					children_number = 1;
					int charCount = children_age.replaceAll("[^,]", "").length();
					children_number += charCount;
				}
				flight_departure_hour = flight_departure_hour.split(":", 3)[0]+":"+flight_departure_hour.split(":", 3)[1];
				flight_arrived_hour = flight_arrived_hour.split(":", 3)[0]+":"+flight_arrived_hour.split(":", 3)[1];
				String price = flight_data.get("price");
				if (!two_ways) {
					Flight one_flight = new Flight(origine, destination, departure_date, adults_number,
							String.valueOf(children_number), flight_class, flight_departure_hour, flight_arrived_hour,
							company_name, logo_company, price, stops_number, flight_duration);
					FLIGHT_LIST.add(one_flight);
				} else {
					String return_flight_departure_hour = flight_data.get("exact_departure_date_1");
					return_flight_departure_hour = return_flight_departure_hour.split("T", 2)[1];
					return_flight_departure_hour = return_flight_departure_hour.substring(0,
							return_flight_departure_hour.indexOf('+'));
					String return_flight_arrived_hour = flight_data.get("exact_arriving_date_1");
					return_flight_arrived_hour = return_flight_arrived_hour.split("T", 2)[1];
					return_flight_arrived_hour = return_flight_arrived_hour.substring(0,
							return_flight_arrived_hour.indexOf('+'));
					String second_logo_company = flight_data.get("logo_company_1");
					String second_company_name = flight_data.get("company_name_1");
					String second_stops_number = flight_data.get("second_stops_number");
					String second_flight_duration = getFlightDuration(return_flight_departure_hour,
							return_flight_arrived_hour);
					return_flight_departure_hour = return_flight_departure_hour.split(":", 3)[0]+":"+return_flight_departure_hour.split(":", 3)[1];
					return_flight_arrived_hour = return_flight_arrived_hour.split(":", 3)[0]+":"+return_flight_arrived_hour.split(":", 3)[1];
					Flight one_flight = new Flight(origine, destination, departure_date, return_date, adults_number,
							String.valueOf(children_number), flight_class, flight_departure_hour, flight_arrived_hour,
							company_name, logo_company,flight_duration,return_flight_departure_hour, return_flight_arrived_hour,
							second_company_name, second_logo_company, price, stops_number, second_stops_number,
							second_flight_duration);
					FLIGHT_LIST.add(one_flight);
				}

			}

		}

	}

	private HashMap<String, String> getFlightData(JSONObject data, JSONArray itinerarie, JSONArray price_provider,
												  boolean two_ways) {
		// TODO Auto-generated method stub
		HashMap<String, String> flight_data = new HashMap<String, String>();
		int stops_number = 0;
		int second_stops_number = 0;
		int itinerarie_number = 1;
		if (two_ways)
			itinerarie_number = 2;
		for (int i = 0; i < itinerarie_number; i++) {
			JSONArray flights = itinerarie.getJSONObject(i).getJSONArray("l");

			if (flights.length() > 1) {
				// flight_data.put("one_stop" + "_" + i, "true");
				if (i == 0)
					stops_number++;
				else
					second_stops_number++;
				// first flight
				flight_data.put("exact_departure_date" + "_" + i, flights.getJSONObject(0).getString("dd"));
				flight_data.put("code_company" + "_" + i, flights.getJSONObject(0).getString("m"));
				String company_name = getCompanyName(data, flights.getJSONObject(0).getString("m"));
				flight_data.put("company_name" + "_" + i, company_name);
				// code middle airport
				flight_data.put("middle_airport" + "_" + i, flights.getJSONObject(0).getString("da"));
				// seconde flight
				flight_data.put("exact_arriving_date" + "_" + i, flights.getJSONObject(1).getString("ad"));
				flight_data.put("code_second_company" + "_" + i, flights.getJSONObject(1).getString("m"));
				String second_company_name = getCompanyName(data, flights.getJSONObject(1).getString("m"));
				flight_data.put("company_second_name" + "_" + i, second_company_name);
				// extracting logos of airlines companies
				String code_first_company = flight_data.get("code_company" + "_" + i);
				String code_second_company = flight_data.get("code_second_company" + "_" + i);
				flight_data.put("logo_company" + "_" + i, getLogoURL(data, code_first_company));
				flight_data.put("logo_second_company" + "_" + i, getLogoURL(data, code_second_company));

			} else {
				// flight_data.put("one_stop" + "_" + i, "false");

				flight_data.put("exact_departure_date" + "_" + i, flights.getJSONObject(0).getString("dd"));
				flight_data.put("code_company" + "_" + i, flights.getJSONObject(0).getString("m"));
				flight_data.put("exact_arriving_date" + "_" + i, flights.getJSONObject(0).getString("ad"));
				// extracting logos of airlines companies
				String code_company = flight_data.get("code_company" + "_" + i);
				flight_data.put("logo_company" + "_" + i, getLogoURL(data, code_company));
				String company_name = getCompanyName(data, flights.getJSONObject(0).getString("m"));
				flight_data.put("company_name" + "_" + i, company_name);
			}
		}

		// extracting flight price
		String price = price_provider.getJSONObject(0).getJSONObject("pr").getString("dp");
		flight_data.put("price", price);
		flight_data.put("stops_number", String.valueOf(stops_number));
		flight_data.put("second_stops_number", String.valueOf(second_stops_number));

		return flight_data;
	}

	private String getCompanyName(JSONObject data, String code_company) {

		JSONArray companies_codes = data.getJSONArray("carriers");
		for (int j = 0; j < companies_codes.length(); j++) {
			if (companies_codes.getJSONObject(j).getString("c").equalsIgnoreCase(code_company)) {
				return companies_codes.getJSONObject(j).getString("n");
			}
		}
		return null;
	}

	private String getLogoURL(JSONObject data, String code_company) {
		// TODO Auto-generated method stub
		JSONArray plane_image_link = data.getJSONArray("carriers");
		for (int j = 0; j < plane_image_link.length(); j++) {
			if (plane_image_link.getJSONObject(j).getString("c").equalsIgnoreCase(code_company)) {
				return plane_image_link.getJSONObject(j).getString("l");
			}
		}
		return null;
	}

	private String getFlightDuration(String start, String stop) {
		int seconds_start = Integer.parseInt(start.split(":", 3)[0]) * 3600
				+ Integer.parseInt(start.split(":", 3)[1]) * 60 + Integer.parseInt(start.split(":", 3)[2]);
		int seconds_stops = Integer.parseInt(stop.split(":", 3)[0]) * 3600
				+ Integer.parseInt(stop.split(":", 3)[1]) * 60 + Integer.parseInt(stop.split(":", 3)[2]);
		int res1 = seconds_stops - seconds_start;
		if (Integer.parseInt(stop.split(":", 3)[0]) < Integer.parseInt(start.split(":", 3)[0])) {
			int middl = 24 * 3600;
			int diff1 = middl - seconds_start;
			res1 = diff1 + seconds_stops;
		}
		int hours = res1 / 3600;
		int minutes = (res1 % 3600) / 60;
		int seconds = ((res1 % 3600) % 60);
		if (seconds == 60) {
			seconds = 0;
			minutes += 1;
		}
		if (minutes == 60) {
			minutes = 0;
			hours += 1;
		}
		return hours + "h" + minutes;
	}
}
