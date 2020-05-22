package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocationService extends BookerEntityService<Location> {

    public LocationService(JpaRepository<Location, UUID> locationRepository) {
        super(locationRepository);
    }
}
