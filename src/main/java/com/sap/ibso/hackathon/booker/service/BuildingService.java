package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuildingService extends BookerEntityService<Building> {

    public BuildingService(JpaRepository<Building, UUID> buildingRepository) {
        super(buildingRepository);
    }
}
