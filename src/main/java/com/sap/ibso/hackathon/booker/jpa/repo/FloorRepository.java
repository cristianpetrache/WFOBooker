package com.sap.ibso.hackathon.booker.jpa.repo;

import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FloorRepository extends JpaRepository<Floor, UUID> {
}
