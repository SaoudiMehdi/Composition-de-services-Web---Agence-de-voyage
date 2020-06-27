package Work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Beans.Currency;
import Beans.Hotel;

public class CurrencyForm {
	public static String API_KEY = "188208bbcbmsh1f60087e29ea967p182a61jsn786fd3b62bdb";
	public static ArrayList<Currency> CURRENCY_LIST = new ArrayList<Currency>();
	public static SettingsForm settings = new SettingsForm();


	/*
	 * PAY ATTENTION YOU DIDN'T USE ROOMS ATTRIBUTE YET 
	 */
	public static String convertCurrency(String amount, String from, String to, HttpServletRequest request) throws UnirestException, InterruptedException{
		
		/*ArrayList<String> Currency_from = getCurrencyName();
		ArrayList<String> Currency_to = getCurrencyName();

		//ApiKeySwitcher api_switch = new ApiKeySwitcher();
		//api_switch.SwitchAPI();
		
		System.out.println(Currency_from.get(0));
		System.out.println(Currency_to.get(0));*/
	    StringBuilder result;


		
		String url;
		String api;
		String rate = null;
	
			url ="https://currency-converter5.p.rapidapi.com/currency/convert?format=json&from="+from+"&to="+to+"&amount="+amount+"";
			api = "currency-converter5.p.rapidapi.com";
		    String API_KEY = "3b05458d0cmsh5d99c67eb7708cep1b8116jsnc9eb6470d605";
		
			
			
		    try {
				HttpResponse<JsonNode> response1 = Unirest.get(url)
						.header("x-rapidapi-host", api)
						.header("x-rapidapi-key", API_KEY)
						.asJson();
				JSONObject rates = response1.getBody().getArray().getJSONObject(0).getJSONObject("rates");
				//String currency_name = rates.getNames(rates)[0];
				rate = rates.getJSONObject(to).getString("rate_for_amount");
				System.out.println(rate);
							

						
				} catch (UnirestException e) {
					// TODO Auto-generated catch block

				}
					
		return rate;
	
}

	public static ArrayList<String> getCurrencyName() {
		// TODO Auto-generated method stub
		String API_KEY = "3b05458d0cmsh5d99c67eb7708cep1b8116jsnc9eb6470d605";

		
		HttpResponse<JsonNode> response;
		ArrayList<String> Currency_id = new ArrayList<String>() ;
		String url = "https://currency-converter5.p.rapidapi.com/currency/list?format=json";
		String api = "currency-converter5.p.rapidapi.com";
		try {
					response = Unirest.get(url)
					.header("x-rapidapi-host", api)
					.header("x-rapidapi-key", API_KEY)
					.asJson();

			JSONArray data = response.getBody().getArray();
			Set keys =  data.getJSONObject(0).getJSONObject("currencies").keySet();
			System.out.println(data);
			ArrayList<String> currencies = new ArrayList<String>();
			for(Iterator it = keys.iterator(); it.hasNext();) {
				String code_currencie=(String) it.next();
				String value_currencie=data.getJSONObject(0).getJSONObject("currencies").getString(code_currencie);
				Currency_id.add(value_currencie);
				System.out.println(value_currencie);

			}
			
			
			} catch (UnirestException e) {
			// TODO Auto-generated catch block
			
		}
		
		return Currency_id;
	}
	
	public static ArrayList<String> getCurrencyCode() {
		// TODO Auto-generated method stub
		String API_KEY = "3b05458d0cmsh5d99c67eb7708cep1b8116jsnc9eb6470d605";

		
		HttpResponse<JsonNode> response;
		ArrayList<String> Currency_code = new ArrayList<String>() ;
		String url = "https://currency-converter5.p.rapidapi.com/currency/list?format=json";
		String api = "currency-converter5.p.rapidapi.com";
		try {
					response = Unirest.get(url)
					.header("x-rapidapi-host", api)
					.header("x-rapidapi-key", API_KEY)
					.asJson();

			JSONArray data = response.getBody().getArray();
			Set keys =  data.getJSONObject(0).getJSONObject("currencies").keySet();
			System.out.println(data);
			ArrayList<String> currencies_code = new ArrayList<String>();
			for(Iterator it = keys.iterator(); it.hasNext();) {
				String code_currencie=(String) it.next();
				String value_currencie=data.getJSONObject(0).getJSONObject("currencies").getString(code_currencie);
				Currency_code.add(code_currencie);
				System.out.println(value_currencie);

			}
			
			
			} catch (UnirestException e) {
			// TODO Auto-generated catch block
			
		}
		
		return Currency_code;
	}
	
	
	
	

}
