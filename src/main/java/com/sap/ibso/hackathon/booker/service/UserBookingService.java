package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.dto.BookingDto;
import com.sap.ibso.hackathon.booker.dto.UserBookingDto;
import com.sap.ibso.hackathon.booker.dto.UserBookingRequestDto;
import com.sap.ibso.hackathon.booker.exception.UUIDEntityNotFoundException;
import com.sap.ibso.hackathon.booker.jpa.model.Employee;
import com.sap.ibso.hackathon.booker.jpa.model.Manager;
import com.sap.ibso.hackathon.booker.jpa.model.Preference;
import com.sap.ibso.hackathon.booker.mapper.BookingMapper;
import com.sap.ibso.hackathon.booker.mapper.DateMapper;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserBookingService {

    // 28 days, four weeks, ~1 month
    private static final long MAX_DELTA_IN_MILLISECONDS = 1L * 1000 * 60 * 60 * 24 * 30;

    private EmployeeService employeeService;
    private BookingService bookingService;
    private LocationService locationService;
    private BuildingService buildingService;
    private FloorService floorService;
    private SeatService seatService;
    private PreferenceService preferenceService;
    private ExecutionContextHolderService executionContextHolderService;
    private ManagerService managerService;
    private BookingMapper bookingMapper;
    private DateMapper dateMapper;

    public UserBookingService(EmployeeService employeeService,
                              BookingService bookingService,
                              LocationService locationService,
                              BuildingService buildingService,
                              FloorService floorService, SeatService seatService,
                              PreferenceService preferenceService,
                              ExecutionContextHolderService executionContextHolderService,
                              ManagerService managerService,
                              BookingMapper bookingMapper, DateMapper dateMapper) {
        this.employeeService = employeeService;
        this.bookingService = bookingService;
        this.locationService = locationService;
        this.buildingService = buildingService;
        this.floorService = floorService;
        this.seatService = seatService;
        this.preferenceService = preferenceService;
        this.executionContextHolderService = executionContextHolderService;
        this.managerService = managerService;
        this.bookingMapper = bookingMapper;
        this.dateMapper = dateMapper;
    }

    public UserBookingDto getUserBooking(UserBookingRequestDto userBookingRequestDto) {
        Employee employee = employeeService.findOptionalByCode(userBookingRequestDto.getCode())
                                           .orElseThrow(() -> new UUIDEntityNotFoundException(Employee.class));
        Date startDate = getStartDate(userBookingRequestDto.getStartDate());
        Date endDate = getEndDate(startDate, userBookingRequestDto.getEndDate());
        executionContextHolderService.getExecutionContext().getLogger().info(
                "com.sap.ibso.hackathon.booker.service.UserBookingService.getUserBooking - setting start date to '" +
                        startDate + "' and end date to '" + endDate + "'");
        UserBookingDto userBookingDto = getUserBooking(employee, startDate, endDate);
        userBookingDto.setTeamReservations(getTeamReservations(employee.getId(), startDate, endDate));
        return userBookingDto;
    }

    private UserBookingDto getUserBooking(Employee employee, Date startDate, Date endDate) {
        Set<BookingDto> bookingSet = bookingService
                .getBookingsByEmployeeIdStartDateAndEndDate(employee.getId(), startDate, endDate)
                .stream()
                .map(bookingMapper::mapYtoZ)
                .collect(Collectors.toSet());
        Set<Preference> preferenceSet = preferenceService.findByEmployeeId(employee.getId());
        return UserBookingDto.builder()
                             .code(employee.getCode())
                             .name(employee.getName())
                             .preferences(preferenceSet)
                             .reservations(bookingSet)
                             .build();
    }

    private Date getEndDate(Date startDate, String endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long delta = 0;
        Date date = dateMapper.mapZtoY(endDate);
        if (date != null) {
            delta = date.getTime() - startDate.getTime();
        }
        if (date == null || delta < 0 || delta > MAX_DELTA_IN_MILLISECONDS) {
            calendar.add(Calendar.DATE, 7);
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                calendar.add(Calendar.DATE, 1);
            }
        } else {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    private Date getStartDate(String startDate) {
        Calendar calendar = Calendar.getInstance();
        Date date = dateMapper.mapZtoY(startDate);
        if (date == null) {
            while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                calendar.add(Calendar.DATE, -1);
            }
        } else {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private Set<UserBookingDto> getTeamReservations(UUID userId, Date startDate, Date endDate) {
        Optional<Manager> managerOptional = managerService.findOptionalByEntityTypeAndEntityId("E", userId);
        if (!managerOptional.isPresent()) {
            return Collections.emptySet();
        }
        Set<Manager> managerSet = managerService
                .findByEntityTypeAndEmployeeId("E", managerOptional.get().getEmployeeId());
        return managerSet.stream()
                         .map(Manager::getEntityId)
                         .filter(employeeId -> !userId.equals(employeeId))
                         .map(employeeService::findOptionalById)
                         .filter(Optional::isPresent)
                         .map(Optional::get)
                         .map(employee -> getUserBooking(employee, startDate, endDate))
                         .collect(Collectors.toSet());
    }
}
