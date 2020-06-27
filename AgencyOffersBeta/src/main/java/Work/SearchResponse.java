package Work;

import java.util.concurrent.TimeUnit;

import org.json.JSONArray;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Beans.Hotel;

public class SearchResponse extends Thread{


	HttpResponse<JsonNode> response;
	String name;
	String adresse;
	String classe;
	String reviews_number;
	String stars_number;
	String price_per_night;
	String image_link;
	boolean air_condition;
	boolean wifi;
	boolean restaurent;
	boolean free_concellation;
	JSONArray data;
	int i;








	public SearchResponse(String name, String adresse, String classe,
						  String reviews_number, String stars_number, String price_per_night, String image_link,
						  boolean air_condition, boolean wifi, boolean restaurent, boolean free_concellation, JSONArray data, int i) {
		super();
		this.name = name;
		this.adresse = adresse;
		this.classe = classe;
		this.reviews_number = reviews_number;
		this.stars_number = stars_number;
		this.price_per_night = price_per_night;
		this.image_link = image_link;
		this.air_condition = air_condition;
		this.wifi = wifi;
		this.restaurent = restaurent;
		this.free_concellation = free_concellation;
		this.data = data;
		this.i = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		checkAmenities(name,adresse,classe,reviews_number,stars_number,price_per_night,image_link,air_condition,wifi,restaurent,free_concellation,data,i);



	}

	private synchronized void checkAmenities(String name, String adresse, String classe, String reviews_number, String stars_number, String price_per_night, String image_link, boolean air_condition, boolean wifi, boolean restaurent, boolean free_concellation, JSONArray data, int i) {
		// TODO Auto-generated method stub
		String url = "https://tripadvisor1.p.rapidapi.com/hotels/get-details?currency=USD&lang=en_US&location_id="+data.getJSONObject(i).getString("location_id");

		HttpResponse<JsonNode> response3;

		try {

			response3 = Unirest.get(url)
					.header("x-rapidapi-host", "tripadvisor1.p.rapidapi.com")
					.header("x-rapidapi-key", HotelsForm.API_KEY)
					.asJson();
			JSONArray amenities = response3.getBody().getArray().getJSONObject(0).getJSONArray("data").getJSONObject(0).getJSONArray("amenities");
			int k=3;
			for(int j=0;j<amenities.length();j++) {
				if(k!=0 && amenities.getJSONObject(j).getString("name").contains("Internet")) {
					wifi = true;
					k--;
				}
				if(k!=0 && amenities.getJSONObject(j).getString("name").contains("Pool")) {
					air_condition =true;
					k--;
				}
				if(k!=0 && amenities.getJSONObject(j).getString("name").contains("Restaurant")) {
					restaurent = true;
					k--;
				}
				if(k==0) {
					break;
				}
			}

		} catch (UnirestException e) {
			// TODO Auto-generated catch block

		}
		HotelsForm.HOTELS_LIST.add(new Hotel(name,adresse,classe,reviews_number,stars_number,price_per_night,image_link,air_condition,wifi,restaurent,free_concellation));



	}

}
