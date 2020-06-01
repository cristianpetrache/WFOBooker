package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBookingRequestDto {

    private String code;
    private String startDate;
    private String endDate;
}
