package Beans;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "car")

public class Car implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name="id_car")
	private int id_car;
	@Column(name="city")
	private String city;
	@Column(name="brand")
	private String brand;
	@Column(name="seat_number")
	private String seat_number;
	@Column(name="air_conditioner")
	private String air_conditioner;
	@Column(name="rating")
	private String rating;
	@Column(name="image_link")
	private String image_link;
	@Column(name="price_per_day")
	private String price_per_duration;
	//champ important, il est lie aux contraintes clients, l'annotation est juste pour pre-remplir le champ
	@Column(name="day_max")
	private int day_number = 0;




	/*public Car(int id_car, String brand, String city, String seat_number, String air_conditioner, String rating,
			   String image_link, String price_per_duration) {
		super();
		this.id_car = id_car;
		this.brand = brand;
		this.city = city;
		this.seat_number = seat_number;
		this.air_conditioner = air_conditioner;
		this.rating = rating;
		this.image_link = image_link;
		this.price_per_duration = price_per_duration;
	}*/



	public Car(int id_car, String brand, String city, String seat_number, String air_conditioner, String rating,
			String image_link, String price_per_duration, int day_number) {
		super();
		this.id_car = id_car;
		this.brand = brand;
		this.city = city;
		this.seat_number = seat_number;
		this.air_conditioner = air_conditioner;
		this.rating = rating;
		this.image_link = image_link;
		this.price_per_duration = price_per_duration;
		this.day_number = day_number;
	}

	public Car(){

	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}
	public String getAir_conditioner() {
		return air_conditioner;
	}
	public void setAir_conditioner(String air_conditioner) {
		this.air_conditioner = air_conditioner;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public String getPrice_per_duration() {
		return price_per_duration;
	}
	public void setPrice_per_duration(String price_per_duration) {
		this.price_per_duration = price_per_duration;
	}

	public int getDay_number() {
		return day_number;
	}

	public void setDay_number(int day_number) {
		this.day_number = day_number;
	}

	public int getId_car() {
		return id_car;
	}

	public void setId_car(int id_car) {
		this.id_car = id_car;
	}
}
