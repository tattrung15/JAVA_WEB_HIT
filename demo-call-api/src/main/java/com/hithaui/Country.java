package com.hithaui;

public class Country {
	private String Country_Region;
	private String Confirmed;
	private String Deaths;
	private String Recovered;

	public Country() {

	}

	public Country(Object countryRegion, Object confirmed, Object deaths, Object recovered) {
		super();
		this.Country_Region = countryRegion.toString();
		this.Confirmed = confirmed.toString();
		this.Deaths = deaths.toString();
		this.Recovered = recovered.toString();
	}

	public String getCountryRegion() {
		return Country_Region;
	}

	public void setCountryRegion(String countryRegion) {
		this.Country_Region = countryRegion;
	}

	public String getConfirmed() {
		return Confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.Confirmed = confirmed;
	}

	public String getDeaths() {
		return Deaths;
	}

	public void setDeaths(String deaths) {
		this.Deaths = deaths;
	}

	public String getRecovered() {
		return Recovered;
	}

	public void setRecovered(String recovered) {
		this.Recovered = recovered;
	}

	@Override
	public String toString() {
		return "Country [countryRegion=" + Country_Region + ", confirmed=" + Confirmed + ", deaths=" + Deaths
				+ ", recovered=" + Recovered + "]";
	}
}
