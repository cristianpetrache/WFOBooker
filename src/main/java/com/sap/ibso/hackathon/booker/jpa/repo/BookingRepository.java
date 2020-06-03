package com.sap.ibso.hackathon.booker.jpa.repo;

import com.sap.ibso.hackathon.booker.jpa.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {

    Set<Booking> findByEmployeeIdAndDateBetween(UUID employeeId, Date startDate, Date endDate);

    Optional<Booking> findOptionalBySeatIdAndDate(UUID seatId, Date date);
}
