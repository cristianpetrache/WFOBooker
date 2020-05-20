package com.sap.ibso.hackathon.booker.config;

import com.sap.ibso.hackathon.booker.jpa.model.Building;
import com.sap.ibso.hackathon.booker.jpa.model.Location;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.service.BuildingService;
import com.sap.ibso.hackathon.booker.service.LocationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Configuration
public class FunctionConfig {

    private LocationService locationService;
    private BuildingService buildingService;

    public FunctionConfig(LocationService locationService,
                          BuildingService buildingService) {
        this.locationService = locationService;
        this.buildingService = buildingService;
    }

    @Bean
    public Function<PageRequest, Page<Location>> getLocations() {
        return pageRequest -> locationService.getAll(pageRequest);
    }

    @Bean
    public Function<List<Location>, List<Location>> postLocations() {
        return createLocationList -> locationService.createAll(createLocationList);
    }

    @Bean
    public Function<List<UUID>, List<Location>> deleteLocations() {
        return deleteLocationIdList -> locationService.deleteAll(deleteLocationIdList);
    }

    @Bean
    public Function<PageRequest, Page<Building>> getBuildings() {
        return pageRequest -> buildingService.getAll(pageRequest);
    }

    @Bean
    public Function<List<Building>, List<Building>> postBuildings() {
        return createBuildingList -> buildingService.createAll(createBuildingList);
    }

    @Bean
    public Function<List<UUID>, List<Building>> deleteBuildings() {
        return deleteBuildingIdList -> buildingService.deleteAll(deleteBuildingIdList);
    }
}
