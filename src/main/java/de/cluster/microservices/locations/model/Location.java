package de.cluster.microservices.locations.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location implements Serializable{

	public Location(long id, String name, String street, String housenumber, String postalcode, String city, String country) {
		this.setId(id);
		this.setName(name);
		this.setStreet(street);
		this.setHousenumber(housenumber);
		this.setPostalcode(postalcode);
		this.setCity(city);
		this.setCountry(country);
	}

	private static final long serialVersionUID = 1L;
	@Id
	private long id;

	private String name;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String street;
	private String housenumber;
	private String postalcode;
	private String city;
	private String country;


}
