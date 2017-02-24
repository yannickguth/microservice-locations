package de.cluster.microservices.locations.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.cluster.microservices.locations.model.Location;

@Service
public interface LocationService {
	
	public void createData();

	public Location deleteLocation(long id);

	public Location updateLocation(long id, String name, String street,String housenumber,String postalcode,String city,String country);

	public Location createLocation(long id, String name, String street,String housenumber,String postalcode,String city,String country);

	public Location getLocationById(long id);
	
	public List<Location> getLocations();

	public Location updateLocation(Location location);
}
