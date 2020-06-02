package com.sap.ibso.hackathon.booker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import com.sap.ibso.hackathon.booker.jpa.repo.FloorRepository;

@Service
public class FloorService extends BookerEntityService<Floor> {

	private FloorRepository floorRepository;

	public FloorService(FloorRepository floorRepository) {
		super(floorRepository);
		this.floorRepository = floorRepository;
	}

	public Optional<Floor> findOptionalFirstById() {
		return floorRepository.findFirstByOrderByIdAsc();
	}

	public ArrayList<Floor> getFloorsByBuilding(UUID buildingId) {
		return floorRepository.findById(buildingId).map(Arrays::asList).map(ArrayList::new).orElseGet(ArrayList::new);
	}
}
