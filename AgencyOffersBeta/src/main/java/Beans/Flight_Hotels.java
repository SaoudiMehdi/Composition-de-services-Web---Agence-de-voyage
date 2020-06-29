package Beans;

public class Flight_Hotels {
	
	private Flight flight;
	private Hotel hotel;
	private int price_of_agence;
	
	
	
	public Flight_Hotels(Flight flight, Hotel hotel, int price_of_agence) {
		super();
		this.flight = flight;
		this.hotel = hotel;
		this.price_of_agence = price_of_agence;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getPrice_of_agence() {
		return price_of_agence;
	}

	public void setPrice_of_agence(int price_of_agence) {
		this.price_of_agence = price_of_agence;
	}
	
	
}
