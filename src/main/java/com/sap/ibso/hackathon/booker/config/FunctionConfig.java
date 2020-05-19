package com.sap.ibso.hackathon.booker.config;

import com.sap.ibso.hackathon.booker.jpa.model.Location;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.service.LocationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

@Configuration
public class FunctionConfig {

    private LocationService locationService;

    public FunctionConfig(LocationService locationService) {
        this.locationService = locationService;
    }

    @Bean
    public Function<PageRequest, Page<Location>> getLocations() {
        return pageRequest -> locationService.getAll(pageRequest);
    }

    @Bean
    public Function<List<Location>, List<Location>> postLocations() {
        return createLocationList -> locationService.createAll(createLocationList);
    }
}
