package com.sap.ibso.hackathon.booker.validator;

import com.sap.ibso.hackathon.booker.exception.BookingException;
import com.sap.ibso.hackathon.booker.exception.UUIDEntityNotFoundException;
import com.sap.ibso.hackathon.booker.jpa.model.Booking;
import com.sap.ibso.hackathon.booker.jpa.model.Building;
import com.sap.ibso.hackathon.booker.jpa.model.Employee;
import com.sap.ibso.hackathon.booker.jpa.model.Floor;
import com.sap.ibso.hackathon.booker.jpa.model.Location;
import com.sap.ibso.hackathon.booker.jpa.model.Restriction;
import com.sap.ibso.hackathon.booker.jpa.model.Seat;
import com.sap.ibso.hackathon.booker.service.BookingService;
import com.sap.ibso.hackathon.booker.service.BuildingService;
import com.sap.ibso.hackathon.booker.service.EmployeeService;
import com.sap.ibso.hackathon.booker.service.FloorService;
import com.sap.ibso.hackathon.booker.service.LocationService;
import com.sap.ibso.hackathon.booker.service.RestrictionService;
import com.sap.ibso.hackathon.booker.service.SeatService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class BookingValidator implements Validator<Booking> {

    private BookingService bookingService;
    private RestrictionService restrictionService;
    private EmployeeService employeeService;
    private LocationService locationService;
    private BuildingService buildingService;
    private FloorService floorService;
    private SeatService seatService;

    public BookingValidator(BookingService bookingService,
                            RestrictionService restrictionService,
                            EmployeeService employeeService,
                            LocationService locationService,
                            BuildingService buildingService,
                            FloorService floorService, SeatService seatService) {
        this.bookingService = bookingService;
        this.restrictionService = restrictionService;
        this.employeeService = employeeService;
        this.locationService = locationService;
        this.buildingService = buildingService;
        this.floorService = floorService;
        this.seatService = seatService;
    }

    @Override
    public void validate(Booking element) {
        Employee employee = employeeService.findOptionalById(element.getEmployeeId())
                                           .orElseThrow(() -> new UUIDEntityNotFoundException(Employee.class));
        Seat seat = seatService.findOptionalBySeatId(element.getSeatId())
                               .orElseThrow(() -> new UUIDEntityNotFoundException(Seat.class));
        Optional<Booking> existingBookingOptional = bookingService
                .findOptionalBySeatIdAndDate(element.getSeatId(), element.getDate());
        if (existingBookingOptional.isPresent()) {
            employee = employeeService.findOptionalById(element.getEmployeeId())
                                      .orElseThrow(() -> new UUIDEntityNotFoundException(Employee.class));
            throw new BookingException("Seat code " + seat.getCode() + " is already booked on " +
                    element.getDate() + " by employee with code " + employee.getCode());
        }
        Set<Restriction> restrictionSet = restrictionService
                .findByEntityTypeAndEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                        "E", element.getEmployeeId(), element.getDate(), element.getDate());
        if (!restrictionSet.isEmpty()) {
            throw new BookingException("Employee with code " + employee.getCode() + " is not allowed to book on date " +
                    element.getDate() + " because: " + restrictionSet.stream().findAny().get().getComments());
        }
        restrictionSet = restrictionService
                .findByEntityTypeAndEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                        "S", element.getSeatId(), element.getDate(), element.getDate());
        if (!restrictionSet.isEmpty()) {
            throw new BookingException("Seat with code " + seat.getCode() + " is not allowed to be booked on date " +
                    element.getDate() + " because: " + restrictionSet.stream().findAny().get().getComments());
        }
        Floor floor = floorService.findOptionalById(seat.getFloorId())
                                  .orElseThrow(() -> new UUIDEntityNotFoundException(Floor.class));
        restrictionSet = restrictionService
                .findByEntityTypeAndEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                        "F", floor.getId(), element.getDate(), element.getDate());
        if (!restrictionSet.isEmpty()) {
            throw new BookingException("Floor " + floor.getName() + " is not allowed to be booked on date " +
                    element.getDate() + " because: " + restrictionSet.stream().findAny().get().getComments());
        }
        Building building = buildingService.findOptionalById(floor.getBuildingId())
                                           .orElseThrow(() -> new UUIDEntityNotFoundException(Building.class));
        restrictionSet = restrictionService
                .findByEntityTypeAndEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                        "B", building.getId(), element.getDate(), element.getDate());
        if (!restrictionSet.isEmpty()) {
            throw new BookingException("Building " + building.getName() + " is not allowed to be booked on date " +
                    element.getDate() + " because: " + restrictionSet.stream().findAny().get().getComments());
        }
        Location location = locationService.findOptionalById(building.getLocationId())
                                           .orElseThrow(() -> new UUIDEntityNotFoundException(Location.class));
        restrictionSet = restrictionService
                .findByEntityTypeAndEntityIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                        "L", location.getId(), element.getDate(), element.getDate());
        if (!restrictionSet.isEmpty()) {
            throw new BookingException("Location " + building.getName() + " is not allowed to be booked on date " +
                    element.getDate() + " because: " + restrictionSet.stream().findAny().get().getComments());
        }
    }
}
