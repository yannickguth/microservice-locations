package de.cluster.microservices.locations.service;

import java.util.List;

import de.cluster.microservices.locations.controller.LocationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.cluster.microservices.locations.dao.LocationRepository;
import de.cluster.microservices.locations.model.Location;


@Service
public class LocationServiceImpl implements LocationService{

	private static final Logger LOG = LoggerFactory.getLogger(LocationController.class);


	@Autowired
	LocationRepository locationRepo;
	
	@Override
	public void createData(){	
		LOG.warn("/***USE FOR TESTS ONLY***/");
		LOG.info("creating locations ");
		LOG.warn("/***USE FOR TESTS ONLY***/");
		try {
			if(getLocations().size() == 0) {
				createLocation(0, "Jahrhunderthalle", "Sesamstraße", "42", "54123", "Bochum", "Deutschland");
				createLocation(1, "Kolosseum", "Emperial Street", "23", "864423", "Rom", "Italien");
				createLocation(2, "Himalaya", "Sesamstraße", "4242", "101474", "Himachel", "Indien");
				createLocation(3, "Port Royal", "Servesa Terrace", "112", "68768768", "Espaniol City", "Spanien");
				createLocation(4, "Bermuda Dreieck", "Sesamstraße", "43c", "54123", "Bochum", "Deutschland");
				createLocation(5, "Bermuda Dreieck", "Bahama Mama", "unkwnon", "unwon", "Bahamas", "Bahamas");
				createLocation(6, "KFC", "Sesamstraße", "42", "54123", "Bochum", "Deutschland");
				createLocation(7, "Eifelturm", "Sesamstraße", "42", "54123", "Bochum", "Deutschland");
				createLocation(8, "Ocean Tower", "Evergreen Terrace", "742", "54123", "Springfield", "United States of America");
				createLocation(9, "Ueno Park", "Shinobitzu", "17", "4w123", "Tokio", "Japan");
				createLocation(10, "Meji Shrine", "Tachidi Street", "18", "554123", "Tokio", "Japan");
			}
		} catch (Exception e) {
			LOG.error("Could not create Test Data");
		}
		LOG.info("Test Data created");
	}	
	
	@Override
	public Location getLocationById(long id){
		return locationRepo.findOne(id);
	}

	@Override
	public Location createLocation(long id, String name, String street,String housenumber,String postalcode,String city,String country) {
		return locationRepo.save(new Location(id,name,street,housenumber,postalcode,city,country));

	}
	
	@Override
	public Location updateLocation(long id, String name, String street,String housenumber,String postalcode,String city,String country) {
		return locationRepo.save(new Location(id,name,street,housenumber,postalcode,city,country));

	}
	
	@Override
	public Location deleteLocation(long id){
		Location tmp = locationRepo.findOne(id);
		locationRepo.delete(tmp);
		return	tmp;
	}

	@Override
	public List<Location> getLocations(){
		return (List<Location>) locationRepo.findAll();
	}

	@Override
	public Location updateLocation(Location location) {
		return locationRepo.save(location);
	}
}