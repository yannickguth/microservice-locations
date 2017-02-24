package de.cluster.microservices.locations.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.cluster.microservices.locations.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{
}
