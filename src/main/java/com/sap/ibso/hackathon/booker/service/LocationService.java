package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Location;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LocationService {

    private JpaRepository<Location, UUID> locationRepository;

    public LocationService(JpaRepository<Location, UUID> locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Transactional(readOnly = true)
    public Page<Location> getAll(PageRequest pageRequest) {
        Pageable pageable = pageRequest.getPageable();
        System.err.println(pageable);
        return locationRepository.findAll(pageable);
    }

    public List<Location> createAll(List<Location> createLocationList) {
        return locationRepository.saveAll(createLocationList);
    }
}
