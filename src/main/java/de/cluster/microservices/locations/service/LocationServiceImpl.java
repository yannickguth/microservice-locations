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
				createLocation(0, "Jahrhunderthalle", "An der Jahrhunderthalle", "1", "44793", "Bochum", "Deutschland");
				createLocation(1, "Silent Sinners", "Rittershausstraße", "65", "44137", "Dortmund", "Deutschland");
				createLocation(2, "Hochschule Bochum", "Lennershofstraße", "140", "44801", "Bochum", "Deutschland");
				createLocation(3, "Times Square Visitors Center", "W 44th St", "1", "10036", "New York City", "United States");
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
		Location loc = locationRepo.findOne(id);
		locationRepo.delete(loc);
		return	loc;
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