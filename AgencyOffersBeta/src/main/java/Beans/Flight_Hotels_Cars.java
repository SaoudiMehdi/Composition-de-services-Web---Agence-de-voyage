package Beans;

public class Flight_Hotels_Cars {
	
	private Flight flight;
	private Hotel hotel;
	private Car car;
	private double price_of_agence;
	
	
	
	public Flight_Hotels_Cars(Flight flight, Hotel hotel, Car car, double price_fixed_by_our_agency) {
		super();
		this.flight = flight;
		this.hotel = hotel;
		this.setCar(car);
		this.price_of_agence = price_fixed_by_our_agency;
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

	public double getPrice_of_agence() {
		return price_of_agence;
	}

	public void setPrice_of_agence(int price_of_agence) {
		this.price_of_agence = price_of_agence;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
