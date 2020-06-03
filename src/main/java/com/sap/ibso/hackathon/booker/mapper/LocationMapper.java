package com.sap.ibso.hackathon.booker.mapper;

import com.sap.ibso.hackathon.booker.dto.LocationDto;
import com.sap.ibso.hackathon.booker.jpa.model.Location;
import org.springframework.stereotype.Service;

@Service
public class LocationMapper implements Mapper<Location, LocationDto> {
    @Override
    public Location mapZtoY(LocationDto locationDto) {
        Location location = new Location();
        location.setId(locationDto.getId());
        location.setName(locationDto.getName());
        location.setLatitude(locationDto.getLatitude());
        location.setLongitude(locationDto.getLongitude());
        location.setPicture(locationDto.getPicture());
        return location;
    }

    @Override
    public LocationDto mapYtoZ(Location location) {
        return LocationDto
                .builder()
                .id(location.getId())
                .name(location.getName())
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .picture(location.getPicture())
                .build();
    }
}
