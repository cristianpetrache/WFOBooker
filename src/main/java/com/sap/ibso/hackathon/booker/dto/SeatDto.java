package com.sap.ibso.hackathon.booker.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.ibso.hackathon.booker.jpa.model.Seat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatDto {

	private Seat seat;

	public static Set<SeatDto> seat(List<Seat> seats) {
		Set<SeatDto> result = new HashSet<SeatDto>();
		for (Seat seat : seats) {
			result.add(SeatDto.builder().seat(seat).build());
		}
		return result;
	}
}
