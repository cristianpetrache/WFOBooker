package com.sap.ibso.hackathon.booker.config;

import com.sap.ibso.hackathon.booker.jpa.model.Booking;
import com.sap.ibso.hackathon.booker.jpa.model.Building;
import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import com.sap.ibso.hackathon.booker.jpa.model.Location;
import com.sap.ibso.hackathon.booker.jpa.model.PageRequest;
import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import com.sap.ibso.hackathon.booker.service.BookingService;
import com.sap.ibso.hackathon.booker.service.BuildingService;
import com.sap.ibso.hackathon.booker.service.FloorService;
import com.sap.ibso.hackathon.booker.service.LocationService;
import com.sap.ibso.hackathon.booker.service.SeatService;
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
    private SeatService seatService;
    private FloorService floorService;
    private BookingService bookingService;

    public FunctionConfig(LocationService locationService,
                          BuildingService buildingService, SeatService seatService,
                          FloorService floorService, BookingService bookingService) {
        this.locationService = locationService;
        this.buildingService = buildingService;
        this.seatService = seatService;
        this.floorService = floorService;
        this.bookingService = bookingService;
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

    @Bean
    public Function<PageRequest, Page<Floor>> getFloors() {
        return pageRequest -> floorService.getAll(pageRequest);
    }

    @Bean
    public Function<List<Floor>, List<Floor>> postFloors() {
        return createFloorList -> floorService.createAll(createFloorList);
    }

    @Bean
    public Function<List<UUID>, List<Floor>> deleteFloors() {
        return deleteFloorIdList -> floorService.deleteAll(deleteFloorIdList);
    }

    @Bean
    public Function<PageRequest, Page<Seat>> getSeats() {
        return pageRequest -> seatService.getAll(pageRequest);
    }

    @Bean
    public Function<List<Seat>, List<Seat>> postSeats() {
        return createSeatList -> seatService.createAll(createSeatList);
    }

    @Bean
    public Function<List<UUID>, List<Seat>> deleteSeats() {
        return deleteSeatIdList -> seatService.deleteAll(deleteSeatIdList);
    }

    @Bean
    public Function<PageRequest, Page<Booking>> getBookings() {
        return pageRequest -> bookingService.getAll(pageRequest);
    }

    @Bean
    public Function<List<Booking>, List<Booking>> postBookings() {
        return createBookingList -> bookingService.createAll(createBookingList);
    }

    @Bean
    public Function<List<UUID>, List<Booking>> deleteBookings() {
        return deleteBookingIdList -> bookingService.deleteAll(deleteBookingIdList);
    }
}
