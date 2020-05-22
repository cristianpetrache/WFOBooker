package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FloorService extends BookerEntityService<Floor> {

    public FloorService(JpaRepository<Floor, UUID> floorRepository) {
        super(floorRepository);
    }
}
