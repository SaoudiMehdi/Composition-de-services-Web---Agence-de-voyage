package Work;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class ApiKeySwitcher{

	String API_KEYS[] = {"e12ffdaff2msh461d986ced90372p105bc4jsn406f229ccbe5",
			"ce77bfacafmshc587b77938e05c9p17b0a9jsn067bc6318ab4",
			"21a75fc268mshde5069c6650e78fp17df39jsn165d334c01db",
			"559d8c70a3msh7f6d4afb93a48dcp1efe98jsn75b09616a1ca"};

	public ApiKeySwitcher() {

	}

	public void SwitchAPI() {
		// TODO Auto-generated method stub
		for(int i=0; i<API_KEYS.length ; i++) {
			try {
				if(searchingValidAPI(i)) break;
			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	private synchronized boolean  searchingValidAPI(int i) throws UnirestException {
		// TODO Auto-generated method stub
		String url = "https://tripadvisor1.p.rapidapi.com/locations/search?location_id=1&limit=30&sort=relevance&offset=0&lang=fr_FR&currency=MAD&units=km&query=Rabat";
		String api = "tripadvisor1.p.rapidapi.com";
		HttpResponse<JsonNode> response = Unirest.get(url)
				.header("x-rapidapi-host", api)
				.header("x-rapidapi-key", API_KEYS[i])
				.asJson();
		if(!response.getBody().getArray().getJSONObject(0).has("message")) {
			HotelsForm.API_KEY = API_KEYS[i];
			return true;
		}
		System.out.println("api : "+HotelsForm.API_KEY );

		return false;
	}

}
