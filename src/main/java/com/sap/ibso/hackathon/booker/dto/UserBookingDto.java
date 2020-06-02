package com.sap.ibso.hackathon.booker.dto;

import com.sap.ibso.hackathon.booker.jpa.model.Preference;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserBookingDto {

    private String code;
    private String name;
    private Set<Preference> preferences;
    private Set<BookingDto> reservations;
    private Set<UserBookingDto> teamReservations;
}
