package com.sap.ibso.hackathon.booker.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterDataDto {

	/*
	 * private Set<Seat> seats; private Set<Floor> floors; private Set<Building>
	 * buildings; private Set<Location> locations;
	 */
	
	private Set<LocationDto> locations;

}
