package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDto {

    private String message;
}
