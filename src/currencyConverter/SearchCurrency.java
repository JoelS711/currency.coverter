package currencyConverter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class SearchCurrency {

	public Currency consultCurrency(String base_code) {
		URI url = URI.create("https://v6.exchangerate-api.com/v6/cfd6c05c3e99003b06d3ab99/latest/"+base_code);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(url).build();
		
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			//System.out.println("Rta: "+response.body());
			return new Gson().fromJson(response.body(), Currency.class);
		} catch (IOException e) {
		    throw new RuntimeException("Network error: " + e.getMessage());
		} catch (InterruptedException e) {
		    throw new RuntimeException("Request was interrupted: " + e.getMessage());
		} catch (JsonSyntaxException e) {
		    throw new RuntimeException("Response body is not a valid JSON: " + e.getMessage());
		}
	}
}
