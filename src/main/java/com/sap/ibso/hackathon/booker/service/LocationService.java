package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Location;
import com.sap.ibso.hackathon.booker.jpa.repo.LocationRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LocationService extends BookerEntityService<Location> {

    private LocationRepository locationRepository;

    public LocationService(
            JpaRepository<Location, UUID> jpaRepository,
            LocationRepository locationRepository) {
        super(jpaRepository);
        this.locationRepository = locationRepository;
    }

    public Optional<Location> findOptionalById(UUID locationId) {
        return locationRepository.findById(locationId);
    }
}
