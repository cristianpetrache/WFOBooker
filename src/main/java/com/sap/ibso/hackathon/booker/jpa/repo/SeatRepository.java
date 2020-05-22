package com.sap.ibso.hackathon.booker.jpa.repo;

import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
}
