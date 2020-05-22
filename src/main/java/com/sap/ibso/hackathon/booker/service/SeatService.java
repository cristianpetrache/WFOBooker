package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SeatService extends BookerEntityService<Seat> {

    public SeatService(JpaRepository<Seat, UUID> seatRepository) {
        super(seatRepository);
    }
}
