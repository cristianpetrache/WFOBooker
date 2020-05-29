package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PreferenceDto {

    public enum PreferenceType {
        LOCATION,
        BUILDING,
        FLOOR,
        SEAT
    }

    private PreferenceType type;
    private UUID entityId;
}
