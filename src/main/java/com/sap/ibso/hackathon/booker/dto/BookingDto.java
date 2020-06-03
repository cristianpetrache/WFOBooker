package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookingDto {

    private UUID id;
    private UUID seatId;
    private String date;
    private String comments;
    private String locationText;
}
