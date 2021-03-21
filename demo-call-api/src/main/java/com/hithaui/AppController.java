package com.hithaui;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@RestController
public class AppController {

	@GetMapping("/api/ncov")
	public ResponseEntity<?> getAllCountries() throws ClientProtocolException, IOException {
		final String URL = "https://ncov.trungbt.xyz/countries";
		Response response = Request.Get(URL).execute();

		String json = response.returnContent().toString();
		
		Moshi moshi = new Moshi.Builder().build();
		JsonAdapter<Country[]> jsonAdapter = moshi.adapter(Country[].class);
		Country[] countries = jsonAdapter.fromJson(json);
		return ResponseEntity.status(200).body(countries);
	}
}
