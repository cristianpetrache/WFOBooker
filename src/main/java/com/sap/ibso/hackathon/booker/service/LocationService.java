package com.sap.ibso.hackathon.booker.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sap.ibso.hackathon.booker.dto.BuildingDto;
import com.sap.ibso.hackathon.booker.dto.FloorDto;
import com.sap.ibso.hackathon.booker.dto.LocationDto;
import com.sap.ibso.hackathon.booker.dto.SeatDto;
import com.sap.ibso.hackathon.booker.jpa.model.Building;
import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import com.sap.ibso.hackathon.booker.jpa.model.Location;
import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import com.sap.ibso.hackathon.booker.jpa.repo.LocationRepository;

@Service
public class LocationService extends BookerEntityService<Location> {

	private LocationRepository locationRepository;
	private BuildingService buildingService;
	private FloorService floorService;
	private SeatService seatService;

	public LocationService(LocationRepository locationRepository, BuildingService buildingService,
			FloorService floorService, SeatService seatService) {
		super(locationRepository);
		this.locationRepository = locationRepository;
		this.buildingService = buildingService;
		this.floorService = floorService;
		this.seatService = seatService;
	}

	public Set<LocationDto> getLocations() {
		List<Seat> seats = new ArrayList<>();
		List<Floor> floors = new ArrayList<>();
		List<Building> buildings = new ArrayList<>();
		Set<LocationDto> locations = new HashSet<>();
		Set<BuildingDto> buildingDto = new HashSet<>();
		Set<FloorDto> floorDto = new HashSet<>();

		List<Location> allLocations = locationRepository.findAll();
		for (Location location : allLocations) {
			buildings = buildingService.getBuildingsByLocation(location.getId());
			for (Building building : buildings) {
				floors = floorService.getFloorsByBuilding(building.getId());
				for (Floor floor : floors) {
					seats = seatService.getSeatsByFloor(floor.getId());
					floorDto.add(FloorDto.builder().floor(floor).seats(SeatDto.seat(seats)).build());
				}
				buildingDto.add(BuildingDto.builder().building(building).floors(floorDto).build());
			}
			locations.add(LocationDto.builder().location(location).buildings(buildingDto).build());
		}

		return locations;
	}
}
