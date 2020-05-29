package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Booking;
import com.sap.ibso.hackathon.booker.jpa.repo.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Service
public class BookingService extends BookerEntityService<Booking> {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        super(bookingRepository);
        this.bookingRepository = bookingRepository;
    }

    public Set<Booking> getBookingsByEmployeeIdStartDateAndEndDate(
            UUID employeeId, Date startDate, Date endDate) {
        return bookingRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate);
    }
}
