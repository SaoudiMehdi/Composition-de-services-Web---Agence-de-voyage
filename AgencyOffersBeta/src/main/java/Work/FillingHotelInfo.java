package Work;

import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import Beans.Hotel;

public class FillingHotelInfo extends Thread {

	HttpResponse<JsonNode> response;


	public FillingHotelInfo(HttpResponse<JsonNode> response) {
		super();
		this.response = response;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub

		fillInHotels(response);

	}



	private void fillInHotels(HttpResponse<JsonNode> response) {
		// TODO Auto-generated method stub

		JSONArray data = response.getBody().getArray().getJSONObject(0).getJSONArray("data");
		int dataLength = data.length();
		int dataNumber = 9;
		if(dataLength<dataNumber) dataNumber = dataLength;

		for(int i=0;i<dataNumber;i++) {

			if((i+1)%3==0) {
				try {
					TimeUnit.MILLISECONDS.sleep(7000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(i);
			JSONObject hotelDescription = data.getJSONObject(i);
			//1
			String name = hotelDescription.getString("name");

			//2
			String adresse = hotelDescription.getString("location_string");

			//3
			String classe = hotelDescription.getString("hotel_class");

			//4
			String reviews_number = "-";
			reviews_number = hotelDescription.getString("num_reviews");

			//5
			String stars_number = "-";
			stars_number = hotelDescription.getString("rating");

			//6
			String price_per_night = hotelDescription.getString("price");

			//image link
			String image_link = hotelDescription.getJSONObject("photo").getJSONObject("images").getJSONObject("medium").getString("url");


			//7
			boolean pool = false;

			//8
			boolean wifi = false;

			//9

			boolean restaurent = false;

			//10
			boolean free_concellation = false;
			Thread searchResponse = new SearchResponse(name,adresse,classe,reviews_number,stars_number,price_per_night,image_link,pool,wifi,restaurent,free_concellation,data,i);
			searchResponse.start();



			//if(body.has("roomsAndRates"))
			//free_concellation = body.getJSONObject("roomsAndRates").getJSONArray("rooms").getJSONObject(0).getJSONArray("ratePlans").getJSONObject(0).getJSONObject("cancellation").getBoolean("free");


			//addNewHotel(name,adresse,classe,reviews_number,stars_number,price_per_night,image_link,pool,wifi,restaurent,free_concellation);

		}

	}


}
