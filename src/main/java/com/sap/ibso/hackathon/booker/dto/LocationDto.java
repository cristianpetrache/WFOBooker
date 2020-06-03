package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class LocationDto {

    private UUID id;
    private String name;
    private double latitude;
    private double longitude;
    private String picture;
    private Set<BuildingDto> buildings;
}
