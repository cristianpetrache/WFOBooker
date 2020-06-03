package com.sap.ibso.hackathon.booker.mapper;

import com.sap.ibso.hackathon.booker.dto.FloorDto;
import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import org.springframework.stereotype.Service;

@Service
public class FloorMapper implements Mapper<Floor, FloorDto> {

    @Override
    public Floor mapZtoY(FloorDto floorDto) {
        Floor floor = new Floor();
        floor.setId(floorDto.getId());
        floor.setName(floorDto.getName());
        return floor;
    }

    @Override
    public FloorDto mapYtoZ(Floor floor) {
        return FloorDto
                .builder()
                .id(floor.getId())
                .name(floor.getName())
                .build();
    }
}
