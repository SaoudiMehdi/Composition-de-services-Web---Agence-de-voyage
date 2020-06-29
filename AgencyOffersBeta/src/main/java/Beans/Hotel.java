package Beans;

public class Hotel {
	
	private String name;
	private String adresse;
	private String classe;
	private String reviews_number;
	private String stars_number;
	private String price_per_night;
	private String image_link;
	private boolean pool;
	private boolean wifi;
	private boolean restaurant;
	private boolean free_concellation;
	
	
	
	public Hotel(String name, String adresse, String classe, String reviews_number, String stars_number,
			String price_per_night,String image_link, boolean pool, boolean wifi, boolean restaurant,
			boolean free_concellation) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.classe = classe;
		this.reviews_number = reviews_number;
		this.stars_number = stars_number;
		this.price_per_night = price_per_night;
		this.image_link = image_link;
		this.pool = pool;
		this.wifi = wifi;
		this.restaurant = restaurant;
		this.free_concellation = free_concellation;
	}
	
	public Hotel() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getReviews_number() {
		return reviews_number;
	}
	public void setReviews_number(String reviews_number) {
		this.reviews_number = reviews_number;
	}
	public String getStars_number() {
		return stars_number;
	}
	public void setStars_number(String stars_number) {
		this.stars_number = stars_number;
	}
	public String getPrice_per_night() {
		return price_per_night;
	}
	public void setPrice_per_night(String price_per_night) {
		this.price_per_night = price_per_night;
	}
	public boolean ispool() {
		return pool;
	}
	public void setpool(boolean pool) {
		this.pool = pool;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isRestaurant() {
		return restaurant;
	}
	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}
	public boolean isFree_concellation() {
		return free_concellation;
	}
	public void setFree_concellation(boolean free_concellation) {
		this.free_concellation = free_concellation;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	
	


}
