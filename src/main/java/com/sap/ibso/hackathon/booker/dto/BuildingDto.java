package com.sap.ibso.hackathon.booker.dto;

import java.util.Set;

import com.sap.ibso.hackathon.booker.jpa.model.Building;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingDto {

	private Building building;
	private Set<FloorDto> floors;

}
