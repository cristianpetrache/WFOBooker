package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Building;
import com.sap.ibso.hackathon.booker.jpa.repo.BuildingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class BuildingService extends BookerEntityService<Building> {

    private BuildingRepository buildingRepository;

    public BuildingService(
            JpaRepository<Building, UUID> jpaRepository,
            BuildingRepository buildingRepository) {
        super(jpaRepository);
        this.buildingRepository = buildingRepository;
    }

    public Set<Building> findByLocationId(UUID locationID) {
        return buildingRepository.findByLocationId(locationID);
    }

    public Optional<Building> findOptionalById(UUID buildingId) {
        return buildingRepository.findById(buildingId);
    }
}
