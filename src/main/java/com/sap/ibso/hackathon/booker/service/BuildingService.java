package com.sap.ibso.hackathon.booker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sap.ibso.hackathon.booker.jpa.model.Building;
import com.sap.ibso.hackathon.booker.jpa.repo.BuildingRepository;

@Service
public class BuildingService extends BookerEntityService<Building> {

	private BuildingRepository buildingRepository;

	public BuildingService(BuildingRepository buildingRepository) {
		super(buildingRepository);
		this.buildingRepository = buildingRepository;
	}

	public ArrayList<Building> getBuildingsByLocation(UUID locationId) {
		return buildingRepository.findById(locationId).map(Arrays::asList).map(ArrayList::new)
				.orElseGet(ArrayList::new);
	}
}
