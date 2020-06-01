package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserBookingDto {

    private String code;
    private String name;
    private Set<PreferenceDto> preferences;
    private Set<BookingDto> reservations;
    private Set<UserBookingDto> teamReservations;
}
