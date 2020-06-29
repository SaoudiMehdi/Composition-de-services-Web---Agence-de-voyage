package Beans;

public class Flight {
	
	private String origine;
	private String destination;
	private String departure_date;
	private String return_date;
	private String adults_number;
	private String children_age_number;
	private String flight_class;
	/*
	 * Declaration for the data we retrieve from the api
	 */
	private String flight_departure_hour;
	private String flight_arrived_hour;
	private String company_name;
	private String company_logo;
	private String price;
	private String stops_number;
	private String flight_duration;
	//case when the client checks A/R option
	private String return_flight_departure_hour;
	private String return_flight_arrived_hour;
	private String second_company_name;
	private String second_company_logo;
	private String second_stops_number;
	private String second_flight_duration;
	
	

	/*
	 * Constructor with return date, for request
	 */
	public Flight(String origine, String destination, String departure_date, String return_date, String adults_number,
			String children_age_number, String flight_class) {
		super();
		this.origine = origine;
		this.destination = destination;
		this.departure_date = departure_date;
		this.return_date = return_date;
		this.adults_number = adults_number;
		this.children_age_number = children_age_number;
		this.flight_class = flight_class;
	}

	/*
	 * Constructor without return date, for retrieving data
	 */
	public Flight(String origine, String destination, String departure_date, String adults_number,
			String children_age_number, String flight_class, String flight_departure_hour, String flight_arrived_hour,
			String company_name, String company_logo,String price, String stops_number, String flight_duration) {
		super();
		this.origine = origine;
		this.destination = destination;
		this.departure_date = departure_date;
		this.adults_number = adults_number;
		this.children_age_number = children_age_number;
		this.flight_class = flight_class;
		this.flight_departure_hour = flight_departure_hour;
		this.flight_arrived_hour = flight_arrived_hour;
		this.company_name = company_name;
		this.company_logo = company_logo;
		this.price = price;
		this.stops_number = stops_number;
		this.flight_duration = flight_duration;
	}
	/*
	 * Constructor with return date, for retrieving data
	 */
	
	public Flight(String origine, String destination, String departure_date, String return_date, String adults_number,
			String children_age_number, String flight_class, String flight_departure_hour, String flight_arrived_hour,
			String company_name, String company_logo, String flight_duration, String return_flight_departure_hour,
			String return_flight_arrived_hour, String second_company_name, String second_company_logo,String price, String stops_number, String second_stops_number, String second_flight_duration) {
		super();
		this.origine = origine;
		this.destination = destination;
		this.departure_date = departure_date;
		this.return_date = return_date;
		this.adults_number = adults_number;
		this.children_age_number = children_age_number;
		this.flight_class = flight_class;
		this.flight_departure_hour = flight_departure_hour;
		this.flight_arrived_hour = flight_arrived_hour;
		this.company_name = company_name;
		this.company_logo = company_logo;
		this.flight_duration = flight_duration;
		this.return_flight_departure_hour = return_flight_departure_hour;
		this.return_flight_arrived_hour = return_flight_arrived_hour;
		this.second_company_name = second_company_name;
		this.second_company_logo = second_company_logo;
		this.price = price;
		this.stops_number = stops_number;
		this.setSecond_stops_number(second_stops_number);
		this.second_flight_duration = second_flight_duration;

	}
	
	

	/*
	 * Getters and Setters
	 */
	
	public String getOrigine() {
		return origine;
	}


	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getAdults_number() {
		return adults_number;
	}

	public void setAdults_number(String adults_number) {
		this.adults_number = adults_number;
	}

	public String getchildren_age_number() {
		return children_age_number;
	}

	public void setchildren_age_number(String children_age_number) {
		this.children_age_number = children_age_number;
	}

	public String getFlight_class() {
		return flight_class;
	}

	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}

	public String getFlight_departure_hour() {
		return flight_departure_hour;
	}

	public void setFlight_departure_hour(String flight_departure_hour) {
		this.flight_departure_hour = flight_departure_hour;
	}

	public String getFlight_arrived_hour() {
		return flight_arrived_hour;
	}

	public void setFlight_arrived_hour(String flight_arrived_hour) {
		this.flight_arrived_hour = flight_arrived_hour;
	}

	public String getReturn_flight_departure_hour() {
		return return_flight_departure_hour;
	}

	public void setReturn_flight_departure_hour(String return_flight_departure_hour) {
		this.return_flight_departure_hour = return_flight_departure_hour;
	}

	public String getReturn_flight_arrived_hour() {
		return return_flight_arrived_hour;
	}

	public void setReturn_flight_arrived_hour(String return_flight_arrived_hour) {
		this.return_flight_arrived_hour = return_flight_arrived_hour;
	}

	public String getCompany_logo() {
		return company_logo;
	}

	public void setCompany_logo(String company_logo) {
		this.company_logo = company_logo;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getSecond_company_logo() {
		return second_company_logo;
	}

	public void setSecond_company_logo(String second_company_logo) {
		this.second_company_logo = second_company_logo;
	}

	public String getSecond_company_name() {
		return second_company_name;
	}

	public void setSecond_company_name(String second_company_name) {
		this.second_company_name = second_company_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStops_number() {
		return stops_number;
	}

	public void setStops_number(String stops_number) {
		this.stops_number = stops_number;
	}

	public String getSecond_stops_number() {
		return second_stops_number;
	}

	public void setSecond_stops_number(String second_stops_number) {
		this.second_stops_number = second_stops_number;
	}

	public String getFlight_duration() {
		return flight_duration;
	}

	public void setFlight_duration(String flight_duration) {
		this.flight_duration = flight_duration;
	}

	public String getSecond_flight_duration() {
		return second_flight_duration;
	}

	public void setSecond_flight_duration(String second_flight_duration) {
		this.second_flight_duration = second_flight_duration;
	}
	
	
	
	
	
	
}
