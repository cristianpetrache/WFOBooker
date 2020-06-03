package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.dto.BuildingDto;
import com.sap.ibso.hackathon.booker.dto.FloorDto;
import com.sap.ibso.hackathon.booker.dto.LocationDto;
import com.sap.ibso.hackathon.booker.dto.MasterDataDto;
import com.sap.ibso.hackathon.booker.dto.SeatDto;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.mapper.BuildingMapper;
import com.sap.ibso.hackathon.booker.mapper.FloorMapper;
import com.sap.ibso.hackathon.booker.mapper.LocationMapper;
import com.sap.ibso.hackathon.booker.mapper.SeatMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MasterDataService {

    private LocationService locationService;
    private BuildingService buildingService;
    private FloorService floorService;
    private SeatService seatService;
    private LocationMapper locationMapper;
    private BuildingMapper buildingMapper;
    private FloorMapper floorMapper;
    private SeatMapper seatMapper;

    public MasterDataService(LocationService locationService,
                             BuildingService buildingService,
                             FloorService floorService, SeatService seatService,
                             LocationMapper locationMapper,
                             BuildingMapper buildingMapper, FloorMapper floorMapper,
                             SeatMapper seatMapper) {
        this.locationService = locationService;
        this.buildingService = buildingService;
        this.floorService = floorService;
        this.seatService = seatService;
        this.locationMapper = locationMapper;
        this.buildingMapper = buildingMapper;
        this.floorMapper = floorMapper;
        this.seatMapper = seatMapper;
    }

    public MasterDataDto getMasterData() {
        return MasterDataDto
                .builder()
                .locations(getLocations())
                .build();
    }

    private Set<LocationDto> getLocations() {
        return locationService
                .getAll(PageRequest.getFirst1K())
                .getContent()
                .stream()
                .map(location -> {
                    LocationDto locationDto = locationMapper.mapYtoZ(location);
                    locationDto.setBuildings(getBuildings(location.getId()));
                    return locationDto;
                })
                .collect(Collectors.toSet());
    }

    private Set<BuildingDto> getBuildings(UUID locationId) {
        return buildingService
                .findByLocationId(locationId)
                .stream()
                .map(building -> {
                    BuildingDto buildingDto = buildingMapper.mapYtoZ(building);
                    buildingDto.setFloors(getFloors(building.getId()));
                    return buildingDto;
                })
                .collect(Collectors.toSet());
    }

    private Set<FloorDto> getFloors(UUID buildingId) {
        return floorService
                .findByBuildingId(buildingId)
                .stream()
                .map(floor -> {
                    FloorDto floorDto = floorMapper.mapYtoZ(floor);
                    floorDto.setSeats(getSeats(floor.getId()));
                    return floorDto;
                })
                .collect(Collectors.toSet());
    }

    private Set<SeatDto> getSeats(UUID floorId) {
        return seatService
                .findByFloorId(floorId)
                .stream()
                .map(seatMapper::mapYtoZ)
                .collect(Collectors.toSet());
    }
}
