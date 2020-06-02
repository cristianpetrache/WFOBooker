package com.sap.ibso.hackathon.booker.dto;

import java.util.Set;

import com.sap.ibso.hackathon.booker.jpa.model.Location;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {

	private Location location;
	private Set<BuildingDto> buildings;

}
