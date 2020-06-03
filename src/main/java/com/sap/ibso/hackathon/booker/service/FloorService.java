package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import com.sap.ibso.hackathon.booker.jpa.repo.FloorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class FloorService extends BookerEntityService<Floor> {

    private FloorRepository floorRepository;

    public FloorService(FloorRepository floorRepository) {
        super(floorRepository);
        this.floorRepository = floorRepository;
    }

    public Set<Floor> findByBuildingId(UUID buildingId) {
        return floorRepository.findByBuildingId(buildingId);
    }

    public Optional<Floor> findOptionalById(UUID floorId) {
        return floorRepository.findById(floorId);
    }
}
