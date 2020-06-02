package com.sap.ibso.hackathon.booker.dto;

import java.util.Set;

import com.sap.ibso.hackathon.booker.jpa.model.Floor;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FloorDto {

	private Floor floor;
	private Set<SeatDto> seats;

}
