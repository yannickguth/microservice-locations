package de.cluster.microservices.locations.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.cluster.microservices.locations.model.Location;
import de.cluster.microservices.locations.service.LocationService;

@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@RestController
public class LocationController {

	private static final Logger LOG = LoggerFactory.getLogger(LocationController.class);

	@Autowired
	LocationService locationService;
	
	/**
	 * Returns all Location
	 * @return
	 */
	@RequestMapping(value = "/locations", method = RequestMethod.GET)
	public ResponseEntity<List<Location>> getAllLocations() {
		LOG.info("Fetching all Location");
		return new ResponseEntity<>(locationService.getLocations(), HttpStatus.OK);
	}

	/**
	 * Getting Location with id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/locations/{id}", method = RequestMethod.GET)
	public ResponseEntity<Location> getLocation(@PathVariable Long id) {
		LOG.info("fetching location["+id+"]");
		Location location = locationService.getLocationById(id);
		if(location == null) {
			LOG.warn("Location Not Found["+id+"]");
			return new ResponseEntity<>((Location) null,HttpStatus.NOT_FOUND);
		}
		LOG.info("location found["+location+"]");
		return new ResponseEntity<Location>(location,HttpStatus.OK);
	}

	/**
	 * Create Location
	 */					
	@RequestMapping(value = "/locations", method = RequestMethod.POST)
	public ResponseEntity<Location> createLocation(
			@RequestBody Location location) {
		LOG.info("creating location["+location+"]");
		return new ResponseEntity<Location> (location,HttpStatus.CREATED);
	}
	

	/**
	 * Deleting Location with id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/locations/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Location> deleteLocation(@PathVariable Long id) {
		LOG.info("delete location[id="+id+"]");
		return new ResponseEntity<Location>(locationService.deleteLocation(id),HttpStatus.OK);
	}
	
	
	/**
	 * update Location
	 * @param location
	 * @return
	 */
	@RequestMapping(value = "/locations", method = RequestMethod.PUT)
	public ResponseEntity<Location> updateLocation(@RequestBody Location location){
		LOG.info("updating location["+location+"]");
		return new ResponseEntity<Location>( locationService.updateLocation(location),HttpStatus.OK);
	}


}