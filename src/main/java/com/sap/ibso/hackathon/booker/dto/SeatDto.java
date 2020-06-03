package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SeatDto {

    private UUID id;
    private String code;
}
