package com.sap.ibso.hackathon.booker.dto;

import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class FloorDto {

    private UUID id;
    private String name;
    private Set<SeatDto> seats;
}
