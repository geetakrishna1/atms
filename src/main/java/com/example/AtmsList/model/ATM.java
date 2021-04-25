package com.example.AtmsList.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ATM {
	
	@JsonProperty("address")
	private Address address;
	@JsonProperty("distance")
	private int distance;
	@JsonProperty("functionality")
	private String functionality;
	@JsonProperty("type")
	private String type;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getFunctionality() {
		return functionality;
	}
	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "ATM [address=" + address + ", distance=" + distance + ", functionality=" + functionality + ", type="
				+ type + "]";
	}

	
	
}
