package com.sap.ibso.hackathon.booker.jpa.repo;

import com.sap.ibso.hackathon.booker.jpa.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface BuildingRepository extends JpaRepository<Building, UUID> {

    Set<Building> findByLocationId(UUID locationId);
}
