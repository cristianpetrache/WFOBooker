package com.sap.ibso.hackathon.booker.service;

import com.sap.ibso.hackathon.booker.jpa.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService extends BookerEntityService<Booking> {

    public BookingService(JpaRepository<Booking, UUID> bookingRepository) {
        super(bookingRepository);
    }
}
