package com.sap.ibso.hackathon.booker.mapper;

import com.sap.ibso.hackathon.booker.dto.BuildingDto;
import com.sap.ibso.hackathon.booker.jpa.model.Building;
import org.springframework.stereotype.Service;

@Service
public class BuildingMapper implements Mapper<Building, BuildingDto> {

    @Override
    public Building mapZtoY(BuildingDto buildingDto) {
        Building building = new Building();
        building.setId(buildingDto.getId());
        building.setCode(buildingDto.getCode());
        building.setName(buildingDto.getName());
        building.setLatitude(buildingDto.getLatitude());
        building.setLongitude(buildingDto.getLongitude());
        building.setPicture(buildingDto.getPicture());
        return building;
    }

    @Override
    public BuildingDto mapYtoZ(Building building) {
        return BuildingDto
                .builder()
                .id(building.getId())
                .code(building.getCode())
                .name(building.getName())
                .latitude(building.getLatitude())
                .longitude(building.getLongitude())
                .picture(building.getPicture())
                .build();
    }
}
