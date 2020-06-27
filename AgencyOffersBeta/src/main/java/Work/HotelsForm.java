package Work;

import java.awt.Image;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Beans.Hotel;

public class HotelsForm {

	public static String API_KEY = "ce77bfacafmshc587b77938e05c9p17b0a9jsn067bc6318ab4";
	public static ArrayList<Hotel> HOTELS_LIST = new ArrayList<Hotel>();

	/*
	 * PAY ATTENTION YOU DIDN'T USE ROOMS ATTRIBUTE YET
	 */
	public ArrayList<Hotel> getHotels(String city,String checkIn, String nights, String adults, String children, String rooms, String hotel_option) throws UnirestException, InterruptedException{

		ArrayList<String> location_id = getLocationIdsByCity(city);
		ApiKeySwitcher api_switch = new ApiKeySwitcher();
		//api_switch.SwitchAPI();



		//creating request information
		String url;
		String api;

		if(location_id.size()==0)return null;
		System.out.println(location_id.get(0));
		url = "https://tripadvisor1.p.rapidapi.com/hotels/list?offset=0&currency=USD&limit=30&order=asc&lang=en_US&sort="+hotel_option+"&location_id="
				+ ""+location_id.get(0)+"&adults="+adults+"&checkin="+checkIn+"&rooms="+rooms+"&nights="+nights;
		System.out.println("my url : "+ url);
		api = "tripadvisor1.p.rapidapi.com";
		if(!API_KEY.isEmpty()) {
			HttpResponse<JsonNode> response;
			try {
				response = Unirest.get(url)
						.header("x-rapidapi-host", api)
						.header("x-rapidapi-key", HotelsForm.API_KEY)
						.asJson();

				if(response.getBody().getArray().getJSONObject(0).has("message")) {
					api_switch.SwitchAPI();
					response = Unirest.get(url)
							.header("x-rapidapi-host", api)
							.header("x-rapidapi-key", HotelsForm.API_KEY)
							.asJson();

				}else {
					//Thread fill_thread = new FillingHotelInfo(response);
					//fill_thread.start();
					fillInHotels(response);

				}
			} catch (UnirestException e) {
				// TODO Auto-generated catch block

			}
		}
		//if(i%4==0 && i!=0) TimeUnit.SECONDS.sleep(1);


		return HOTELS_LIST;
	}




	public ArrayList<String> getLocationIdsByCity(String city) {
		// TODO Auto-generated method stub
		ApiKeySwitcher api_switch = new ApiKeySwitcher();
		//api_switch.SwitchAPI();
		//API_KEY = "4ae6120e67mshe23371b4ad2e806p1f2a9bjsnedfd935a0104";

		HttpResponse<JsonNode> response;
		ArrayList<String> location_id = new ArrayList<String>() ;
		String url = "https://tripadvisor1.p.rapidapi.com/locations/search?location_id=1&limit=30&sort=relevance&offset=0&lang=en_US&currency=USD&units=km&query="+city;
		String api = "tripadvisor1.p.rapidapi.com";
		System.out.println("location url : "+url);
		try {
			response = Unirest.get(url)
					.header("x-rapidapi-host", api)
					.header("x-rapidapi-key", API_KEY)
					.asJson();
			if(response.getBody().getArray().getJSONObject(0).has("message")) {
				api_switch.SwitchAPI();
				response = Unirest.get(url)
						.header("x-rapidapi-host", api)
						.header("x-rapidapi-key", API_KEY)
						.asJson();
			}
			JSONArray data = response.getBody().getArray().getJSONObject(0).getJSONArray("data");
			int dataLength = data.length();
			System.out.println("how many id: "+dataLength);
			for(int i=0;i<dataLength;i++) {
				String elementName = data.getJSONObject(i).getString("result_type");
				System.out.println(elementName+" "+data.getJSONObject(i).getJSONObject("result_object").getString("location_id")+" "+data.getJSONObject(i).getJSONObject("result_object").getString("name"));
				if(elementName.equalsIgnoreCase("geos")&& data.getJSONObject(i).getJSONObject("result_object").getString("name").toLowerCase().contains(city.toLowerCase())) {
					location_id.add(data.getJSONObject(i).getJSONObject("result_object").getString("location_id"));
				}
			}
		} catch (UnirestException e) {
			// TODO Auto-generated catch block

		}

		return location_id;
	}



	private void fillInHotels(HttpResponse<JsonNode> response) {
		// TODO Auto-generated method stub

		JSONArray data = response.getBody().getArray().getJSONObject(0).getJSONArray("data");
		int dataLength = data.length();
		int dataNumber = 9;
		if(dataLength<dataNumber) dataNumber = dataLength;
		System.out.println("dataLenght : "+dataNumber);
		for(int i=0;i<dataNumber;i++) {

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
			if(hotelDescription.has("num_reviews")) reviews_number = hotelDescription.getString("num_reviews");

			//5
			String stars_number = "-";
			if(hotelDescription.has("rating")) stars_number = hotelDescription.getString("rating");

			//6
			if(!hotelDescription.has("price")) continue;
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
			//Thread searchResponse = new SearchResponse(name,adresse,classe,reviews_number,stars_number,price_per_night,image_link,pool,wifi,restaurent,free_concellation,data,i);
			//searchResponse.start();
			checkAmenities(name,adresse,classe,reviews_number,stars_number,price_per_night,image_link,pool,wifi,restaurent,free_concellation,data,i);



			//if(body.has("roomsAndRates"))
			//free_concellation = body.getJSONObject("roomsAndRates").getJSONArray("rooms").getJSONObject(0).getJSONArray("ratePlans").getJSONObject(0).getJSONObject("cancellation").getBoolean("free");


			//addNewHotel(name,adresse,classe,reviews_number,stars_number,price_per_night,image_link,pool,wifi,restaurent,free_concellation);

		}

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
