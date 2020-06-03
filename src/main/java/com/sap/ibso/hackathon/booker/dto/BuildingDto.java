package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class BuildingDto {

    private UUID id;
    private String name;
    private String code;
    private double latitude;
    private double longitude;
    private String picture;
    private Set<FloorDto> floors;
}
