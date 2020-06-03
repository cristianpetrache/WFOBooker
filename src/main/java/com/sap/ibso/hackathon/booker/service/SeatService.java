package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import com.sap.ibso.hackathon.booker.jpa.repo.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class SeatService extends BookerEntityService<Seat> {

    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        super(seatRepository);
        this.seatRepository = seatRepository;
    }

    public Set<Seat> findByFloorId(UUID floorId) {
        return seatRepository.findByFloorId(floorId);
    }

    public Optional<Seat> findOptionalBySeatId(UUID seatId) {
        return seatRepository.findById(seatId);
    }
}
