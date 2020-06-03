package com.sap.ibso.hackathon.booker.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class MasterDataDto {

    private Set<LocationDto> locations;
}
