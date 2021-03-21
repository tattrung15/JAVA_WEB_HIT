package com.hithaui;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@SpringBootApplication
public class DemoCallApiApplication {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		SpringApplication.run(DemoCallApiApplication.class, args);

		final String URL = "https://ncov.trungbt.xyz/countries";
		Response response = Request.Get(URL).execute();

		String json = response.returnContent().toString();
		
		//json simple
//		List<Country> countries = new LinkedList<Country>();
//		JSONArray jsonArray = (JSONArray) JSONValue.parse(json);
//		for (int i = 0; i < jsonArray.size(); i++) {
//			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//
//			Country country = new Country(jsonObject.get("Country_Region"), jsonObject.get("Confirmed"),
//					jsonObject.get("Deaths"), jsonObject.get("Recovered"));
//			countries.add(country);
//		}
//		
//		countries.forEach(System.out::println);
		
		//moshi
//		Moshi moshi = new Moshi.Builder().build();
//		JsonAdapter<Country[]> jsonAdapter = moshi.adapter(Country[].class);
//		Country[] countries = jsonAdapter.fromJson(json);
//		
//		for (Country country : countries) {
//			System.out.println(country);
//		}
	}

}
