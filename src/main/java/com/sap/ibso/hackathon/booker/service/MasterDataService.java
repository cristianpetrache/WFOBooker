package com.sap.ibso.hackathon.booker.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.sap.ibso.hackathon.booker.dto.LocationDto;
import com.sap.ibso.hackathon.booker.dto.MasterDataDto;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;

@Service
public class MasterDataService {

	private LocationService locationService;

	public MasterDataService(LocationService locationService) {
		this.locationService = locationService;

	}

	public MasterDataDto getMasterData(PageRequest arg) {

		Set<LocationDto> locations = new HashSet<LocationDto>();

		locations = locationService.getLocations();

		return MasterDataDto.builder().locations(locations).build();
	}

}
