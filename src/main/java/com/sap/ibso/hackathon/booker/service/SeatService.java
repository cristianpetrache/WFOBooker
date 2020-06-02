package com.sap.ibso.hackathon.booker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import com.sap.ibso.hackathon.booker.jpa.repo.SeatRepository;

@Service
public class SeatService extends BookerEntityService<Seat> {

	private SeatRepository seatRepository;

	public SeatService(SeatRepository seatRepository) {
		super(seatRepository);
		this.seatRepository = seatRepository;
	}

	public Optional<Seat> findOptionalFirstById() {
		return seatRepository.findFirstByOrderByIdAsc();
	}

	public ArrayList<Seat> getSeatsByFloor(UUID floorId) {
		return seatRepository.findById(floorId).map(Arrays::asList).map(ArrayList::new).orElseGet(ArrayList::new);
	}
}
